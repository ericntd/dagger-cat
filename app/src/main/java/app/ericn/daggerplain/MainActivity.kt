package app.ericn.daggerplain

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {
    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (application as MyApp).component
        val mainActivityModule = MainActivityComponent.MainActivityModule(this)
        val component = DaggerMainActivityComponent.builder()
            .myAppComponent(appComponent)
            .mainActivityModule(mainActivityModule)
            .build()
        component.registerAndroidEntryPoint(this)

        setContentView(R.layout.activity_main)

        presenter.attach()

        val fragment = ChildFragment.newInstance("", "")
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
    }

    override fun displayCat(imageUrl: String) {
        val imageView = findViewById<ImageView>(R.id.image)
        Glide.with(imageView).load("${BuildConfig.BASE_URL}$imageUrl").into(imageView)
    }
}