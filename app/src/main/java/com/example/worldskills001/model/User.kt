package com.example.worldskills001.model

import java.time.LocalDate

data class UserMode(
    var nickname: String = "",
    var exprience: String = "",
    var personCount: Int = 1,
    var perfertype: String = "",
    var checkinDate: LocalDate = LocalDate.now(),
    var activity: String = "",
)