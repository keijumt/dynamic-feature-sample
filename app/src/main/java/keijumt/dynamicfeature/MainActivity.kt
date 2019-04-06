package keijumt.dynamicfeature

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import keijumt.dynamicfeature.di.Injector
import keijumt.dynamicfeature.di.ViewModelFactory
import keijumt.dynamicfeature.ui.MainViewModel
import kotlinx.android.synthetic.main.activity_main.btn_feature1
import kotlinx.android.synthetic.main.activity_main.btn_feature2
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inject!!
        Injector.inject(this)

        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        val splitInstallManager = SplitInstallManagerFactory.create(this)

        btn_feature1.setOnClickListener {
            if (splitInstallManager.installedModules.contains("feature1")) {
                val intent = Intent(Intent.ACTION_VIEW).setClassName(
                    "keijumt.dynamicfeature",
                    "keijumt.feature1.Feature1Activity"
                )
                startActivity(intent)
                return@setOnClickListener
            }

            val request = SplitInstallRequest
                .newBuilder()
                .addModule("feature1")
                .build()
            splitInstallManager.startInstall(request)
        }

        btn_feature2.setOnClickListener {
            if (splitInstallManager.installedModules.contains("feature2")) {
                val intent = Intent(Intent.ACTION_VIEW).setClassName(
                    "keijumt.dynamicfeature",
                    "keijumt.feature2.Feature2Activity"
                )
                startActivity(intent)
                return@setOnClickListener
            }

            val request = SplitInstallRequest
                .newBuilder()
                .addModule("feature2")
                .build()
            splitInstallManager.startInstall(request)
        }

        val listener = SplitInstallStateUpdatedListener { state ->
            when (state.status()) {
                SplitInstallSessionStatus.DOWNLOADING -> {
                    println("Downloading!!")
                }
                SplitInstallSessionStatus.INSTALLING -> {
                    println("installing!!")
                }
                SplitInstallSessionStatus.INSTALLED -> {
                    println("installed!!")
                    SplitCompat.install(this)
                }
                SplitInstallSessionStatus.FAILED -> {
                    println("failed")
                }
            }
        }
        splitInstallManager.registerListener(listener)

        mainViewModel.onCreate()
    }
}
