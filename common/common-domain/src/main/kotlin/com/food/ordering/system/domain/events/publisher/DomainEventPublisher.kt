package com.food.ordering.system.domain.events.publisher

import com.food.ordering.system.domain.events.DomainEvent

interface DomainEventPublisher<T : DomainEvent<*>> {
    fun publish(domainEvent: T)
}