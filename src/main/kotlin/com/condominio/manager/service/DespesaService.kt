package com.condominio.manager.service

import com.condominio.manager.entity.Despesa
import com.condominio.manager.repository.DespesaRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import javax.money.MonetaryAmount

@Service
class DespesaService (val despesaRepository: DespesaRepository) {

    fun create(despesa : Despesa): Despesa {
        return despesaRepository.save(despesa)
    }

    fun sumAllDespesasByAnoAndMes(mes : Int, ano : Long) : MonetaryAmount {
        return despesaRepository.getSumOfMesAno(ano, mes)
    }

    fun createDespesaDeReserva(mes : Int, ano : Long) : Despesa {
        val despesasDoMesCorrente = sumAllDespesasByAnoAndMes(mes = mes, ano = ano)
        val despesaReservaDeEmergencia = Despesa(mes = mes, ano = ano, valor = despesasDoMesCorrente.multiply(.1), descricao = "Reserva de Emergência")
        return despesaRepository.save(despesaReservaDeEmergencia)
    }

}