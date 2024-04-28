package com.coder.siakad.presentation.screen.login

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.coder.siakad.R
import com.coder.siakad.data.source.remote.network.request.auth.LoginRequest
import com.coder.siakad.data.util.Resource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext


@Composable
fun LoginScreen(
    navigateToDashboard: () -> Unit,
    loginViewModel: LoginViewModel = hiltViewModel(),
//    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val passwordVisible = rememberSaveable { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf<Boolean>(false) }

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
    val scrollState = rememberScrollState()

    loginViewModel.uiLoginState.collectAsStateWithLifecycle().value.let { uiState ->
        when (uiState) {
            is Resource.Loading -> {
                isLoading = true
            }

            is Resource.Success -> {
                navigateToDashboard()
                isLoading = false
            }

            is Resource.Error -> {
                Toast.makeText(context, uiState.message, Toast.LENGTH_SHORT).show()
                isLoading = false
            }
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.univ_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(221.dp, 44.dp)
                        .padding(bottom = 8.dp),
                    alignment = Alignment.Center
                )

                Image(
                    painter = painterResource(id = R.drawable.login_image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(210.dp)
                        .widthIn(max = 300.dp)
                        .heightIn(max = 240.dp)
                        .padding(bottom = 8.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Text(
                text = stringResource(id = R.string.title_login),
                modifier = Modifier
                    .widthIn(max = 240.dp)
                    .heightIn(min = 70.dp)
                    .padding(bottom = 8.dp),
                style = MaterialTheme.typography.headlineLarge,
                //color = colorResource(id = R.color.blue_text),
                textAlign = TextAlign.Start
            )

            Text(
                text = stringResource(id = R.string.login_description),
                modifier = Modifier
                    .widthIn(max = 314.dp)
                    .heightIn(min = 54.dp)
                    .padding(bottom = 24.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                ),
                //color = colorResource(id = R.color.grey_text),
                textAlign = TextAlign.Start
            )

            OutlinedTextField(
                label = { Text(text = stringResource(id = R.string.email_text)) },
                modifier = Modifier
                    .fillMaxWidth(),
                value = email,
                /*colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorResource(id = R.color.grey_text),
                    focusedLabelColor = colorResource(id = R.color.grey_text),
                ),*/
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

                onValueChange = {
                    email = it
                },
            )

            OutlinedTextField(
                label = { Text(text = stringResource(id = R.string.password_text)) },
                modifier = Modifier
                    .fillMaxWidth(),
                value = password,
                /*colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorResource(id = R.color.grey_text),
                    focusedLabelColor = colorResource(id = R.color.grey_text),
                ),*/
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = {
                    password = it
                },
                trailingIcon = {
                    val iconImage = if (passwordVisible.value) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Filled.VisibilityOff
                    }

                    val description = if (passwordVisible.value) {
                        stringResource(id = R.string.hide_password)
                    } else {
                        stringResource(id = R.string.show_password)
                    }

                    IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                        Icon(imageVector = iconImage, contentDescription = description)
                    }
                },
                visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
            ) {
                Text(
                    text = stringResource(id = R.string.forget_password),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        //color = colorResource(id = R.color.grey_text),
                        textAlign = TextAlign.End

                    ),
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(15.dp),
                )
            }

            Button(
                onClick = {
                    navigateToDashboard()
//                    if (email == "" || password == "") {
//                        scope.launch {
//                            snackbarHostState.showSnackbar(
//                                "Email or password is empty!",
//                                withDismissAction = true
//                            )
//                        }
//                    } else {
//                        val request = LoginRequest(username = email, password = password)
//                        loginViewModel.login(request)
////                        val loginRequest = UserModel(email, password)
////                        loginViewModel.login(email = loginRequest.email)
////                        Log.e("DEBUG ERROR", "$loginRequest")
//                    }
                },
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.login_name),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .widthIn(min = 335.dp)
                        .heightIn(max = 52.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(
                    modifier = Modifier
                        .width(150.dp)
                        .padding(8.dp),
                    color = Color.Gray,
                    thickness = 1.dp,
                )
                Text(text = "Or")
                Divider(
                    modifier = Modifier
                        .width(150.dp)
                        .padding(8.dp),
                    color = Color.Gray,
                    thickness = 1.dp,
                )
            }

            Button(
                onClick = {
                          navigateToDashboard()
//                    if (email == "" || password == "") {
//                        scope.launch {
//                            snackbarHostState.showSnackbar(
//                                "Email or password is empty!",
//                                withDismissAction = true
//                            )
//                        }
//                    } else {
//                        val loginRequest = LoginRequest(username = email, password = password)
//                        loginViewModel.login(loginRequest)
//                        Log.e("DEBUG ERROR", "$loginRequest")
//                    }
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
            ) {
                Row(
                    modifier = Modifier
                        .padding(3.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Login With Google",
                        modifier = Modifier
                            .size(30.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.login_google_btn),
                        style = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }

        }
    }
}

//@Preview
//@Composable
//fun DefaultPreviewOfLoginScreen() {
//    LoginScreen(navigateToDashboard = {}, snackbarHostState = null)
//}