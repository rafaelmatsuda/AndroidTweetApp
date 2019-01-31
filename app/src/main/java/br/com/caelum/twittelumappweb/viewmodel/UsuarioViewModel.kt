package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import br.com.caelum.twittelumappweb.adapter.UsuarioRepository
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioViewModel(private val repository: UsuarioRepository) : ViewModel() {

    val temUsuario: MutableLiveData<Boolean> = repository.estaLogado

    val usuarioLogado: Usuario = repository.usuarioLogado()

    fun desloga() = repository.desloga()

    fun cria(usuario: Usuario) = repository.cria(usuario)

    fun loga(usuario: Usuario) = repository.loga(usuario)
}