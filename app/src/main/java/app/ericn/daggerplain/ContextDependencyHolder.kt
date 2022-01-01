package app.ericn.daggerplain

import android.content.Context
import dagger.Provides

@DependencyHolder
class ContextDependencyHolder(private val appContext: Context) {
    @Provides
    fun appContext(): Context = appContext;
}