package es.iessaladillo.pedrojoya.tipcalculator.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TipCalculatorTest {

    @DisplayName("Should throw IllegalArgumentException when bill is negative")
    @Test
    fun `should throw IllegalArgumentException when bill is negative`() {
        assertThrows(IllegalArgumentException::class.java) { TipCalculator(-1f, 10f, 1) }
    }

    @DisplayName("Should throw IllegalArgumentException when percentage is negative")
    @Test
    fun `should throw IllegalArgumentException when percentage is negative`() {
        assertThrows(IllegalArgumentException::class.java) { TipCalculator(100f, -1f, 1) }
    }

    @DisplayName("Should throw IllegalArgumentException when diners is not positive")
    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `should throw IllegalArgumentException when diners is not positive`(diners: Int) {
        assertThrows(java.lang.IllegalArgumentException::class.java) {
            TipCalculator(
                100f,
                10f,
                diners
            )
        }
    }

    @DisplayName("Should calculate total properly")
    @Test
    fun `should calculate total properly`() {
        val tipCalculator = TipCalculator(100f, 10f, 1)
        assertEquals(110.00f, tipCalculator.calculateTotal())
    }

    @DisplayName("Should calculate total properly with bill 0")
    @Test
    fun `should calculate total properly with bill 0`() {
        val tipCalculator = TipCalculator(0f, 10f, 1)
        assertEquals(0f, tipCalculator.calculateTotal())
    }

    @DisplayName("Should calculate total properly with percentage 0")
    @Test
    fun `should calculate total properly with percentage 0`() {
        val tipCalculator = TipCalculator(100f, 0f, 1)
        assertEquals(100f, tipCalculator.calculateTotal())
    }

    @DisplayName("Should calculate perDiner properly")
    @Test
    fun `should calculate perDiner properly`() {
        val tipCalculator = TipCalculator(100f, 10f, 2)
        assertEquals(55f, tipCalculator.calculatePerDiner())
    }

    @DisplayName("Should calculate perDinerRounded properly")
    @Test
    fun `should calculate perDinerRounded properly`() {
        val tipCalculator = TipCalculator(100f, 15f, 2)
        assertEquals(58f, tipCalculator.calculatePerDinerRounded())
    }

    @DisplayName("Should calculate perDinerRounded properly when perDinerRounded has 00 as cents")
    @Test
    fun `should calculate perDinerRounded properly when perDinerRounded has 00 as cents`() {
        val tipCalculator = TipCalculator(100f, 10f, 2)
        assertEquals(55f, tipCalculator.calculatePerDinerRounded())
    }

}