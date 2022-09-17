package com.food.ordering.system.kafka.config.data

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import javax.xml.crypto.Data



@Configuration
@ConfigurationProperties(prefix = "kafka-consumer-config")
data class KafkaConsumerConfigData(
     val keyDeserializer: String,
     val valueDeserializer: String,
     val autoOffsetReset: String,
     val specificAvroReaderKey: String,
     val specificAvroReader: String,
     val batchListener: Boolean,
     val autoStartup: Boolean,
     val concurrencyLevel: Int,
     val sessionTimeoutMs: Int,
     val heartbeatIntervalMs: Int,
     val maxPollIntervalMs: Int,
     val pollTimeoutMs: Long,
     val maxPollRecords: Int,
     val maxPartitionFetchBytesDefault: Int,
     val maxPartitionFetchBytesBoostFactor: Int,
)