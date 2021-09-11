package com.rawan.notification.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank

data class SmsRequest(
    @NotBlank @param:JsonProperty("phoneNumber") val phoneNumber: String,
    @NotBlank @param:JsonProperty("message") val message: String
)
