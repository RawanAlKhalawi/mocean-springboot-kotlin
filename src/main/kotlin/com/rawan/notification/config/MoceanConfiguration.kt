package com.rawan.notification.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("mocean")
data class MoceanConfiguration(
        val apiKey: String,
        val apiSecret: String,
        val from: String
)