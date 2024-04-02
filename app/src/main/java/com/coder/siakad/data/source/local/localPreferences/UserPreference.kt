package com.coder.siakad.data.source.local.localPreferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.coder.siakad.domain.model.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

val Context.dataUser: DataStore<Preferences> by preferencesDataStore(name = "user")

@Singleton
class UserPreference @Inject constructor(private val datauserUser: DataStore<Preferences>) {
    fun getUser(): Flow<UserModel> {
        return datauserUser.data.map {preference ->
            UserModel(
                token = preference[TOKEN_KEY] ?: "null",
                email = preference[EMAIL_KEY] ?: "",
                password = preference[PASSWORD_KEY] ?: "",
                name = preference[NAME_KEY] ?: ""
            )
        }
    }

    suspend fun saveUser(user: UserModel){
        datauserUser.edit { preference->
            preference[TOKEN_KEY] = user.token ?: "null"
            preference[EMAIL_KEY] = user.email
            preference[PASSWORD_KEY] = user.password
            preference[NAME_KEY] = user.name

        }
    }

    suspend fun logOut() {
        datauserUser.edit { preference ->
            preference.clear()
        }
    }

    companion object{
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val EMAIL_KEY = stringPreferencesKey("email")
        private val PASSWORD_KEY = stringPreferencesKey("password")
        private val NAME_KEY = stringPreferencesKey("name")
    }
}

