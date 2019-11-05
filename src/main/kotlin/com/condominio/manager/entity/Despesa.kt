package com.condominio.manager.entity

import com.condominio.manager.utils.converter.MonetaryAmountConverter
import javax.money.MonetaryAmount
import javax.persistence.*

@Table(uniqueConstraints = [UniqueConstraint(columnNames = ["mes", "ano", "descricao"])])
@Entity
@SequenceGenerator(name = "sequencedespesa", sequenceName = "sequence_despesa", initialValue = 1 , allocationSize = 1)
data class Despesa(
        @Id
        @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "sequencedespesa")
        val id: Long? = null,

        @Column(name = "valor")
        @Convert(converter = MonetaryAmountConverter::class)
        var valor: MonetaryAmount? = null,

        @Column(name = "mes")
        var mes: Int? = null,

        @Column(name = "ano")
        var ano: Long? = null,

        @Column(name = "descricao")
        var descricao : String? = null
)

