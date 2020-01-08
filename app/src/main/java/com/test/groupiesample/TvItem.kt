package com.test.groupiesample


import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.tv_list_item.view.*


class TvItem(private val name:String,private val image:String): Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.tv.text=name

        Picasso.get().load("https://image.tmdb.org/t/p/w500$image").resize(200, 200)
            .centerCrop().into( viewHolder.itemView.imageview)


    }

    override fun getLayout(): Int {

        return R.layout.tv_list_item
    }


}