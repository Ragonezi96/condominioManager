package com.condominio.manager.entity

import com.condominio.manager.utils.converter.MonetaryAmountConverter
import javax.money.MonetaryAmount
import javax.persistence.*

@Entity
@SequenceGenerator(name = "sequencecondominiomensal", sequenceName = "sequence_condominio_mensal", initialValue = 1 , allocationSize = 1)
data class CondominioMensal(
        @Id
        @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "sequencecondominiomensal")
        val id: Long? = null,

        @Column(name = "valor")
        @Convert(converter = MonetaryAmountConverter::class)
        var valor: MonetaryAmount? = null,

        @Column(name = "mes")
        var mes: Int? = null,

        @Column(name = "ano")
        var ano: Long? = null,

        @Column(name = "pago")
        var pago : Boolean? = false,

        @ManyToOne
        var apartamento: Apartamento? = null


) {
}