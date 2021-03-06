package app.ericn.daggerplain

import dagger.Component
import javax.inject.Singleton


@Component(modules = [CatModule::class, ContextModule::class])
@Singleton
interface MyAppComponent {
    fun mainActivityComponent(mainActivityModule: MainActivityComponent.MainActivityModule): MainActivityComponent
}