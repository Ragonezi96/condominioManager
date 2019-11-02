package com.condominio.manager.controller.dto

import com.condominio.manager.entity.Pessoa

class PessoaDTO(var nome : String) {
    fun toEntity(): Pessoa {
        return Pessoa(nome = nome)
    }
}