package com.rawan.notification.kafka

import com.fasterxml.jackson.databind.JsonNode
import com.rawan.notification.service.SmsNotificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class KafkaConsumer @Autowired constructor(private val smsNotificationService: SmsNotificationService) {

    @KafkaListener(topics = ["NOTIFIED_USERS"], groupId = "notification_group_id")
    fun getMessage(jsonNode: JsonNode) {
        smsNotificationService.sendSms(jsonNode)
    }
}