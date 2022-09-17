package com.food.ordering.system.order.service.domain.entity

import com.food.ordering.system.domain.entity.BaseEntity
import com.food.ordering.system.domain.valueObject.Money
import com.food.ordering.system.domain.valueObject.ProductId

data class Product(
    val productId: ProductId,
    var name : String,
    var price : Money
    ) : BaseEntity<ProductId>(){


    init {
        super.id = productId
    }


    fun updateWithConfirmedNameAndPrice(nameP: String, priceP: Money) {
         this.name = nameP
         this.price = priceP
    }
}
