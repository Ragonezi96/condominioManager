package com.condominio.manager.repository

import com.condominio.manager.entity.Apartamento
import com.condominio.manager.entity.Pessoa
import org.springframework.data.repository.PagingAndSortingRepository

interface ApartamentoRepository : PagingAndSortingRepository<Apartamento, Long>