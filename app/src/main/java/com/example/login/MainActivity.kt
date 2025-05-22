package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.login.ui.theme.AzulGriseaseo
import com.example.login.ui.theme.AzulTonoAlto
import com.example.login.ui.theme.GrisTonoAlto
import com.example.login.ui.theme.NegroTonoBajo


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.navigationBarColor = android.graphics.Color.TRANSPARENT
        setContent {
            MainScreen()
        }
    }
}
@Composable
fun MainScreen() {
    // Estado para los campos
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        val (title, emailField, passwordField, loginBtn, createAccountBtn, googleBtn, forgotText, forgotIcon) = createRefs()

        Title(
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                verticalBias = 0.01f
                horizontalBias = 0.01f
            }
        )

        EmailField(
            email = emailState.value,
            onEmailChange = { emailState.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(emailField) {
                    top.linkTo(title.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        PasswordField(
            password = passwordState.value,
            onPasswordChange = { passwordState.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(passwordField) {
                    top.linkTo(emailField.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        LoginButton(
            modifier = Modifier
                .width(380.dp)
                .height(50.dp)
                .constrainAs(loginBtn) {
                    top.linkTo(passwordField.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            onClick = { /* TODO: Login logic */ }
        )

        CreateAccountButton(
            modifier = Modifier
                .width(380.dp)
                .height(50.dp)
                .constrainAs(createAccountBtn) {
                    top.linkTo(loginBtn.bottom, margin = 12.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            onClick = { /* TODO: Create account logic */ }
        )

        GoogleLoginButton(
            modifier = Modifier
                .width(380.dp)
                .height(50.dp)
                .constrainAs(googleBtn) {
                    top.linkTo(createAccountBtn.bottom, margin = 12.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            onClick = { /* TODO: Google login logic */ }
        )

        ForgotPasswordText(
            modifier = Modifier.constrainAs(forgotText) {
                top.linkTo(googleBtn.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 32.dp)
            }
        )

        ForgotPasswordIcon(
            modifier = Modifier.constrainAs(forgotIcon) {
                top.linkTo(forgotText.top)
                bottom.linkTo(forgotText.bottom)
                start.linkTo(parent.start, margin = 12.dp)
            }
        )
    }
}

@Composable
fun Title(modifier: Modifier = Modifier) {
    Text(
        text = "Welcome Back",
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        modifier = modifier
    )
}

@Composable
fun EmailField(email: String, onEmailChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        value = email,
        onValueChange = onEmailChange,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = AzulGriseaseo,
            focusedContainerColor = AzulGriseaseo,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        label = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Email",
                modifier = Modifier.size(24.dp),
                tint = GrisTonoAlto
            )
            Text(
                text = "Email",
                modifier = Modifier.padding(start = 30.dp),
                color = GrisTonoAlto,
                fontSize = 17.sp
            )
        },
        shape = RoundedCornerShape(25.dp),
        modifier = modifier
    )
}

@Composable
fun PasswordField(password: String, onPasswordChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        value = password,
        onValueChange = onPasswordChange,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = AzulGriseaseo,
            focusedContainerColor = AzulGriseaseo,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),

        label = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Password",
                modifier = Modifier.size(24.dp),
                tint = GrisTonoAlto
            )
            Text(
                text = "Password",
                modifier = Modifier.padding(start = 30.dp),
                color = GrisTonoAlto,
                fontSize = 17.sp
            )
        },
        shape = RoundedCornerShape(25.dp),
        modifier = modifier
    )
}

@Composable
fun LoginButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = AzulTonoAlto),
        modifier = modifier
    ) {
        Text(
            text = "Login",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CreateAccountButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = AzulGriseaseo),
        modifier = modifier
    ) {
        Text(
            text = "Crear nueva cuenta",
            color = AzulTonoAlto,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun GoogleLoginButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = AzulGriseaseo),
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = R.drawable.iconodegogle),
            contentDescription = "Google logo",
            modifier = Modifier.size(34.dp).padding(end = 12.dp),
            tint = Color.Unspecified
        )
        Text(
            text = "Inicia sesion con Google",
            color = AzulTonoAlto,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ForgotPasswordText(modifier: Modifier = Modifier) {
    Text(
        text = "Forgot Password?",
        color = NegroTonoBajo,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        modifier = modifier
    )
}

@Composable
fun ForgotPasswordIcon(modifier: Modifier = Modifier) {
    Icon(
        imageVector = Icons.Default.AccountCircle,
        contentDescription = "Forgot password icon",
        tint = NegroTonoBajo,
        modifier = modifier.size(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}