package keijumt.feature2.di

import keijumt.dynamicfeature.App
import keijumt.feature2.Feature2Activity

internal object Injector {

    /**
     * Feature1ActivityにInject!!
     */
    fun inject(activity: Feature2Activity) {
        val coreComponent = (activity.application as App).coreComponent
        val component = DaggerFeature2Component
            .builder()
            .coreComponent(coreComponent)
            .build()
        component.inject(activity)
    }
}