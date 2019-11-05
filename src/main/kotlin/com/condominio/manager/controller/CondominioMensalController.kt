package com.condominio.manager.controller

import com.condominio.manager.controller.dto.PessoaDTO
import com.condominio.manager.entity.Apartamento
import com.condominio.manager.entity.CondominioMensal
import com.condominio.manager.entity.Pessoa
import com.condominio.manager.service.CondominioMensalService
import com.condominio.manager.service.PessoaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value = ["/condominioMensal"])
class CondominioMensalController(val condominioMensalService: CondominioMensalService) {


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun buscarTodosCondominiosMensal(pageable: Pageable): Page<CondominioMensal> {
        return condominioMensalService.findAllCondominiosMensal(pageable)
    }

   @PostMapping
   @ResponseStatus(HttpStatus.ACCEPTED)
   fun calcularCondominiosDoMes(@RequestParam(value = "mes") mes : Int, @RequestParam(value = "ano") ano : Long){
       return condominioMensalService.generateCondominiosMensais(mes, ano)
   }

   @PutMapping
   @ResponseStatus(HttpStatus.OK)
   fun receberCondominioDoMes(@RequestParam(value = "mes") mes : Int, @RequestParam(value = "ano") ano : Long, @RequestParam(value = "apartamento") apartamentoId : Long) {
       return condominioMensalService.receberCondominioMensal(apartamentoId, mes, ano)
   }

}