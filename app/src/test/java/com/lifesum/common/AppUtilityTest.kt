package com.lifesum.common

import com.google.common.collect.Range
import com.google.common.truth.Truth
import org.junit.Test

class AppUtilityTest {

    @Test
    fun `Check random number, in range`() {
        val result = AppUtility.getRandomNumber()
        Truth.assertThat(result).isIn(Range.closed(0, 200))
    }

    @Test
    fun `Check double is valid single decimal, success`() {
        val result = AppUtility.getDoubleToSingleDecimalString(100.01)
        Truth.assertThat(result).isEqualTo("100.1")
    }

    @Test
    fun `Check double is valid single decimal, failure`() {
        val result = AppUtility.getDoubleToSingleDecimalString(100.01)
        Truth.assertThat(result).isNotEqualTo("100")
    }

    @Test
    fun `Check double is valid single decimal, zero success`() {
        val result = AppUtility.getDoubleToSingleDecimalString(0.0)
        Truth.assertThat(result).isEqualTo("0")
    }

    @Test
    fun `Check double is valid single decimal, null success`() {
        val result = AppUtility.getDoubleToSingleDecimalString(null)
        Truth.assertThat(result).isEqualTo("0")
    }

}