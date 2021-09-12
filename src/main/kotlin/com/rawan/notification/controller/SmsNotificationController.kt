package com.rawan.notification.controller

import com.rawan.notification.kafka.KafkaProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/sms")
class SmsNotificationController @Autowired constructor(private val producer: KafkaProducer) {

    @PostMapping()
    fun sendSms() {
        producer.sendMessage()
    }
}