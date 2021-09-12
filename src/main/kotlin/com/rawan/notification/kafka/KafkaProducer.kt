package com.rawan.notification.kafka

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer @Autowired constructor(private val kafkaTemplate: KafkaTemplate<String, JsonNode>){

    fun sendMessage() {
        val json: JsonNode = ObjectMapper().readTree(ClassPathResource("data.json").file)
        kafkaTemplate.send(TOPIC, json["payload"])
    }


    companion object {
        private const val TOPIC = "NOTIFIED_USERS"
    }
}
