package com.pauversildo.briefly.model

import java.time.LocalDateTime
import java.util.UUID

data class Brief(
    val id: UUID = UUID.randomUUID(),
    val title:  String,
    val description: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
