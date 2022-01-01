package app.ericn.daggerplain

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers

interface MainView {
    fun displayCat(imageUrl: String)
}

/**
 * Dagger can't automatically figure out [MainView] dependency
 * Hence this is provided in [MainActivityInjector.MainActivityDependencyHolder]
 * instead of constructor <code>@Inject</code>
 *
 * @param view can't be provided automatically via constructor injection, check out [MainActivityInjector.MainActivityDependencyHolder]
 */
class MainPresenter(private val repository: CatRepository, private val view: MainView) {
    @SuppressLint("CheckResult")
    fun attach() {
        repository.getCat()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.displayCat(it.url)
            }, {
                Log.e("MainPresenter", "", it)
            })
    }
}