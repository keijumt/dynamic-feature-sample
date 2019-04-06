package keijumt.feature2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import keijumt.dynamicfeature.di.ViewModelFactory
import keijumt.feature2.di.Injector
import keijumt.feature2.ui.Feature2ViewModel
import javax.inject.Inject

class Feature2Activity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Injector.inject(this)

        setContentView(R.layout.activity_feature2)

        val feature2ViewModel = ViewModelProviders.of(this, viewModelFactory).get(Feature2ViewModel::class.java)
    }
}
