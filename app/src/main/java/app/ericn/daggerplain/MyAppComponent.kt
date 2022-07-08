package app.ericn.daggerplain

import android.content.Context
import dagger.Component
import javax.inject.Singleton


@Component(modules = [CatModule::class, ContextModule::class])
@Singleton
interface MyAppComponent {
    /*
    Expose dependencies for children
     */
    fun exposeAppContext(): Context
    fun exposeCatRepository() : CatRepository
}