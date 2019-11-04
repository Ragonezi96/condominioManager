package com.condominio.manager.controller

import com.condominio.manager.controller.dto.PessoaDTO
import com.condominio.manager.entity.Apartamento
import com.condominio.manager.entity.Pessoa
import com.condominio.manager.service.PessoaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["/pessoa"])
class PessoaController(val pessoaService: PessoaService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody pessoa: PessoaDTO): Pessoa {
        return pessoaService.create(pessoa.toEntity())
    }

    @GetMapping
    fun getAllPessoas(pageable: Pageable): Page<Pessoa> {
        return pessoaService.findAll(pageable)
    }

    @GetMapping(value = ["/{id}"])
    fun findApartamentoById(@PathVariable(value = "id") pessoaId : Long): Pessoa? {
        return pessoaService.findById(pessoaId).orElse(Pessoa())
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteApartmentById(@PathVariable(value = "id") pessoaId : Long) {
        return pessoaService.delete(pessoaId)
    }

    @PutMapping(value = ["/apartamento"])
    fun addPessoaToApartamento(@RequestParam(value = "apartamento") apartamentoId : Long, @RequestParam(value = "pessoa") pessoaId : Long): Pessoa {
        return pessoaService.addPessoaToApartamento(apartamentoId = apartamentoId, pessoaId = pessoaId)
    }


}