package app.ericn.daggerplain

@SubInjector(modules = [ChildFragmentInjector.ChildFragmentDependencyHolder::class])
interface ChildFragmentInjector {
    /**
     * The entry points can then dependency using @RequestDependency or @Inject
     */
    fun registerAndroidEntryPoint(fragment: ChildFragment)

    @DependencyHolder
    class ChildFragmentDependencyHolder(childFragment: ChildFragment) {
        // Dependencies that depend on ChildFragment e.g. StringProvider, Presenter
    }
}