package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import android.util.Log
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioViewModel() : ViewModel() {

    fun cria(usuario: Usuario){
        Log.i("Login", "logando usuario")
    }

    fun loga(usuario: Usuario){
        Log.i("Login", "criando usuario")
    }
}