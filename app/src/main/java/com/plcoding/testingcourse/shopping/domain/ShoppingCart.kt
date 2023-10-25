package com.plcoding.testingcourse.shopping.domain

import org.jetbrains.annotations.TestOnly


class ShoppingCart {

    private val validProductIds = listOf(1, 2, 3, 4, 5)
    private val items = mutableListOf<Product>()

    fun addProduct(product: Product, quantity: Int) {
        if(quantity < 0) {
            throw IllegalArgumentException("Quantity can't be negative")
        }
        if(isValidProduct(product)) {
            repeat(quantity) {
                items.add(product)
            }
        }
    }

    // Not recommended to do it this way instead let it be private function
    // call the private function at the public fn call site and test it internally
    @TestOnly
    fun isValidProduct(product: Product): Boolean {
        return product.price >= 0.0 && product.id in validProductIds
    }

    fun getTotalCost(): Double {
        return items.sumOf { it.price }
    }
}