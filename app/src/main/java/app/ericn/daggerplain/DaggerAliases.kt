package app.ericn.daggerplain
import dagger.Component
import dagger.Module
import dagger.Subcomponent
import javax.inject.Inject
import javax.inject.Singleton

class DaggerAliases {
}

typealias AppScope = Singleton
typealias Contribute = Inject
typealias DependencyHolder = Module
typealias Injector = Component
typealias SubInjector = Subcomponent
/**
 * This is optional, as long [Contribute] and "injectInto" methods are clear, this won't be needed
 */
typealias RequestDependency = Inject