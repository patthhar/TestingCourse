package com.plcoding.testingcourse.shopping.data

import com.plcoding.testingcourse.core.domain.Product
import com.plcoding.testingcourse.core.domain.ShoppingCartCache

class ShoppingCartCacheFake : ShoppingCartCache {
    private var products: List<Product> = emptyList()

    override fun saveCart(items: List<Product>) {
        products = items
    }

    override fun loadCart(): List<Product> = products

    override fun clearCart() {
        products = emptyList()
    }

}