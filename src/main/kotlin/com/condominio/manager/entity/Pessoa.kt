package com.condominio.manager.entity

import javax.persistence.*


@Entity
data class Pessoa(
        @Id
        @SequenceGenerator(name="pessoa-sequence" , sequenceName="pessoa-sequence", initialValue=1)
        @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "pessoa-sequence")
        val id : Long?,

        @Column(name = "nome")
        var nome : String,

        @ManyToOne
        var apartamento : Apartamento?
) {
        constructor(nome: String) : this(nome = nome, apartamento = null, id = null)
}