package com.condominio.manager.entity

import javax.persistence.*


@Entity
data class Pessoa(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id : Long?,

        @Column(name = "nome")
        var nome : String,

        @ManyToOne
        var apartamento : Apartamento?
) {
        constructor(nome: String) : this(nome = nome, apartamento = null, id = null)
}