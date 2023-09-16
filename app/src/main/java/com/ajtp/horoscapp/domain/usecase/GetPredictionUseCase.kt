package com.ajtp.horoscapp.domain.usecase

import com.ajtp.horoscapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository){
    suspend operator fun invoke(sign:String) = repository.getPrediction(sign)

}