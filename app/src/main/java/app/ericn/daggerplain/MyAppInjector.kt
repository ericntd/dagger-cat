package app.ericn.daggerplain


@Injector(modules = [CatDependencyHolder::class, ContextDependencyHolder::class])
@AppScope
interface MyAppInjector {
    // aka. plus
    fun plusMainActivityInjector(mainActivityDependencyHolder: MainActivityInjector.MainActivityDependencyHolder): MainActivityInjector
}