package com.pauversildo.briefly.data

import com.pauversildo.briefly.model.Brief

class BriefDataSource {
    fun loadBriefs(): List<Brief> {
        return listOf(
            Brief(title = "A good day", description = "We went on a vacation by the lake"),
            Brief(
                title = "Android Compose",
                description = "Working on Android Compose course today"
            ),
            Brief(title = "Keep at it...", description = "Sometimes things just happen"),
            Brief(title = "A movie day", description = "Watching a movie with family today"),
            Brief(title = "A movie day", description = "Watching a movie with family today"),
            Brief(title = "A movie day", description = "Watching a movie with family today"),
            Brief(title = "A movie day", description = "Watching a movie with family today"),
            Brief(title = "A movie day", description = "Watching a movie with family today"),
            Brief(title = "A movie day", description = "Watching a movie with family today"),
            Brief(title = "A movie day", description = "Watching a movie with family")

        )
    }
}