package app.ericn.daggerplain

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatRepository @Inject constructor(private val api: CatApi) {
    fun getCat(): Single<CatResponse> {
        return api.getCat()
            .subscribeOn(Schedulers.io())
    }
}