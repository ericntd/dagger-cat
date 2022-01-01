package app.ericn.daggerplain
import dagger.Component
import dagger.Module
import dagger.Subcomponent
import javax.inject.Inject
import javax.inject.Singleton

typealias AppScope = Singleton
/**
 * For automatic service discovery or provision outside of [DependencyHolder]/ Module
 */
typealias Contribute = Inject
/**
 * Alternatively "DependencyGroup" or "CompositionRoot"
 */
typealias DependencyHolder = Module
typealias Injector = Component
/**
 * Alternatively "InjectorPart"
 */
typealias SubInjector = Subcomponent
/**
 * This is not very critical as long as [Contribute] and "injectInto" methods are clear
 */
typealias RequestDependency = Inject