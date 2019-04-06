package keijumt.feature1.di

import dagger.Component
import keijumt.core.di.CoreComponent
import keijumt.core.di.ModuleScope
import keijumt.dynamicfeature.di.ViewModelModule
import keijumt.feature1.Feature1Activity

@ModuleScope
@Component(
    modules = [
        Feature1Module::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface Feature1Component {
    @Component.Builder
    interface Builder {
        fun build(): Feature1Component
        fun coreComponent(coreComponent: CoreComponent): Builder
    }

    fun inject(activity: Feature1Activity)
}