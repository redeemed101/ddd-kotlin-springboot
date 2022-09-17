package com.food.ordering.system.order.service.domain.entity

import com.food.ordering.system.domain.entity.BaseEntity
import com.food.ordering.system.domain.valueObject.Money
import com.food.ordering.system.domain.valueObject.ProductId

data class Product(val productId: ProductId,
                   ) : BaseEntity<ProductId>(){


    init {
        super.id = productId
    }
    var name: String
        get() = name
        set(value) {
            name = value
        }
    var price: Money
        get() = price
        set(value) {
            price = value
        }

    fun updateWithConfirmedNameAndPrice(nameP: String, priceP: Money) {
         this.name = nameP
         this.price = priceP
    }
}
