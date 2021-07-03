package app.ericn.daggerplain

import dagger.Component
import dagger.Module
import dagger.Provides
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope
import javax.inject.Singleton

@Component(modules = [MainActivityComponent.MainActivityModule::class])
//@Singleton
@PerActivity
interface MainActivityComponent {
//    fun catApi() : CatApi
//    fun catService() : CatService
//    fun catRepository() : CatRepository

//    fun inject(mainActivity: MainActivity)

    @Module(subcomponents = [])
    class MainActivityModule(private val mainActivity: MainActivity) {

//        @Provides
////        @PerActivity
////        @Singleton
//        fun presenter(catRepository: CatRepository): MainPresenter {
//            return MainPresenter(catRepository, mainActivity)
//        }
    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity