package app.ericn.daggerplain

import android.content.Context
import dagger.Component
import javax.inject.Singleton


@Component(modules = [CatModule::class, ContextModule::class])
@Singleton
interface MyAppComponent {
    fun appContext(): Context
    fun catApi() : CatApi
    fun catService() : CatService
    fun catRepository() : CatRepository
//    fun mainActivityComponent(mainActivityModule: MainActivityComponent.MainActivityModule): MyAppComponent
    fun inject(mainActivity: MainActivity)
}