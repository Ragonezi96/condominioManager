package com.condominio.manager.service

import com.condominio.manager.entity.Apartamento
import com.condominio.manager.repository.ApartamentoRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*
import kotlin.random.Random

@ExtendWith(MockitoExtension::class)
class ApartamentoServiceTest {

    @InjectMocks
    lateinit var apartamentoService : ApartamentoService

    @Mock
    lateinit var pessoaService: PessoaService

    @Mock
    lateinit var apartamentoRepository: ApartamentoRepository

    @Test
    fun createApartmentShouldCallRepository() {
        val apartamento = Apartamento()
        apartamento.bloco = "10A"
        Mockito.`when`(apartamentoRepository.save(apartamento)).thenReturn(apartamento)
        val apartamentoSaved = apartamentoService.create(apartamento)
        Assertions.assertEquals("10A", apartamentoSaved.bloco)
    }

    @Test
    fun findAllApartmentsShouldReturnApartments() {
        val listaDeApartamentos = mutableListOf<Apartamento>()

        val randomSize = Random.nextLong(0,10)

        for (i in 1..randomSize) {
            listaDeApartamentos.add(Apartamento(numero = i.toInt(), bloco = "10L"))
        }

        var page = PageImpl(listaDeApartamentos)

        Mockito.`when`(apartamentoRepository.findAll(Pageable.unpaged())).thenReturn(page)

        val apartamentoSaved = apartamentoService.findAll(Pageable.unpaged())

        Assertions.assertEquals(1, apartamentoSaved.totalPages)
        Assertions.assertEquals(randomSize, apartamentoSaved.totalElements)
    }

    @Test
    fun findByIdShouldReturnSpecificAparment() {
        var apartamento = Apartamento()
        apartamento.bloco = "10A"

        Mockito.`when`(apartamentoRepository.findById(1L)).thenReturn(Optional.of(apartamento))

        val apartamentoSaved = apartamentoService.findById(1L)

        Assertions.assertTrue(apartamentoSaved.isPresent)
        Assertions.assertEquals("10A", apartamentoSaved.get().bloco)
    }
}