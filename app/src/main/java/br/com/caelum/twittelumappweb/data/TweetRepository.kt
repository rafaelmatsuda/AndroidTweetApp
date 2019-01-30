package br.com.caelum.twittelumappweb.data

import br.com.caelum.twittelumappweb.modelo.Tweet

class TweetRepository {

    fun salva(tweet: Tweet) {}

    fun lista() : List<Tweet> = listOf(Tweet("bla", null),
            Tweet("ble", null),
            Tweet("bli", null),
            Tweet("blo", null),
            Tweet("blu", null))

}