package com.pauversildo.briefly.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.pauversildo.briefly.data.BriefDataSource
import com.pauversildo.briefly.model.Brief

class BriefViewModel : ViewModel() {

    private var briefList = mutableStateListOf<Brief>()

    init {
        briefList.addAll(BriefDataSource().loadBriefs())
    }

    fun addBrief(brief: Brief) {
        briefList.add(brief)
    }

    fun removeBrief(brief: Brief) {
        briefList.remove(brief)
    }

    fun getAllBriefs(): List<Brief> {
        return briefList
    }


}