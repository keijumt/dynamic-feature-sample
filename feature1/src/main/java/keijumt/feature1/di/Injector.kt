package keijumt.feature1.di

import keijumt.dynamicfeature.App
import keijumt.feature1.Feature1Activity

internal object Injector {

    /**
     * Feature1ActivityにInject!!
     */
    fun inject(activity: Feature1Activity) {
        val coreComponent = (activity.application as App).coreComponent
        val component = DaggerFeature1Component
            .builder()
            .coreComponent(coreComponent)
            .build()
        component.inject(activity)
    }
}