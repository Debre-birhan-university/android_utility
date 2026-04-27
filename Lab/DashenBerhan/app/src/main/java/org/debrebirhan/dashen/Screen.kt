package org.debrebirhan.dashen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
fun ContactUsScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onShortCodeClick: () -> Unit = {},
    onEmailClick: () -> Unit = {},
    onWebsiteClick: () -> Unit = {}
) {
    val darkBlue = Color(0xFF002D72)
    val lightGray = Color(0xFF8E8E93)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 8.dp, end = 16.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
                Text(
                    text = stringResource(id = R.string.contact_us),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            ContactItem(
                iconRes = R.drawable.ic_phone,
                label = stringResource(id = R.string.short_code),
                value = stringResource(id = R.string.short_code_value),
                onClick = onShortCodeClick,
                iconColor = darkBlue,
                labelColor = lightGray,
                valueColor = darkBlue
            )

            Spacer(modifier = Modifier.height(32.dp))

            ContactItem(
                iconRes = R.drawable.ic_email,
                label = stringResource(id = R.string.email),
                value = stringResource(id = R.string.email_value),
                onClick = onEmailClick,
                iconColor = darkBlue,
                labelColor = lightGray,
                valueColor = darkBlue
            )

            Spacer(modifier = Modifier.height(32.dp))

            ContactItem(
                iconRes = R.drawable.ic_globe,
                label = stringResource(id = R.string.website),
                value = stringResource(id = R.string.website_value),
                onClick = onWebsiteClick,
                iconColor = darkBlue,
                labelColor = lightGray,
                valueColor = darkBlue
            )

            Spacer(modifier = Modifier.weight(1f))

            SocialMediaSection(backgroundColor = darkBlue)

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(id = R.string.contact_footer_text),
                style = MaterialTheme.typography.bodyMedium,
                color = lightGray,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp)
            )
        }
    }
}

@Composable
fun ContactItem(
    iconRes: Int,
    label: String,
    value: String,
    onClick: () -> Unit,
    iconColor: Color,
    labelColor: Color,
    valueColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.width(20.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                fontSize = 14.sp,
                color = labelColor
            )
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = valueColor
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_chevron_right),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun SocialMediaSection(
    modifier: Modifier = Modifier,
    backgroundColor: Color
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val icons = listOf(
            R.drawable.ic_telegram,
            R.drawable.ic_facebook,
            R.drawable.ic_instagram,
            R.drawable.ic_linkedin,
            R.drawable.ic_x,
            R.drawable.ic_tiktok,
            R.drawable.ic_youtube
        )

        icons.forEachIndexed { index, iconRes ->
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(color = backgroundColor, shape = CircleShape)
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }

            if (index < icons.size - 1) {
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactUsScreenPreview() {
    DashenBerhanTheme {
        ContactUsScreen()
    }
}
