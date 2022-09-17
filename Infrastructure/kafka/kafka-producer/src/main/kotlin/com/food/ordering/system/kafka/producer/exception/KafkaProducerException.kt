package com.food.ordering.system.kafka.producer.exception

class KafkaProducerException : RuntimeException{
    constructor(msg: String) : super(msg)
}