package com.condominio.manager.controller.dto

import com.condominio.manager.entity.Apartamento

class ApartamentoDTO(
        var bloco : String,
        var numero : Int
) {
    fun toEntity(): Apartamento {
        return Apartamento(bloco = bloco, numero = numero)
    }
}