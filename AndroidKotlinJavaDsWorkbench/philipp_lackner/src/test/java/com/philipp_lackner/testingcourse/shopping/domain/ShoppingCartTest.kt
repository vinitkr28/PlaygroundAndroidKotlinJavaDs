package com.philipp_lackner.testingcourse.shopping.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.plcoding.testingcourse.shopping.domain.Product
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class ShoppingCartTest {

    private lateinit var cart: ShoppingCart

    @BeforeEach
    fun setUp() {
        cart = ShoppingCart()


    }

    @Test
    fun addMultipleProducts_totalPriceSumCorrect() {

    }

    @Test
    fun `Add multiple products, total price sum is correct`() {
        //GIVEN
        val product = Product(
            id = 0,
            name = "Ice cream",
            price = 5.0
        )

        cart.addProduct(product, 4)

        //ACTION
        val priceSum = cart.getTotalCost()

        //ASSERTION
        assertThat(priceSum).isEqualTo(20.0)
    }


    @RepeatedTest(50)
    fun `RepeatedTest - Add multiple products, total price sum is correct`() {//flicky test
        //GIVEN
        val product = Product(
            id = 0,
            name = "Ice cream",
            price = 5.0
        )

        cart.addProduct(product, 4)

        //ACTION
        val priceSum = cart.getTotalCost()

        //ASSERTION
        assertThat(priceSum).isEqualTo(20.0)
    }


    @ParameterizedTest
    @ValueSource(
        ints = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    )
    fun `ParameterizedTest with ValueSource - Add multiple products, total price sum is correct`(
        quantity: Int
    ) {
        //GIVEN
        val product = Product(
            id = 0,
            name = "Ice cream",
            price = 5.0
        )

        cart.addProduct(product, quantity)

        //ACTION
        val priceSum = cart.getTotalCost()

        //ASSERTION
        assertThat(priceSum).isEqualTo(quantity * 5.0)
    }

    @ParameterizedTest
    @CsvSource(
        "3, 15.0",
        "0, 0.0",
        "6, 30.0",
        "20, 100.0"
    )
    fun `ParameterizedTest with CsvSource - Add multiple products, total price sum is correct`(
        quantity: Int,
        expectedPriceSum: Double
    ) {
        //GIVEN
        val product = Product(
            id = 0,
            name = "Ice cream",
            price = 5.0
        )

        cart.addProduct(product, quantity)

        //ACTION
        val priceSum = cart.getTotalCost()

        //ASSERTION
        assertThat(priceSum).isEqualTo(expectedPriceSum)
    }


    @Test
    fun `isValidProduct return invalid for not existing product`() {
        val product = Product(
            id = 12345,
            name = "Ice cream",
            price = 5.0
        )

        cart.addProduct(product, 4)

        val totalPriceSum = cart.getTotalCost()

        assertThat(totalPriceSum).isEqualTo(0.0)
    }
}