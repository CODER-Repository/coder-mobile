package com.coder.siakad.data.source.remote.network

import com.coder.siakad.domain.model.UserModel

object FakeDataUser {
    val dataUser = listOf(
        UserModel(
            email = "rafikawardah12@gmail.com",
            name = "Rafika Wardah",
            token = "37239kdszkl",
            password = "123456"
        ),
        UserModel(
            email = "rafika12@gmail.com",
            name = "Rafika Wardah Kamilah",
            token = "jbzskdzfl",
            password = "1234567"
        )
    )
}