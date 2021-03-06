package app.ericn.daggerplain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var catRespository: CatRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as MyApp).component.inject(this)

        setContentView(R.layout.activity_main)

        catRespository.getCat()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                println("got cat! ${it.url}")
            }, {
                Log.e("MainActivity", "problem getting cat", it)
            })
    }
}