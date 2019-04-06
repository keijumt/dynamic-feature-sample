package keijumt.dynamicfeature

import android.app.Application
import keijumt.core.di.CoreModule
import keijumt.core.di.DaggerCoreComponent

class App : Application() {

    val coreComponent by lazy {
        DaggerCoreComponent
            .builder()
            .coreModule(CoreModule(this))
            .build()
    }
}