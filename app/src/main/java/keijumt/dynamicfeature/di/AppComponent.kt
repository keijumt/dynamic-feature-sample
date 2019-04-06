package keijumt.dynamicfeature.di

import dagger.Component
import keijumt.core.di.CoreComponent
import keijumt.core.di.ModuleScope
import keijumt.dynamicfeature.MainActivity

@ModuleScope
@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class,
        MainModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun coreComponent(coreComponent: CoreComponent): Builder
    }

    fun inject(activity: MainActivity)
}