package com.condominio.manager.service

import com.condominio.manager.entity.Pessoa
import com.condominio.manager.repository.PessoaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class PessoaService (val pessoaRepository: PessoaRepository, val apartamentoService: ApartamentoService) {

    fun create(pessoa : Pessoa): Pessoa {
        return pessoaRepository.save(pessoa)
    }

    fun update(pessoa : Pessoa): Pessoa {
        return pessoaRepository.save(pessoa)
    }

    fun findById(pesssoaId : Long): Optional<Pessoa> {
        return pessoaRepository.findById(pesssoaId)
    }

    fun findAll(pageable: Pageable): Page<Pessoa> {
        return pessoaRepository.findAll(pageable)
    }

    fun addPessoaToApartamento(pessoaId : Long, apartamentoId : Long) {
        val pessoa = findById(pessoaId)
        val apartamento = apartamentoService.findById(apartamentoId)

        if (pessoa.isPresent && apartamento.isPresent) {
            pessoa.get().apartamento = apartamento.get()
        }

        update(pessoa.get())
    }
}