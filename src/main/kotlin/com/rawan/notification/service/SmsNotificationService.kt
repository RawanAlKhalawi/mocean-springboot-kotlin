package com.rawan.notification.service

import com.fasterxml.jackson.databind.JsonNode

interface SmsNotificationService {

    fun sendSms(jsonNode: JsonNode): String?

}