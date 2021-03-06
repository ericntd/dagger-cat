package app.ericn.daggerplain

import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatService @Inject constructor(private val api: CatApi) {
    fun getCat(): Single<CatResponse> {
        return api.getCat()
    }
}