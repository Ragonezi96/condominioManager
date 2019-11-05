package com.condominio.manager.repository

import com.condominio.manager.entity.Apartamento
import com.condominio.manager.entity.CondominioMensal
import com.condominio.manager.entity.Pessoa
import org.springframework.data.repository.PagingAndSortingRepository

interface CondominioMensalRepository : PagingAndSortingRepository<CondominioMensal, Long> {
    fun existsByMesAndAndAnoAndApartamento(mes : Int, ano : Long, apartamento: Apartamento) : Boolean

    fun findByMesAndAnoAndApartamento(mes : Int, ano : Long, apartamento: Apartamento) : CondominioMensal

    fun findByMesAndAno(mes: Int, ano : Long)
}