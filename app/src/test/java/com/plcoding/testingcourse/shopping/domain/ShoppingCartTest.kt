package com.plcoding.testingcourse.shopping.domain

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ShoppingCartTest {
    private lateinit var cart: ShoppingCart

    @BeforeEach
    fun setUp() {
        cart = ShoppingCart()
    }

    @Test
    fun addMultipleProductsAndCheckTotalCartCostCorrect() {
        // Given
        val iceCream = Product(
            id = 0,
            name = "Ice Cream",
            price = 5.0
        )
        cart.addProduct(product = iceCream, quantity = 2)

        // Action
        val cartTotal = cart.getTotalCost()

        // Assertion
        assertThat(cartTotal).isEqualTo(10.0)
    }

    @Test
    fun `Add product with negative quantity should throw exception`() {
        val someProduct = Product(
            id = 0,
            name = "Some Product",
            price = 10.0
        )
        assertFailure {
            cart.addProduct(someProduct, -4)
        }
    }
}