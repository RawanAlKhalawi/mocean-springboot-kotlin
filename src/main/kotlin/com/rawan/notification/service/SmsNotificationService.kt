package com.rawan.notification.service

import org.json.JSONObject

interface SmsNotificationService {

    fun sendSms(payload: JSONObject): String?

}