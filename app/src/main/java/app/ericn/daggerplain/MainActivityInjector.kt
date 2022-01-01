package app.ericn.daggerplain

import dagger.Provides

@SubInjector(modules = [MainActivityInjector.MainActivityDependencyHolder::class])
@PerActivity
interface MainActivityInjector {
    // injection targets
    fun injectInto(mainActivity: MainActivity)

    // aka. plus
    fun plusFragmentInjector(childFragmentDependencyHolder: ChildFragmentInjector.ChildFragmentDependencyHolder): ChildFragmentInjector

    @DependencyHolder
    class MainActivityDependencyHolder(private val mainActivity: MainActivity) {

        @Provides
        @PerActivity
        fun presenter(catRepository: CatRepository): MainPresenter {
            return MainPresenter(catRepository, mainActivity)
        }
    }
}