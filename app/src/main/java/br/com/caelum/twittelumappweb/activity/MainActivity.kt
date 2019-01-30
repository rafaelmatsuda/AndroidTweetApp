package br.com.caelum.twittelumappweb.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.fragment.BuscadorTweetFragment
import br.com.caelum.twittelumappweb.fragment.ListaTweetsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listenerbottomNavigation()
    }

    private fun listenerbottomNavigation(){

        MainBottomNavigation.setOnNavigationItemSelectedListener {item ->

            when(item.itemId){

                R.id.menu_tweets ->{
                    exibe(ListaTweetsFragment())
                    true
                }
                R.id.menu_busca ->{
                    exibe(BuscadorTweetFragment())
                    false
                }
                R.id.menu_mapa -> {
                    exibe(Fragment())
                    false
                }
                else ->{
                    false
                }
            }

        }

        MainBottomNavigation.selectedItemId = R.id.menu_tweets
    }

    private fun exibe(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameListaTweet, fragment)
        transaction.commit()

    }
}
