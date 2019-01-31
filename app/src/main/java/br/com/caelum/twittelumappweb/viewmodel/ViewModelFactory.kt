package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caelum.twittelumappweb.adapter.UsuarioRepository
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.webservice.InicializadorDoRetrofit
import br.com.caelum.twittelumappweb.webservice.UsuarioWebClient

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private val tweetRepository = TweetRepository()
    private val usuarioRepository = UsuarioRepository(UsuarioWebClient(InicializadorDoRetrofit.retrofit))

    private fun repository() = TweetRepository()

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.name == TweetViewModel::class.java.name) {

            TweetViewModel(tweetRepository) as T
        } else {
            UsuarioViewModel(usuarioRepository) as T
        }


    }
}