package keijumt.feature2.di

import dagger.Component
import keijumt.core.di.CoreComponent
import keijumt.core.di.ModuleScope
import keijumt.dynamicfeature.di.ViewModelModule
import keijumt.feature2.Feature2Activity

@ModuleScope
@Component(
    modules = [
        Feature2Module::class,
        ViewModelModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface Feature2Component {
    @Component.Builder
    interface Builder {
        fun build(): Feature2Component
        fun coreComponent(coreComponent: CoreComponent): Builder
    }

    fun inject(activity: Feature2Activity)
}