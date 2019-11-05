package com.condominio.manager.controller

import com.condominio.manager.controller.dto.DespesaDTO
import com.condominio.manager.entity.Despesa
import com.condominio.manager.service.DespesaService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/despesa"])
class DespesaController(val despesaService: DespesaService) {

    @PostMapping
    fun create(@RequestBody despesaDTO: DespesaDTO): Despesa {
        return despesaService.create(despesaDTO.toEntity())
    }

    @PutMapping
    fun createReservaDeEmergencia(@RequestParam(value = "mes") mes : Int, @RequestParam(value = "ano") ano : Long): Despesa {
        return despesaService.createDespesaDeReserva(mes, ano)
    }

}