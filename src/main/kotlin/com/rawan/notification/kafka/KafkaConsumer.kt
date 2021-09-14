package com.rawan.notification.kafka

import com.rawan.notification.service.SmsNotificationService
import org.json.JSONObject
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer @Autowired constructor(private val smsNotificationService: SmsNotificationService) {

    private val logger = LoggerFactory.getLogger("KafkaConsumer")

    @KafkaListener(topics = ["NOTIFIED_USERS"], groupId = "notification_group_id")
    fun getMessage(jsonString: String) {

        val jsonNode = JSONObject(jsonString)
        val payload = JSONObject(jsonNode.getString("payload"))

        smsNotificationService.sendSms(payload)
    }
}