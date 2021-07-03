package app.ericn.daggerplain

import dagger.Module
import dagger.Subcomponent

@Subcomponent(modules = [ChildFragmentComponent.ChildFragmentModule::class])
interface ChildFragmentComponent {
    // injection targets
    fun inject(fragment: ChildFragment)

    @Module
    class ChildFragmentModule(childFragment: ChildFragment) {

    }
}