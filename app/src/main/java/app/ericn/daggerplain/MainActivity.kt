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
        appComponent.inject(this)
//        val mainActivityModule = MainActivityComponent.MainActivityModule(this)
//        val mainActivityComponent = appComponent
//                .mainActivityComponent(mainActivityModule)
//        mainActivityComponent.inject(this)

        setContentView(R.layout.activity_main)

        presenter.attach()
    }

    override fun displayCat(imageUrl: String) {
        val imageView = findViewById<ImageView>(R.id.image)
        Glide.with(imageView).load("${BuildConfig.BASE_URL}$imageUrl").into(imageView)
    }
}