package app.ericn.daggerplain

@SubInjector(modules = [ChildFragmentInjector.ChildFragmentDependencyHolder::class])
interface ChildFragmentInjector {
    // injection targets
    fun injectInto(fragment: ChildFragment)

    @DependencyHolder
    class ChildFragmentDependencyHolder(childFragment: ChildFragment) {
        // Dependencies that depend on ChildFragment e.g. StringProvider, Presenter
    }
}