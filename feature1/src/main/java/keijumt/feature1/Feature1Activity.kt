package keijumt.feature1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import keijumt.feature1.di.Injector

class Feature1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Injector.inject(this)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, Feature1Fragment.newInstance())
                .commit()
        }

        setContentView(R.layout.activity_feature1)
    }
}
