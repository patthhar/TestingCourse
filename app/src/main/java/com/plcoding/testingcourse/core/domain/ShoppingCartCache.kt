package com.plcoding.testingcourse.core.domain

import com.plcoding.testingcourse.core.domain.Product

interface ShoppingCartCache {
    fun saveCart(items: List<Product>)
    fun loadCart(): List<Product>
    fun clearCart()
}