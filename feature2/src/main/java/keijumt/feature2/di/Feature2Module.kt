package keijumt.feature2.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import keijumt.dynamicfeature.di.ViewModelKey
import keijumt.feature2.ui.Feature2ViewModel

@Module
abstract class Feature2Module {

    @Binds
    @IntoMap
    @ViewModelKey(Feature2ViewModel::class)
    internal abstract fun bindFeature2ViewModel(viewModel: Feature2ViewModel): ViewModel
}