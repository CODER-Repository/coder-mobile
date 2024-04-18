package com.coder.siakad.data.source.remote.network.request.auth

import android.os.Parcelable
import com.coder.siakad.domain.model.UserModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class LoginRequest(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)

fun LoginRequest.toUserModel2() = UserModel(
	email = username ?: "",
	password = password ?: ""
)