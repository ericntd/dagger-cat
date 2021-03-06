package app.ericn.daggerplain

import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatRepository @Inject constructor(private val service: CatService) {
    fun getCat(): Single<CatResponse> {
        return service.getCat()
    }
}