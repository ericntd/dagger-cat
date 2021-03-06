package app.ericn.daggerplain

import android.app.Application

class MyApp : Application() {
    lateinit var component: MyAppComponent;

    override fun onCreate() {
        super.onCreate();
        component = DaggerMyAppComponent.builder()
            .contextModule(ContextModule(this))
            .build();
    }
}