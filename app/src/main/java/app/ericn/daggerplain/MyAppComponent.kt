package app.ericn.daggerplain

import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton


@Component(modules = [CatModule::class, ContextModule::class])
@Singleton
interface MyAppComponent { // nothing here initially
    fun inject(mainActivity: MainActivity)
    fun catRepository() : CatRepository
}