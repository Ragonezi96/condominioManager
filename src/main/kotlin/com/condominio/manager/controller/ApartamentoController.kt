package com.condominio.manager.controller

import com.condominio.manager.controller.dto.ApartamentoDTO
import com.condominio.manager.controller.dto.PessoaDTO
import com.condominio.manager.entity.Apartamento
import com.condominio.manager.entity.Pessoa
import com.condominio.manager.service.ApartamentoService
import com.condominio.manager.service.PessoaService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/apartamento"])
class ApartamentoController(val apartamentoService: ApartamentoService) {

    @PostMapping
    fun create(@RequestBody apartamento: ApartamentoDTO): Apartamento {
        return apartamentoService.create(apartamento.toEntity())
    }
}