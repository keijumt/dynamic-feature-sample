package keijumt.feature1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import keijumt.dynamicfeature.di.ViewModelFactory
import keijumt.feature1.di.Injector
import keijumt.feature1.ui.Feature1ViewModel
import javax.inject.Inject

class Feature1Activity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Injector.inject(this)

        setContentView(R.layout.activity_feature1)

        val feature1ViewModel = ViewModelProviders.of(this, viewModelFactory).get(Feature1ViewModel::class.java)
    }
}
