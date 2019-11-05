package com.condominio.manager.utils.converter

import org.javamoney.moneta.FastMoney
import org.javamoney.moneta.Money
import java.math.BigDecimal
import java.util.*
import javax.money.CurrencyUnit
import javax.money.Monetary
import javax.money.MonetaryAmount
import javax.money.MonetaryQuery
import javax.persistence.AttributeConverter

class MonetaryAmountConverter() : AttributeConverter<MonetaryAmount, BigDecimal> {

    override fun convertToDatabaseColumn(attribute : MonetaryAmount?): BigDecimal {
        return Optional.ofNullable(attribute).orElse(FastMoney
                .zero(CURRENCY))
                .query(EXTRACT_BIG_DECIMAL);
    }

    override fun convertToEntityAttribute(dbData : BigDecimal?): MonetaryAmount? {
        return Money.of(dbData, CURRENCY);
    }

    companion object {
        val CURRENCY: CurrencyUnit = Monetary.getCurrency("BRL")
        val EXTRACT_BIG_DECIMAL = MonetaryQuery { m -> m.number.numberValue(BigDecimal::class.java) }
    }
}