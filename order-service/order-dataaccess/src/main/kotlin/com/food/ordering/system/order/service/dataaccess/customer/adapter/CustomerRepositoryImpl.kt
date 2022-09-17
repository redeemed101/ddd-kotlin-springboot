package com.food.ordering.system.order.service.dataaccess.customer.adapter

import com.food.ordering.system.order.service.dataaccess.customer.entity.CustomerEntity
import com.food.ordering.system.order.service.dataaccess.customer.mapper.CustomerDataAccessMapper
import com.food.ordering.system.order.service.dataaccess.customer.repository.CustomerJpaRepository
import com.food.ordering.system.order.service.domain.entity.Customer
import com.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository
import org.springframework.stereotype.Component
import java.util.*


@Component
class CustomerRepositoryImpl(
    private val customerJpaRepository: CustomerJpaRepository,
    private val customerDataAccessMapper: CustomerDataAccessMapper
) : CustomerRepository {
    override fun findCustomer(customerId: UUID): Customer? {
        return customerJpaRepository.findById(customerId).map { customerEntity: CustomerEntity? ->
            customerDataAccessMapper.customerEntityToCustomer(
                customerEntity!!
            )
        }.orElse(null)
    }
}