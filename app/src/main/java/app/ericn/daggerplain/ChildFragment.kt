package app.ericn.daggerplain

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [ChildFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChildFragment : Fragment() {
    private val textView by lazy {
        requireView().findViewById<TextView>(R.id.the_view)
    }

    @Inject
    lateinit var catRepository: CatRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val activity = activity as MainActivity
        val appComponent = (activity.application as MyApp).component
        val mainActivityComponent = appComponent
            .mainActivityComponent(MainActivityComponent.MainActivityModule(activity))
        val fragmentComponent = mainActivityComponent.fragmentComponent(ChildFragmentComponent.ChildFragmentModule(this))
        fragmentComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        catRepository.getCat()
            .subscribe( {
                Log.d(TAG, "success ${it.url}")
//                textView.text = it.id
            }, {
                Log.e(TAG, "failure", it)
            })
    }

    companion object {
        private const val TAG = "ChildFragment"

        @JvmStatic
        fun newInstance() = ChildFragment()
    }
}