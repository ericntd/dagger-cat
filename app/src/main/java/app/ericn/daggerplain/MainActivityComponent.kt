package app.ericn.daggerplain

import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityComponent.MainActivityModule::class])
@PerActivity
interface MainActivityComponent {
    // injection targets
    fun inject(mainActivity: MainActivity)

    // aka. plus
    fun fragmentComponent(childFragmentModule: ChildFragmentComponent.ChildFragmentModule): ChildFragmentComponent

    @Module
    class MainActivityModule(private val mainActivity: MainActivity) {

        @Provides
        @PerActivity
        fun presenter(catRepository: CatRepository): MainPresenter {
            return MainPresenter(catRepository, mainActivity)
        }
    }
}