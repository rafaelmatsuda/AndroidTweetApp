package br.com.caelum.twittelumappweb.modelo

data class Usuario (var nome: String = "",
                    var username: String = "" ,
                    var senha: String = "",
                    var foto: String? = null,
                    var id: Long =0)