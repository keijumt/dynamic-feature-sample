package keijumt.feature1.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import keijumt.dynamicfeature.di.ViewModelKey
import keijumt.feature1.ui.Feature1ViewModel

@Module
abstract class Feature1Module {

    @Binds
    @IntoMap
    @ViewModelKey(Feature1ViewModel::class)
    internal abstract fun bindFeature1ViewModel(viewModel: Feature1ViewModel): ViewModel
}