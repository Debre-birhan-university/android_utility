package org.debrebirhan.dashen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactUsScreen(
    onBackClick: () -> Unit = {},
    onShortCodeClick: () -> Unit = {},
    onEmailClick: () -> Unit = {},
    onWebsiteClick: () -> Unit = {}
) {
    val darkBlue = Color(0xFF002D72)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.contact_us), color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = darkBlue)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            ContactItem(
                iconId = R.drawable.ic_phone,
                label = stringResource(id = R.string.short_code),
                value = stringResource(id = R.string.short_code_value),
                onClick = onShortCodeClick,
                darkBlue = darkBlue
            )

            ContactItem(
                iconId = R.drawable.ic_email,
                label = stringResource(id = R.string.email),
                value = stringResource(id = R.string.email_value),
                onClick = onEmailClick,
                darkBlue = darkBlue
            )

            ContactItem(
                iconId = R.drawable.ic_globe,
                label = stringResource(id = R.string.website),
                value = stringResource(id = R.string.website_value),
                onClick = onWebsiteClick,
                darkBlue = darkBlue
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(id = R.string.contact_footer_text),
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )
        }
    }
}

@Composable
fun ContactItem(
    iconId: Int,
    label: String,
    value: String,
    onClick: () -> Unit,
    darkBlue: Color
) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        color = Color(0xFFF8F9FA)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(darkBlue.copy(alpha = 0.1f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = null,
                    tint = darkBlue,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = label, fontSize = 12.sp, color = Color.Gray)
                Text(text = value, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.DarkGray)
            }
        }
    }
}
