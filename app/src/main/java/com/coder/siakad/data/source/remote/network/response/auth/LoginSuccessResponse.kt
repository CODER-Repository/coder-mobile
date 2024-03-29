package com.coder.siakad.data.source.remote.network.response.auth

import com.google.gson.annotations.SerializedName

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
