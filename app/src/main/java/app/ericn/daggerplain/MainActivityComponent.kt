package app.ericn.daggerplain

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Component(
    modules = [MainActivityComponent.MainActivityModule::class],
    dependencies = [MyAppComponent::class]
)
@PerActivity
interface MainActivityComponent {
    /**
     * Allow [MainActivity] can then request dependency from the graph using @Inject
     */
    fun registerAndroidEntryPoint(mainActivity: MainActivity)

    fun expoCatRepo(): CatRepository

    @Module()
    class MainActivityModule(private val mainActivity: MainActivity) {

        @Provides
        @PerActivity
        fun presenter(catRepository: CatRepository): MainPresenter {
            return MainPresenter(catRepository, mainActivity)
        }
    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity