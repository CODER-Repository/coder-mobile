package com.coder.siakad.data.network.response

import com.google.gson.annotations.SerializedName

data class InvalidResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("error")
	val error: String? = null,

	@field:SerializedName("errors")
	val errors: List<ErrorsItem>? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class ErrorsItem(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("path")
	val path: String? = null
)
