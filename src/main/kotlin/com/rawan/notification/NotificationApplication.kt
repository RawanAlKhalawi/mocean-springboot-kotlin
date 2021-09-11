package com.rawan.notification

import com.rawan.notification.config.MoceanConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(MoceanConfiguration::class)
class NotificationApplication

fun main(args: Array<String>) {
	runApplication<NotificationApplication>(*args)
}
