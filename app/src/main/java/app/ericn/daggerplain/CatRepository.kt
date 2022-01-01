package app.ericn.daggerplain

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

@AppScope
class CatRepository @Contribute constructor(private val api: CatApi) {
    fun getCat(): Single<CatResponse> {
        return api.getCat()
            .subscribeOn(Schedulers.io())
    }
}