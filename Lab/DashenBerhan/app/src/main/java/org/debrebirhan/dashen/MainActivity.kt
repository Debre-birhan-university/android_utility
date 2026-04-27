package org.debrebirhan.dashen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.debrebirhan.dashen.ui.theme.DashenBerhanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashenBerhanTheme {
                MainAppNavigation()
            }
        }
    }
}

@Composable
fun MainAppNavigation() {
    val context = LocalContext.current
    val navController = rememberNavController()
    val pinManager = remember { PinManager(context) }
    
    // UI State synchronized with storage
    var userPin by remember { mutableStateOf(pinManager.getPin()) }
    var showLanguageDrawer by remember { mutableStateOf(false) }
    var selectedLanguageCode by remember { mutableStateOf("en") }
    var isError by remember { mutableStateOf(false) }

    val startDestination = if (userPin.isEmpty()) "create_pin" else "login"

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // PIN Creation Route
        composable("create_pin") {
            PinSetupScreen(
                isReset = false,
                onPinCreated = { newPin ->
                    pinManager.savePin(newPin)
                    userPin = newPin
                    navController.navigate("login") {
                        popUpTo("create_pin") { inclusive = true }
                    }
                }
            )
        }

        // Login Screen Route
        composable("login") {
            LoginScreen(
                onFeedbackClick = { navController.navigate("feedback") },
                onHeadphonesClick = { navController.navigate("contact") },
                onLanguageClick = { showLanguageDrawer = true },
                onResetPinClick = { navController.navigate("reset_pin") },
                onSignInClick = { enteredPin ->
                    if (enteredPin == userPin) {
                        isError = false
                        navController.navigate("dashboard") {
                            popUpTo("login") { inclusive = true }
                        }
                    } else {
                        isError = true
                    }
                },
                isError = isError
            )
        }

        // Dashboard Route
        composable("dashboard") {
            DashboardScreen()
        }

        // Feedback Screen Route
        composable("feedback") {
            FeedbackScreen(
                onBackClick = { navController.popBackStack() },
                onNextClick = { _, _ -> navController.popBackStack() }
            )
        }

        // Contact Us Route
        composable("contact") {
            val shortCode = org.debrebirhan.dashen.R.string.short_code_value
            val email = org.debrebirhan.dashen.R.string.email_value
            val website = org.debrebirhan.dashen.R.string.website_value

            val shortCodeStr = context.getString(shortCode)
            val emailStr = context.getString(email)
            val websiteStr = context.getString(website)

            ContactUsScreen(
                onBackClick = { navController.popBackStack() },
                onShortCodeClick = {
                    val intent = Intent(Intent.ACTION_DIAL, "tel:$shortCodeStr".toUri())
                    context.startActivity(intent)
                },
                onEmailClick = {
                    val intent = Intent(Intent.ACTION_SENDTO, "mailto:$emailStr".toUri())
                    context.startActivity(intent)
                },
                onWebsiteClick = {
                    val webUri = if (!websiteStr.startsWith("http")) "https://$websiteStr" else websiteStr
                    val intent = Intent(Intent.ACTION_VIEW, webUri.toUri())
                    context.startActivity(intent)
                }
            )
        }

        // Reset PIN Route
        composable("reset_pin") {
            PinSetupScreen(
                isReset = true,
                onPinCreated = { newPin ->
                    pinManager.savePin(newPin)
                    userPin = newPin
                    navController.popBackStack()
                }
            )
        }
    }

    // Modal Overlays
    if (showLanguageDrawer) {
        LanguageSelectorBottomSheet(
            onDismissRequest = { showLanguageDrawer = false },
            selectedLanguageCode = selectedLanguageCode,
            onLanguageSelected = { code ->
                selectedLanguageCode = code
                showLanguageDrawer = false
            }
        )
    }
}