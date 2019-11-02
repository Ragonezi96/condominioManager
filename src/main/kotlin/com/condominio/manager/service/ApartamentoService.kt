package com.condominio.manager.service

import com.condominio.manager.entity.Apartamento
import com.condominio.manager.repository.ApartamentoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ApartamentoService (val apartamentoRepository: ApartamentoRepository) {

    fun create(apartamento: Apartamento): Apartamento {
        return apartamentoRepository.save(apartamento)
    }

    fun findById(apartamentoId : Long): Optional<Apartamento> {
        return apartamentoRepository.findById(apartamentoId)
    }
}