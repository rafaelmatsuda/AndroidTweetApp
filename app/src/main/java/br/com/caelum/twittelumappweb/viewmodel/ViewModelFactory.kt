package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caelum.twittelumappweb.data.TweetRepository

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private val tweetRepository = TweetRepository();

    private fun repository() = TweetRepository()

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.name == TweetViewModel::class.java.name) {
            modelClass.getConstructor(TweetRepository::class.java).newInstance(tweetRepository)
        } else {
            modelClass.getConstructor().newInstance()
        }


    }
}