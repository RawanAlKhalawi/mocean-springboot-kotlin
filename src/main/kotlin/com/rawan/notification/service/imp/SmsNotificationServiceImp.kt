package com.rawan.notification.service.imp

import com.mocean.system.Mocean
import com.mocean.system.auth.Basic
import com.rawan.notification.config.MoceanConfiguration
import com.rawan.notification.service.SmsNotificationService
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SmsNotificationServiceImp @Autowired constructor(private val moceanConfiguration: MoceanConfiguration) :
    SmsNotificationService {


    override fun sendSms(payload: JSONObject): String? {

        val credential = Basic(moceanConfiguration.apiKey, moceanConfiguration.apiSecret)
        val mocean = Mocean(credential)
        val firstName = payload.getString("first_name")
        val landNumber = payload.getString("land_number")
        val blockNumber = payload.getString("block_number")
        val instrumentNumber = payload.getString("instrument_number")
        val totalBill = payload.getDouble("purchased_fee") * 0.02
        return try {
            val res = mocean.sms()
                    .setFrom(moceanConfiguration.from)
                    .setTo(payload.getString("mobile"))
                    .setText("عزيزي $firstName\n" +
                            "لقد تم اصدار فاتورة عدم تسوير للقطعة ($landNumber) في المخطط ($blockNumber) بصك ($instrumentNumber) بمبلغ $totalBill ريال.")
                    .send()
            res.status.toString()
        } catch (e: Exception) {
            e.message
        }
    }
}