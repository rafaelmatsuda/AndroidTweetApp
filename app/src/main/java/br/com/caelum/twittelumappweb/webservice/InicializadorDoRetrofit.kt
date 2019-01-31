package br.com.caelum.twittelumappweb.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InicializadorDoRetrofit {

    val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://077e9df5.ngrok.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}