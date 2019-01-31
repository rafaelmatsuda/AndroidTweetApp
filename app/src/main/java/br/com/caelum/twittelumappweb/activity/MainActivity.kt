package br.com.caelum.twittelumappweb.activity

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.fragment.BuscadorTweetFragment
import br.com.caelum.twittelumappweb.fragment.ListaTweetsFragment
import br.com.caelum.twittelumappweb.modelo.Tweet
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.UsuarioViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var tweetViewModel: TweetViewModel

    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tweetViewModel = ViewModelProviders.of(this,ViewModelFactory).get(TweetViewModel::class.java)

        usuarioViewModel = ViewModelProviders.of(this, ViewModelFactory).get(UsuarioViewModel::class.java)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_bottom_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menu_sair) {
            usuarioViewModel.desloga()
            voltaProLogin()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun voltaProLogin() {
        finish()
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
