package app.ericn.daggerplain

data class CatResponse(
    val created_at: String,
    val id: String,
    val tags: List<Any>,
    val url: String
)