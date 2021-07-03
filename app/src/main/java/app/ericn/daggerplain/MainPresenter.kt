package app.ericn.daggerplain

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

interface MainView {
    fun displayCat(imageUrl: String)
}

/**
 * Dagger can't automatically figure out [MainView] dependency
 * Hence this is provided in [MainActivityComponent.MainActivityModule]
 * instead of constructor <code>@Inject</code>
 *
 * @param view can't be provided automatically via constructor injection, check out [MainActivityComponent.MainActivityModule]
 */
class MainPresenter @Inject constructor(private val repository: CatRepository) {
//class MainPresenter(private val repository: CatRepository, private val view: MainView) {

    @SuppressLint("CheckResult")
    fun attach() {
        repository.getCat()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                           Log.i(TAG, "success! ${it.url}")
//                    view.displayCat(it.url)
                }, {
                    Log.e(TAG, "error", it)
                })
    }

    companion object {
        private const val TAG = "MainPresenter"
    }
}