package app.ericn.daggerplain

import dagger.Provides

@SubInjector(modules = [MainActivityInjector.MainActivityDependencyHolder::class])
@PerActivity
interface MainActivityInjector {
    /**
     * The entry points can then dependency using @RequestDependency or @Inject
     */
    fun registerAndroidEntryPoint(mainActivity: MainActivity)

    /**
     * Incorporate the dependencies in [ChildFragmentInjector.ChildFragmentDependencyHolder] into the larger dependency graph of MainActivity
     */
    fun plus(childFragmentDependencyHolder: ChildFragmentInjector.ChildFragmentDependencyHolder): ChildFragmentInjector

    @DependencyHolder
    class MainActivityDependencyHolder(private val mainActivity: MainActivity) {

        @Provides
        @PerActivity
        fun presenter(catRepository: CatRepository): MainPresenter {
            return MainPresenter(catRepository, mainActivity)
        }
    }
}