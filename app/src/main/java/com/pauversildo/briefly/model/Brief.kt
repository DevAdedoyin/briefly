package com.pauversildo.briefly.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.UUID

@Entity(tableName = "brief_tbl")
data class Brief(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "brief_title")
    val title:  String,
    @ColumnInfo(name = "brief_description")
    val description: String,
    @ColumnInfo(name = "note_entry_date")
    val entryDate: LocalDateTime = LocalDateTime.now()
)
