package com.coder.siakad.data.source.remote.network.response.auth

import android.os.Parcelable
import com.coder.siakad.domain.model.UserModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class LoginSuccessResponse(

	@field:SerializedName("dashboardData")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class Data(

	@field:SerializedName("token")
	val token: String? = null
)

fun LoginSuccessResponse.toUserModel() = UserModel(
	token = data?.token
)