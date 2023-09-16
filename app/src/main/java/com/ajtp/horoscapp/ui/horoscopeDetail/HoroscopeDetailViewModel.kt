package com.ajtp.horoscapp.ui.horoscopeDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajtp.horoscapp.domain.model.HoroscopeModel
import com.ajtp.horoscapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope:HoroscopeModel
    fun getHoroscope(sign: HoroscopeModel) {
        horoscope = sign
        viewModelScope.launch {
            //HILO PRINCIPAL
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO) {
                //HILO SECUNDARIO
                getPredictionUseCase(sign.name)
            }

            if (result != null) {
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
            } else {
                _state.value =
                    HoroscopeDetailState.Error("intentelo más tarde")
            }
            //HILO PRINCIPAL
        }
    }
}