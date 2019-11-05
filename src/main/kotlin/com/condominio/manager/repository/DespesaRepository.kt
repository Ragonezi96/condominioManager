package com.condominio.manager.repository

import com.condominio.manager.entity.Despesa
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import java.math.BigDecimal
import javax.money.MonetaryAmount

interface DespesaRepository : PagingAndSortingRepository<Despesa, Long> {
    @Query("SELECT SUM(d.valor) FROM Despesa d WHERE d.ano = :ano AND d.mes = :mes")
    fun getSumOfMesAno(ano : Long, mes : Int) : MonetaryAmount

}