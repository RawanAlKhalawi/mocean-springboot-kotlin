package com.rawan.notification.service.imp

import com.fasterxml.jackson.databind.JsonNode
import com.mocean.system.Mocean
import com.mocean.system.auth.Basic
import com.rawan.notification.config.MoceanConfiguration
import com.rawan.notification.service.SmsNotificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SmsNotificationServiceImp @Autowired constructor(private val moceanConfiguration: MoceanConfiguration) :
    SmsNotificationService {

    override fun sendSms(jsonNode: JsonNode): String? {

    val credential = Basic(moceanConfiguration.apiKey, moceanConfiguration.apiSecret)
    val mocean = Mocean(credential)
    val firstName = jsonNode.findValue("first_name").textValue()
    val landNumber = jsonNode.findValue("land_number").textValue()
    val blockNumber = jsonNode.findValue("block_number").textValue()
    val instrumentNumber = jsonNode.findValue("instrument_number").textValue()
        return try {
            val res = mocean.sms()
                .setFrom(moceanConfiguration.from)
                .setTo(jsonNode.findValue("mobile").toString())
                .setText("عزيزي $firstName\n" +
                        "لقد تم اصدار فاتورة عدم تسوير للقطعة ($landNumber) في المخطط ($blockNumber) بصك ($instrumentNumber).")
                .send()
            res.status.toString()
        } catch (e: Exception) {
            e.message
        }
    }
}