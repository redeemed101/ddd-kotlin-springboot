package com.food.ordering.system.order.service.application.rest

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse
import com.food.ordering.system.order.service.domain.ports.input.service.OrderApplicationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping(value = ["/orders"], produces = ["application/vnd.api.v1+json"])
class OrderController(orderApplicationService: OrderApplicationService) {
    private val orderApplicationService: OrderApplicationService

    init {
        this.orderApplicationService = orderApplicationService
    }

    @PostMapping
    fun createOrder(@RequestBody createOrderCommand: CreateOrderCommand): ResponseEntity<CreateOrderResponse> {

        val createOrderResponse = orderApplicationService.createOrder(createOrderCommand)

        return ResponseEntity.ok(createOrderResponse)
    }

    @GetMapping("/{trackingId}")
    fun getOrderByTrackingId(@PathVariable trackingId: UUID): ResponseEntity<TrackOrderResponse> {
        val trackOrderResponse =
            orderApplicationService.trackOrder(TrackOrderQuery(trackingId))

        return ResponseEntity.ok(trackOrderResponse)
    }
}