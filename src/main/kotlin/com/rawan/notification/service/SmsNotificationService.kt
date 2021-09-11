package com.rawan.notification.service

import com.rawan.notification.dto.SmsRequest

interface SmsNotificationService {

    fun sendSms(smsRequest: SmsRequest): String?
}