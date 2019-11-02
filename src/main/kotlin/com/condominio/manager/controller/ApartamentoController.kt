package com.condominio.manager.controller

import com.condominio.manager.controller.dto.ApartamentoDTO
import com.condominio.manager.controller.dto.PessoaDTO
import com.condominio.manager.entity.Apartamento
import com.condominio.manager.entity.Pessoa
import com.condominio.manager.service.ApartamentoService
import com.condominio.manager.service.PessoaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["/apartamento"])
class ApartamentoController(val apartamentoService: ApartamentoService) {

    @PostMapping
    fun create(@RequestBody apartamento: ApartamentoDTO): Apartamento {
        return apartamentoService.create(apartamento.toEntity())
    }

    @GetMapping
    fun getAllApartamentos(pageable: Pageable): Page<Apartamento> {
        return apartamentoService.findAll(pageable)
    }

    @GetMapping(value = ["/{id}"])
    fun findApartamentoById(@PathVariable(value = "id") apartamentoId : Long): Apartamento? {
        return apartamentoService.findById(apartamentoId).orElse(Apartamento())
    }
}