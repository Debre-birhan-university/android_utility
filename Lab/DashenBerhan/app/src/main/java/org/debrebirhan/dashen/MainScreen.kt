package org.debrebirhan.dashen

import androidx.compose.foundation.BorderStroke
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
fun LoginScreen(
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit = {},
    onFeedbackClick: () -> Unit = {},
    onHeadphonesClick: () -> Unit = {},
    onLanguageClick: () -> Unit = {},
    onResetPinClick: () -> Unit = {},
    onSignInClick: (String) -> Unit = {},
    isError: Boolean = false
) {
    var pin by remember { mutableStateOf("") }
    val darkBlue = Color(0xFF002D72)
    val backgroundColor = Color.White

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .statusBarsPadding()
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "Menu",
                tint = darkBlue,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onMenuClick() }
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    onClick = onFeedbackClick,
                    shape = RoundedCornerShape(24.dp),
                    color = Color.White,
                    border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_feedback),
                            contentDescription = null,
                            tint = darkBlue,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = stringResource(id = R.string.feedback),
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.White, CircleShape)
                        .border(1.dp, Color.LightGray.copy(alpha = 0.5f), CircleShape)
                        .clickable { onHeadphonesClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_headphones),
                        contentDescription = "Support",
                        tint = darkBlue,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Surface(
                    onClick = onLanguageClick,
                    shape = RoundedCornerShape(24.dp),
                    color = Color.White,
                    border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_globe),
                            contentDescription = null,
                            tint = darkBlue,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = stringResource(id = R.string.en),
                            fontSize = 14.sp,
                            color = Color.DarkGray,
                            fontWeight = FontWeight.Bold
                        )
                    }
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

        // Welcome Text
        Text(
            text = stringResource(id = R.string.welcome_back),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = darkBlue,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.enter_pin_to_sign_in),
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (isError) {
            Text(
                text = stringResource(id = R.string.invalid_pin),
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // PIN Indicator
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
                    if (index < pin.length) {
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .background(darkBlue, CircleShape)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(id = R.string.show_pin),
            color = darkBlue,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { /* Toggle PIN visibility */ }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.forgot_pin),
                color = Color.Gray,
                fontSize = 16.sp
            )
            Text(
                text = stringResource(id = R.string.reset_pin),
                color = darkBlue,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.clickable { onResetPinClick() }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Numpad
        Numpad(
            onNumberClick = { if (pin.length < 6) pin += it },
            onDeleteClick = { if (pin.isNotEmpty()) pin = pin.dropLast(1) },
            onDoneClick = { if (pin.length == 6) onSignInClick(pin) },
            darkBlue = darkBlue
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    DashenBerhanTheme {
        LoginScreen()
    }
}
