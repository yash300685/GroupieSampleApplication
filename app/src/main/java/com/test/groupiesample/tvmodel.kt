package com.test.groupiesample

data class tvmodel(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)

fun tvmodel.toTVUIMOdel():TvUiModel
{
   val list:List<TvResult> = results.map{TvResult(it.name,it.poster_path)}
    return TvUiModel(list)
}
