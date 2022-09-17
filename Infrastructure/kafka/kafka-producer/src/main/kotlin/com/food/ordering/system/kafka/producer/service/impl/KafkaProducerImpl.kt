package com.food.ordering.system.kafka.producer.service.impl

import com.food.ordering.system.kafka.producer.exception.KafkaProducerException
import com.food.ordering.system.kafka.producer.service.KafkaProducer
import org.apache.avro.specific.SpecificRecordBase
import org.apache.kafka.common.KafkaException
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.util.concurrent.ListenableFutureCallback
import java.io.Serializable
import javax.annotation.PreDestroy

@Component
class KafkaProducerImpl<K: Serializable, V: SpecificRecordBase> constructor(
   private val kafkaTemplate : KafkaTemplate<K, V>
) : KafkaProducer<K, V> {
    override fun send(topicName: String, key: K, message: V, callback: ListenableFutureCallback<SendResult<K, V>>) {

        try {
            val kafkaResultFuture: ListenableFuture<SendResult<K, V>> = kafkaTemplate.send(topicName, key, message)
            kafkaResultFuture.addCallback(callback)
        } catch (e: KafkaException) {

            throw KafkaProducerException("Error on kafka producer with key: $key and message: $message")
        }
    }

    @PreDestroy
    fun close() {
        if (kafkaTemplate != null) {

            kafkaTemplate.destroy()
        }
    }
}