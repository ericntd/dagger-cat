package app.ericn.daggerplain

import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityComponent.MainActivityModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)

    @Module
    class MainActivityModule(private val mainActivity: MainActivity) {

        @Provides
        fun presenter(catRepository: CatRepository): MainPresenter {
            return MainPresenter(catRepository, mainActivity)
        }
    }
}