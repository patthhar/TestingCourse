package com.plcoding.testingcourse.shopping.domain

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import com.plcoding.testingcourse.core.domain.Product
import com.plcoding.testingcourse.core.domain.ShoppingCart
import com.plcoding.testingcourse.core.domain.ShoppingCartCache
import com.plcoding.testingcourse.shopping.data.ShoppingCartCacheFake
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class ShoppingCartTest {

    private lateinit var cart: ShoppingCart
    private lateinit var cache: ShoppingCartCache

    @BeforeEach
    fun setUp() {
        cache = ShoppingCartCacheFake()
        cart = ShoppingCart(cache)
    }

    @ParameterizedTest
    @CsvSource(
        "3,15.0",
        "0,0.0",
        "6,30.0",
        "20,100.0",
    )
    fun `Add multiple products, total price sum is correct`(
        quantity: Int,
        expectedPriceSum: Double
    ) {
        // GIVEN
        val product = Product(
            id = 0,
            name = "Ice cream",
            price = 5.0
        )
        cart.addProduct(product, quantity)

        // ACTION
        val priceSum = cart.getTotalCost()

        // ASSERTION
        assertThat(priceSum).isEqualTo(quantity * 5.0)
    }

    @RepeatedTest(100)
    fun `Add product with negative quantity, throws Exception`() {
        val product = Product(
            id = 0,
            name = "Ice cream",
            price = 5.0
        )

        assertFailure {
            cart.addProduct(product, -5)
        }
    }

    @Test
    fun `isValidProduct returns invalid for not existing product`() {
        val product = Product(
            id = 1345,
            name = "Ice cream",
            price = 5.0
        )
        cart.addProduct(product, 4)

        val totalPriceSum = cart.getTotalCost()

        assertThat(totalPriceSum).isEqualTo(0.0)
    }

    @Test
    fun `Test adding products and saving it to cache successfully`() {
        val product = Product(id = 1, name = "Product", price = 5.0)
        cart.addProduct(product, 4)
        val productsInCache = cache.loadCart()

        assertThat(productsInCache).hasSize(4)
        assertThat(productsInCache).contains(product)
    }
}