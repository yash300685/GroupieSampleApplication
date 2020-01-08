package com.test.groupiesample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_movie_list.*

import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module

/**
 * A simple [Fragment] subclass.
 */
val fragmentModule= module { factory { MovieListFragment() } }
class MovieListFragment : Fragment() {
   private  val viewModel:TVViewModel by viewModel()
    val adapter by lazy { GroupAdapter<GroupieViewHolder>()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.adapter=adapter
        model.layoutManager= LinearLayoutManager(activity)

    }
    override fun onResume() {
        super.onResume()


        viewModel.tvResult.observe(this, observer)
    }

    private val observer=Observer<ShowResult<Any>> {
        when(it.status)
        {
            Status.SUCCESS->
            {
                progress.visibility=View.GONE
                model.visibility=View.VISIBLE
                val model=(it.value as TvUiModel)
                for(x in model.tvList)
                {
                    adapter.add(TvItem(x.name,x.posterPath))
                }
            }
            Status.FAILURE->
            {

                Toast.makeText(activity, (it.value as String), Toast.LENGTH_LONG).show()
            }

            Status.LOADING->
            {
                progress.visibility=View.VISIBLE
            }
        }
    }



}
