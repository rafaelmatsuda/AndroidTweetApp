package br.com.caelum.twittelumappweb.adapter

import android.arch.lifecycle.MutableLiveData
import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.webservice.UsuarioWebClient

class UsuarioRepository(private val client: UsuarioWebClient) {

    private var usuario:Usuario? = Usuario()

    val estaLogado: MutableLiveData<Boolean> = MutableLiveData()

    fun loga(usuario: Usuario) = client.fazLogin(usuario, sucesso())

    fun cria(usuario: Usuario) = client.cria(usuario, sucesso())

    fun usuarioLogado(): Usuario = usuario!!

    fun desloga() {
        estaLogado.value = false
        this.usuario = usuario
    }
    private fun sucesso() = { usuario: Usuario ->
        estaLogado.value = true
        this.usuario = usuario
    }
}