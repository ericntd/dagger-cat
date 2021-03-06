package app.ericn.daggerplain

data class CatApiResponseItem(
    val breeds: List<Any>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)