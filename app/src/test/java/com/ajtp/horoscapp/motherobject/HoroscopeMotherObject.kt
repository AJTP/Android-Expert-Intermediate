package com.ajtp.horoscapp.motherobject

import com.ajtp.horoscapp.data.network.response.PredictionResponse
import com.ajtp.horoscapp.domain.model.HoroscopeInfo.*

object HoroscopeMotherObject {
    val anyResponse = PredictionResponse("date", "prediction", "taurus")

    val horoscopeInfoList = listOf(
        Aries,
        Taurus,
        Gemini,
        Cancer,
        Leo,
        Virgo,
        Libra,
        Scorpio,
        Sagittarius,
        Capricorn,
        Aquarius,
        Pisces
    )
}