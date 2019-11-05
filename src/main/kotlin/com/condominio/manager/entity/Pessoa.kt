package com.condominio.manager.entity

import javax.persistence.*

@Entity
@SequenceGenerator(name = "sequenceperson", sequenceName = "sequence_person", initialValue = 1 , allocationSize = 1)
data class Pessoa(
        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequenceperson")
        val id : Long? = null ,

        @Column(name = "nome")
        var nome : String? = null,

        @Column(name = "email")
        var email : String? = null,

        @ManyToOne
        var apartamento : Apartamento? = null
)