package com.condominio.manager.entity

import javax.persistence.*


@Entity
data class Apartamento(
        @Id
        @SequenceGenerator(name="apartamento-sequence" , sequenceName="apartamento-sequence", initialValue=1)
        @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "apartamento-sequence")
        val id : Long?,

        @Column(name = "bloco")
        var bloco : String,

        @Column(name = "numero")
        var numero : Int
) {
        constructor(bloco: String, numero: Int) : this(id = null, bloco = bloco, numero = numero)
}