package app.ericn.daggerplain


@Injector(modules = [CatDependencyHolder::class, ContextDependencyHolder::class])
@AppScope
interface MyAppInjector {
    /**
     * Incorporate the dependencies in [ChildFragmentInjector.ChildFragmentDependencyHolder] into the larger dependency graph of MainActivity
     */
    fun plus(mainActivityDependencyHolder: MainActivityInjector.MainActivityDependencyHolder): MainActivityInjector
}