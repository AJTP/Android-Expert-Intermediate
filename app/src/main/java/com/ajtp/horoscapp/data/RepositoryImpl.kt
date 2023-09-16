package com.ajtp.horoscapp.data

import android.util.Log
import com.ajtp.horoscapp.data.network.HoroscopeApiService
import com.ajtp.horoscapp.data.network.response.PredictionResponse
import com.ajtp.horoscapp.domain.Repository
import com.ajtp.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel?{
        runCatching {apiService.getHoroscope(sign)}
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("AJTP","Ha ocurrido un error ${it.message}") }
        return null
    }
}