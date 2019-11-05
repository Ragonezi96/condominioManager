package com.condominio.manager.entity

import javax.persistence.*

@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["bloco", "numero"])])
@Entity
@SequenceGenerator(name = "sequenceapartment", sequenceName = "sequence_apartment", initialValue = 1 , allocationSize = 1)
data class Apartamento(
        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequenceapartment")
        val id: Long? = null,

        @Column(name = "bloco")
        var bloco: String? = null,

        @Column(name = "numero")
        var numero: Int? = null,

        @Column(name = "metragem")
        var metragem : Long? = null,

        @ManyToOne
        var owner: Pessoa? = null
)