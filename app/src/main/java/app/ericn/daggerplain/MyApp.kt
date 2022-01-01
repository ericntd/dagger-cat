package app.ericn.daggerplain

import android.app.Application

class MyApp : Application() {
    lateinit var injector: MyAppInjector;

    override fun onCreate() {
        super.onCreate();
        injector = DaggerMyAppInjector.builder()
            .contextDependencyHolder(ContextDependencyHolder(this))
            .build();
    }
}