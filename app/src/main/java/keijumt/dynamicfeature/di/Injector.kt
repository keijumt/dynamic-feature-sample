package keijumt.dynamicfeature.di

import keijumt.dynamicfeature.App
import keijumt.dynamicfeature.MainActivity

object Injector {

    /**
     * MainActivityにInject!!
     */
    fun inject(activity: MainActivity) {
        val coreComponent = (activity.application as App).coreComponent
        val component = DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
        component.inject(activity)
    }
}