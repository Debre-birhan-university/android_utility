package org.debrebirhan.dashen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.debrebirhan.dashen.ui.theme.DashenBerhanTheme

@Composable
fun PinSetupScreen(
    modifier: Modifier = Modifier,
    isReset: Boolean = false,
    onPinCreated: (String) -> Unit = {}
) {
    var pin by remember { mutableStateOf("") }
    var confirmPin by remember { mutableStateOf("") }
    var step by remember { mutableIntStateOf(1) } // 1: Enter, 2: Confirm
    var errorMessage by remember { mutableStateOf("") }

    val darkBlue = Color(0xFF002D72)
    val backgroundColor = Color.White

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .statusBarsPadding()
    ) {
        // Top Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Surface(
                onClick = { if (step == 2) step = 1 else /* Handle exit */ Unit },
                shape = RoundedCornerShape(12.dp),
                color = Color.White,
                modifier = Modifier.size(48.dp),
                shadowElevation = 1.dp
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Back",
                        tint = darkBlue,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Logo
        Image(
            painter = painterResource(id = R.drawable.dashen_logo),
            contentDescription = "Dashen Bank Logo",
            modifier = Modifier
                .height(100.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Title
        Text(
            text = stringResource(id = if (isReset) R.string.reset_pin_title else R.string.create_pin),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = darkBlue,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = if (step == 1) R.string.enter_new_pin else R.string.confirm_new_pin),
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // PIN Indicator
        val currentPin = if (step == 1) pin else confirmPin
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(6) { index ->
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .padding(4.dp)
                        .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                        .background(Color.White, RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    if (index < currentPin.length) {
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .background(darkBlue, CircleShape)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Numpad
        Numpad(
            onNumberClick = { num ->
                if (step == 1) {
                    if (pin.length < 6) pin += num
                } else {
                    if (confirmPin.length < 6) confirmPin += num
                }
            },
            onDeleteClick = {
                if (step == 1) {
                    if (pin.isNotEmpty()) pin = pin.dropLast(1)
                } else {
                    if (confirmPin.isNotEmpty()) confirmPin = confirmPin.dropLast(1)
                }
            },
            onDoneClick = {
                if (step == 1) {
                    if (pin.length == 6) {
                        step = 2
                        errorMessage = ""
                    }
                } else {
                    if (confirmPin.length == 6) {
                        if (pin == confirmPin) {
                            onPinCreated(pin)
                        } else {
                            confirmPin = ""
                            errorMessage = "PINs do not match. Try again."
                        }
                    }
                }
            },
            darkBlue = darkBlue
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PinSetupScreenPreview() {
    DashenBerhanTheme {
        PinSetupScreen()
    }
}
