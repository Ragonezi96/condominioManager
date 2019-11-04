package com.condominio.manager.entity

import javax.persistence.*

@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["bloco", "numero"])])
@Entity
@SequenceGenerator(name = "sequenceapartment", sequenceName = "sequence_apartment", initialValue = 1 , allocationSize = 1)
data class Apartamento(
        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequenceapartment")
        val id: Long?,

        @Column(name = "bloco")
        var bloco: String?,

        @Column(name = "numero")
        var numero: Int?,

        @ManyToOne
        var owner: Pessoa?
) {
        constructor(bloco: String, numero: Int) : this(id = null, bloco = bloco, numero = numero, owner = null)
        constructor() : this(id = null, bloco = null, numero = null, owner = null)
}