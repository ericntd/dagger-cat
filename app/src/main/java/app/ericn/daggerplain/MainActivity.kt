package app.ericn.daggerplain

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity(), MainView {
    @RequestDependency
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (application as MyApp).injector
        val mainActivityComponent = appComponent
            .plusMainActivityInjector(MainActivityInjector.MainActivityDependencyHolder(this))
        mainActivityComponent.injectInto(this)

        setContentView(R.layout.activity_main)

        presenter.attach()

        val fragment = ChildFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
    }

    override fun displayCat(imageUrl: String) {
        val imageView = findViewById<ImageView>(R.id.image)
        Glide.with(imageView).load("${BuildConfig.BASE_URL}$imageUrl").into(imageView)
    }
}