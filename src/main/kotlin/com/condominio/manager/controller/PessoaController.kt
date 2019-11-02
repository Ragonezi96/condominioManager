package com.condominio.manager.controller

import com.condominio.manager.controller.dto.PessoaDTO
import com.condominio.manager.entity.Apartamento
import com.condominio.manager.entity.Pessoa
import com.condominio.manager.service.PessoaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["/pessoa"])
class PessoaController(val pessoaService: PessoaService) {

    @PostMapping
    fun create(@RequestBody pessoa: PessoaDTO): Pessoa {
        return pessoaService.create(pessoa.toEntity())
    }

    @PutMapping(value = ["/apartamento"])
    fun addPessoaToApartamento(@RequestParam(value = "apartamento") apartamentoId : Long, @RequestParam(value = "pessoa") pessoaId : Long) {
        return pessoaService.addPessoaToApartamento(apartamentoId = apartamentoId, pessoaId = pessoaId)
    }

    @GetMapping
    fun getAllPessoas(pageable: Pageable): Page<Pessoa> {
        return pessoaService.findAll(pageable)
    }

    @GetMapping(value = ["/{id}"])
    fun findApartamentoById(@PathVariable(value = "id") pessoaId : Long): Pessoa? {
        return pessoaService.findById(pessoaId).orElse(Pessoa())
    }
}