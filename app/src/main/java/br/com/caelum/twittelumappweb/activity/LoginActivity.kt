package br.com.caelum.twittelumappweb.activity

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.viewmodel.UsuarioViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)


        val viewModel = ViewModelProviders.of(this, ViewModelFactory).get(UsuarioViewModel::class.java)

        //listeners nos botoes

        login_criar.setOnClickListener {viewModel.cria(usuarioDaTela())}

        login_entrar.setOnClickListener{viewModel.loga(usuarioDaTela())}
    }

    private fun usuarioDaTela() : Usuario {

        val nome = login_campoNome.text.toString()
        val senha = login_campoSenha.text.toString()
        val username = login_campoUsername.text.toString()

        return Usuario(nome, senha, username)
    }


}