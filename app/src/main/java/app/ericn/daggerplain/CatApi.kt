package app.ericn.daggerplain

import io.reactivex.Single
import retrofit2.http.GET

interface CatApi {
    @GET("/cat?json=true")
    fun getCat() : Single<CatResponse>
}