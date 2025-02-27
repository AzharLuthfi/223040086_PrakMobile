package id.ac.unpas.hellocompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.unpas.hellocompose.ui.theme.HelloComposeTheme
import id.ac.unpas.hellocompose.ui.theme.Pink40
import id.ac.unpas.hellocompose.ui.theme.Purple80

class registrasi : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormRegistration(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FormRegistration(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val name = remember { mutableStateOf(TextFieldValue("")) }
    val username = remember { mutableStateOf(TextFieldValue("")) }
    val phoneNumber = remember { mutableStateOf(TextFieldValue("")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val address = remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = modifier.fillMaxWidth()) {
        // Name field
        Text(text = "Nama", modifier = Modifier.padding(4.dp).fillMaxWidth())
        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.padding(4.dp).fillMaxWidth()
        )

        // Username field
        Text(text = "Username", modifier = Modifier.padding(4.dp).fillMaxWidth())
        TextField(
            value = username.value,
            onValueChange = { username.value = it },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.padding(4.dp).fillMaxWidth()
        )

        // Phone number field
        Text(text = "Nomor Telepon", modifier = Modifier.padding(4.dp).fillMaxWidth())
        TextField(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.padding(4.dp).fillMaxWidth()
        )

        // Email field
        Text(text = "Email", modifier = Modifier.padding(4.dp).fillMaxWidth())
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.padding(4.dp).fillMaxWidth()
        )

        // Address field
        Text(text = "Alamat Rumah", modifier = Modifier.padding(4.dp).fillMaxWidth())
        TextField(
            value = address.value,
            onValueChange = { address.value = it },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.padding(4.dp).fillMaxWidth()
        )

        val saveButtonColors = ButtonDefaults.buttonColors(
            containerColor = Purple80,
            contentColor = Pink40
        )

        val resetButtonColors = ButtonDefaults.buttonColors(
            containerColor = Pink40,
            contentColor = Purple80
        )

        Spacer(modifier = Modifier.weight(1f).width(0.dp))

        Row(modifier = Modifier.padding(4.dp).fillMaxWidth()) {
            Button(
                modifier = Modifier.weight(5f),
                onClick = {
                    if (
                        name.value.text.isNotEmpty() &&
                        username.value.text.isNotEmpty() &&
                        phoneNumber.value.text.isNotEmpty() &&
                        email.value.text.isNotEmpty() &&
                        address.value.text.isNotEmpty()
                    ) {
                        Toast.makeText(
                            context,
                            "Halo, ${name.value.text}",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            "Semua inputan harus diisi",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                },
                colors = saveButtonColors
            ) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }

            Button(
                modifier = Modifier.weight(5f),
                onClick = {
                    name.value = TextFieldValue("")
                    username.value = TextFieldValue("")
                    phoneNumber.value = TextFieldValue("")
                    email.value = TextFieldValue("")
                    address.value = TextFieldValue("")
                },
                colors = resetButtonColors
            ) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationPreview() {
    HelloComposeTheme {
        FormRegistration()
    }
}