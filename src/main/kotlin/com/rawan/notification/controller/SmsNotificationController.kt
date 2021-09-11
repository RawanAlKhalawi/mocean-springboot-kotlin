package com.rawan.notification.controller

import com.rawan.notification.dto.SmsRequest
import com.rawan.notification.service.SmsNotificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/sms")
class SmsNotificationController @Autowired constructor(private val smsNotificationService: SmsNotificationService) {

    @PostMapping
    fun sendSms(@RequestBody smsRequest: @Valid SmsRequest): ResponseEntity<String> {
        val body = smsNotificationService.sendSms(smsRequest)
        return ResponseEntity.ok().body(body)
    }
}