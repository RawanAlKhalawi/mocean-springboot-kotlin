package com.rawan.notification.service.imp

import com.mocean.system.Mocean
import com.mocean.system.auth.Basic
import com.rawan.notification.config.MoceanConfiguration
import com.rawan.notification.dto.SmsRequest
import com.rawan.notification.service.SmsNotificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SmsNotificationServiceImp @Autowired constructor(private val moceanConfiguration: MoceanConfiguration) :
    SmsNotificationService {

    override fun sendSms(smsRequest: SmsRequest): String? {
        val credential = Basic(moceanConfiguration.apiKey, moceanConfiguration.apiSecret)
        val mocean = Mocean(credential)
        return try {
            val res = mocean.sms()
                .setFrom(moceanConfiguration.from)
                .setTo(smsRequest.phoneNumber)
                .setText(smsRequest.message)
                .send()
            res.status.toString()
        } catch (e: Exception) {
            e.message
        }
    }
}