package com.rawan.notification.kafka

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.fge.jsonschema.main.JsonSchemaFactory
import com.github.fge.jsonschema.util.JsonLoader
import org.apache.kafka.connect.json.JsonSchema
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service


@Service
class KafkaProducer @Autowired constructor(private val kafkaTemplate: KafkaTemplate<String, JsonNode>){
//    @Autowired
//    var kafkaTemplate: KafkaTemplate<String, SmsRequest>? = null
//
//    @Value("classpath:data.json")
//    lateinit var schemaFile: Resource
//
//    var mapper = ObjectMapper()

    fun sendMessage() {
        val json: JsonNode = ObjectMapper().readTree(ClassPathResource("data.json").file)
//        val factory: JsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4)
//        val jsonSchema: JsonSchema = factory.getSchema(schemaFile.getInputStream())
        kafkaTemplate.send(TOPIC, json["payload"])
    }


    companion object {
        private const val TOPIC = "NOTIFIED_USERS"
    }
}