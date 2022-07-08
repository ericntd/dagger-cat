package app.ericn.daggerplain

import dagger.Component
import dagger.Module
import javax.inject.Scope

@Component(modules = [ChildFragmentComponent.ChildFragmentModule::class], dependencies = [MainActivityComponent::class])
@PerFragment
interface ChildFragmentComponent {
    /**
     * Allow [ChildFragment] can then request dependency from the graph using @Inject
     */
    fun registerAndroidEntryPoint(childFragment: ChildFragment)

    @Module
    class ChildFragmentModule {

    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerFragment