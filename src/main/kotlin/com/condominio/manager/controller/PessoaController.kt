package com.condominio.manager.controller

import com.condominio.manager.controller.dto.PessoaDTO
import com.condominio.manager.entity.Pessoa
import com.condominio.manager.service.PessoaService
import org.springframework.web.bind.annotation.*

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
}