package keijumt.feature1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import keijumt.dynamicfeature.di.ViewModelFactory
import keijumt.feature1.di.Injector
import keijumt.feature1.ui.Feature1ViewModel
import javax.inject.Inject

class Feature1Fragment : Fragment() {

    companion object {
        fun newInstance() = Feature1Fragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Injector.inject(this)

        val view = inflater.inflate(R.layout.feature1_fragment, container, false)

        val feature1ViewModel = ViewModelProviders.of(this, viewModelFactory).get(Feature1ViewModel::class.java)
        feature1ViewModel.onCreate()
        return view
    }
}