package com.condominio.manager.controller.dto

import com.condominio.manager.entity.Apartamento
import com.condominio.manager.entity.Despesa
import org.javamoney.moneta.Money
import java.math.BigDecimal
import javax.money.MonetaryAmount

class DespesaDTO(var descricao : String, var valor : BigDecimal, var mes : Int, var ano : Long) : BaseDTO<Despesa>() {

    override fun toEntity(): Despesa {
        return Despesa(descricao = descricao, valor = Money.of(valor, "BRL"), mes = mes, ano = ano)
    }

}