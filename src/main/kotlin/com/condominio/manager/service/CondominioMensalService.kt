package com.condominio.manager.service

import com.condominio.manager.entity.CondominioMensal
import com.condominio.manager.repository.CondominioMensalRepository
import org.javamoney.moneta.Money
import org.springframework.context.annotation.Lazy
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CondominioMensalService (

        val condominioMensalRepository: CondominioMensalRepository,

        @Lazy
        val apartamentoService: ApartamentoService,

        @Lazy
        val despesaService: DespesaService
) {

    fun update(condominioMensal: CondominioMensal) {
        condominioMensalRepository.save(condominioMensal)
    }

    fun findAllCondominiosMensal(pageable: Pageable): Page<CondominioMensal> {
        return condominioMensalRepository.findAll(pageable)
    }

    fun receberCondominioMensal(apartamentoId : Long, mes : Int, ano : Long) {
        val apartamento = apartamentoService.findById(apartamentoId)
        if (apartamento.isPresent) {
            val condominioMensal = condominioMensalRepository.findByMesAndAnoAndApartamento(mes = mes, ano = ano, apartamento = apartamento.get())
            condominioMensal.pago = true
            update(condominioMensal)
        }
    }

    fun generateCondominiosMensais(mes : Int, ano : Long) {
        val apartamentos = apartamentoService.findAll(Pageable.unpaged())
        val despesas = despesaService.sumAllDespesasByAnoAndMes(mes, ano)
        val metragemTotalApartamentos = apartamentoService.getSumOfAllMetragens()

        val valorDasDespesasPorMetroQuadrado = despesas.divide(BigDecimal.valueOf(metragemTotalApartamentos))

        do {
            for(apartamento in apartamentos.content) {
                if(condominioMensalRepository.existsByMesAndAndAnoAndApartamento(mes, ano, apartamento)) {
                    println("Já existe um condominio mensal calculado para esse apartamento")
                } else {
                    val valorDoCondomino = valorDasDespesasPorMetroQuadrado.multiply(apartamento.metragem!!)
                    val condominioDoMes = CondominioMensal(ano = ano, mes = mes, valor = valorDoCondomino, apartamento = apartamento)
                    condominioMensalRepository.save(condominioDoMes)
                }
            }

        } while (!apartamentos.isLast)

    }

    fun recalcularCondominio(mes : Int, ano : Long) {

    }

}