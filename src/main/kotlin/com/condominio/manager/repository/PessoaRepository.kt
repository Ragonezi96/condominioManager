package com.condominio.manager.repository

import com.condominio.manager.entity.Pessoa
import org.springframework.data.repository.PagingAndSortingRepository

interface PessoaRepository : PagingAndSortingRepository<Pessoa, Long>