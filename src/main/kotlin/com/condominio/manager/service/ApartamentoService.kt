package com.condominio.manager.service

import com.condominio.manager.entity.Apartamento
import com.condominio.manager.repository.ApartamentoRepository
import org.springframework.context.annotation.Lazy
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class ApartamentoService (val apartamentoRepository: ApartamentoRepository,
                          @Lazy val pessoaService: PessoaService) {

    fun create(apartamento: Apartamento): Apartamento {
        return apartamentoRepository.save(apartamento)
    }

    fun findAll(pageable: Pageable): Page<Apartamento> {
        return apartamentoRepository.findAll(pageable)
    }

    fun findById(apartamentoId : Long): Optional<Apartamento> {
        return apartamentoRepository.findById(apartamentoId)
    }

    fun delete(apartamentoId: Long) {
        return apartamentoRepository.deleteById(apartamentoId)
    }

    fun makePersonOwner(pessoaId : Long, apartamentoId: Long) {
        var apartamento = apartamentoRepository.findById(apartamentoId)
        val pessoa =  pessoaService.findById(pessoaId)

        if (pessoa.isPresent && apartamento.isPresent) {
            apartamento.get().owner = pessoa.get()
        }

        apartamentoRepository.save(apartamento.get())
    }
}