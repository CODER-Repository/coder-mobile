package com.coder.siakad.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel (
    val email: String,
    val name: String,
    val password: String,
    val token: String? = ""
): Parcelable
