package com.condominio.manager.entity

import javax.persistence.*

@Entity
@SequenceGenerator(name = "sequenceperson", sequenceName = "sequence_person", initialValue = 1 , allocationSize = 1)
data class Pessoa(
        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequenceperson")
        val id : Long?,

        @Column(name = "nome")
        var nome : String?,

        @Column(name = "email")
        var email : String?,

        @ManyToOne
        var apartamento : Apartamento?
) {
        constructor(nome: String) : this(nome = nome, email = null, apartamento = null, id = null)
        constructor(nome: String, email: String) : this(nome = nome, email = email, apartamento = null, id = null)
        constructor() : this(nome = null, email = null, apartamento =  null, id = null)
}