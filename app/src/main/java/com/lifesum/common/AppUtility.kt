package com.lifesum.common

import java.math.RoundingMode
import java.text.DecimalFormat

object AppUtility {
    fun getRandomNumber() = (1..200).random()
    fun getDoubleToSingleDecimalString(value: Double?): String {
        val df = DecimalFormat("#.#")
        df.roundingMode = RoundingMode.CEILING
        return df.format(value ?: Constants.ZERO_DOUBLE)
    }
}