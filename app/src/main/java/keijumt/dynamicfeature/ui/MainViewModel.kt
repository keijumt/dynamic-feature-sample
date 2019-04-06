package keijumt.dynamicfeature.ui

import androidx.lifecycle.ViewModel
import keijumt.dynamicfeature.data.MainRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    fun onCreate() {
        println(mainRepository.getHoge())
    }
}