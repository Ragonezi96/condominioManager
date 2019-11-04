package com.condominio.manager.service

import com.condominio.manager.entity.Apartamento
import com.condominio.manager.entity.Pessoa
import com.condominio.manager.repository.ApartamentoRepository
import com.condominio.manager.repository.PessoaRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*
import kotlin.random.Random

@ExtendWith(MockitoExtension::class)
class PessoaServiceTest {

    @InjectMocks
    lateinit var pessoaService: PessoaService

    @Mock
    lateinit var apartamentoService: ApartamentoService

    @Mock
    var pessoaRepository: PessoaRepository = Mockito.mock(PessoaRepository::class.java)

    @Test
    fun createPessoaShouldCreate() {
        var pessoa = Pessoa()
        pessoa.nome = "Pessoa Teste"
        Mockito.`when`(pessoaRepository.save(Mockito.any(Pessoa::class.java))).thenReturn(pessoa)

        val pessoaSaved = pessoaService.create(pessoa)
        Assertions.assertEquals("Pessoa Teste", pessoaSaved.nome)

    }

    @Test
    fun updatePessoaShouldUpdate() {
        var pessoa = Pessoa()
        pessoa.nome = "Pessoa Teste"
        Mockito.`when`(pessoaRepository.save(Mockito.any(Pessoa::class.java))).thenReturn(pessoa)

        val pessoaSaved = pessoaService.update(pessoa)
        Assertions.assertEquals("Pessoa Teste", pessoaSaved.nome)

    }

    @Test
    fun findPessoaByIdShouldReturnPessoa() {
        var pessoa = Pessoa()
        pessoa.nome = "Pessoa Teste"
        Mockito.`when`(pessoaRepository.findById(Mockito.any(Long::class.java))).thenReturn(Optional.of(pessoa))

        val pessoaSaved = pessoaService.findById(1L)
        Assertions.assertEquals("Pessoa Teste", pessoaSaved.get().nome)
        Assertions.assertTrue(pessoaSaved.isPresent)
    }

    @Test
    fun findAllPessoasShouldReturnPessoas() {
        val listaDePessoas = mutableListOf<Pessoa>()

        val randomSize = Random.nextLong(0,10)

        for (i in 1..randomSize) {
            listaDePessoas.add(Pessoa(nome = "Pessoa %i"))
        }

        var page = PageImpl(listaDePessoas)

        Mockito.`when`(pessoaRepository.findAll(Pageable.unpaged())).thenReturn(page)

        val pessoaSaved = pessoaService.findAll(Pageable.unpaged())

        Assertions.assertEquals(1, pessoaSaved.totalPages)
        Assertions.assertEquals(randomSize, pessoaSaved.totalElements)
    }

    @Test
    fun addPessoaToApartamentoShouldReturnCorrectPessoa() {
        val apartamento = Apartamento(numero = 1, bloco = "1")
        val pessoa = Pessoa(nome = "Pessoa Teste")
        val pessoaWithApartamento = pessoa.copy(apartamento = apartamento)

        Mockito.`when`(pessoaRepository.findById(Mockito.any(Long::class.java))).thenReturn(Optional.of(pessoa))
        Mockito.`when`(apartamentoService.findById(Mockito.any(Long::class.java))).thenReturn(Optional.of(apartamento))
        Mockito.`when`(pessoaRepository.save(Mockito.any(Pessoa::class.java))).thenReturn(pessoaWithApartamento)

        val pessoaResult = pessoaService.addPessoaToApartamento(1L, 1L)
        Assertions.assertEquals(apartamento, pessoaResult.apartamento)
    }
}