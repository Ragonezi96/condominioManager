package com.condominio.manager.controller.dto

import com.condominio.manager.entity.Pessoa

class PessoaDTO(var nome : String, var email : String) : BaseDTO<Pessoa>() {

    override fun toEntity(): Pessoa {
        return Pessoa(nome = nome, email = email)
    }

}