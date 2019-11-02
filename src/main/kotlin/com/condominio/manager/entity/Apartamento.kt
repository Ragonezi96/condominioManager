package com.condominio.manager.entity

import javax.persistence.*


@Entity
data class Apartamento(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id : Long?,

        @Column(name = "bloco")
        var bloco : String,

        @Column(name = "numero")
        var numero : Int
) {
        constructor(bloco: String, numero: Int) : this(id = null, bloco = bloco, numero = numero)
}