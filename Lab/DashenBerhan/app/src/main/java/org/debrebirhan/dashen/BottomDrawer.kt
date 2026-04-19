package org.debrebirhan.dashen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.debrebirhan.dashen.ui.theme.DashenBerhanTheme

data class Language(val name: String, val code: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSelectorBottomSheet(
    onDismissRequest: () -> Unit,
    selectedLanguageCode: String,
    onLanguageSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val languages = listOf(
        Language(stringResource(id = R.string.lang_amharic), "am"),
        Language(stringResource(id = R.string.lang_english), "en"),
        Language(stringResource(id = R.string.lang_oromoo), "om"),
        Language(stringResource(id = R.string.lang_somali), "so"),
        Language(stringResource(id = R.string.lang_tigrinya), "ti")
    )

    val darkBlue = Color(0xFF002D72)

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
        containerColor = Color.White,
        dragHandle = {
            Box(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .width(44.dp)
                    .height(4.dp)
                    .background(Color.LightGray.copy(alpha = 0.5f), CircleShape)
            )
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        ) {
            Text(
                text = stringResource(id = R.string.change_language),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = darkBlue,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                textAlign = TextAlign.Center
            )

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(languages) { language ->
                    LanguageItem(
                        language = language,
                        isSelected = language.code == selectedLanguageCode,
                        onClick = { onLanguageSelected(language.code) },
                        darkBlue = darkBlue
                    )
                }
            }
        }
    }
}

@Composable
fun LanguageItem(
    language: Language,
    isSelected: Boolean,
    onClick: () -> Unit,
    darkBlue: Color
) {
    val backgroundColor = if (isSelected) Color(0xFFF8F9FA) else Color.Transparent
    val borderColor = if (isSelected) Color.LightGray.copy(alpha = 0.5f) else Color.Transparent

    Surface(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp),
        color = backgroundColor,
        border = if (isSelected) BorderStroke(1.dp, borderColor) else null
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .border(
                        width = if (isSelected) 0.dp else 1.dp,
                        color = if (isSelected) Color.Transparent else Color.Gray,
                        shape = CircleShape
                    )
                    .background(
                        color = if (isSelected) darkBlue else Color.Transparent,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (isSelected) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = language.name,
                fontSize = 18.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (isSelected) darkBlue else Color(0xFF4A4A4A)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LanguageSelectorPreview() {
    DashenBerhanTheme {
        Column(modifier = Modifier.padding(16.dp).background(Color.White)) {
            LanguageItem(
                language = Language("English", "en"),
                isSelected = true,
                onClick = {},
                darkBlue = Color(0xFF002D72)
            )
            LanguageItem(
                language = Language("አማርኛ", "am"),
                isSelected = false,
                onClick = {},
                darkBlue = Color(0xFF002D72)
            )
        }
    }
}
