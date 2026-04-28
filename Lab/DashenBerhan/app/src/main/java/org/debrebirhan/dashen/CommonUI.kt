package org.debrebirhan.dashen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Numpad(
    onNumberClick: (String) -> Unit,
    onDeleteClick: () -> Unit,
    onDoneClick: () -> Unit,
    darkBlue: Color
) {
    val keys = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "delete", "0", "done")

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 2.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(bottom = 4.dp)
    ) {
        items(keys) { key ->
            when (key) {
                "delete" -> {
                    NumpadButton(
                        onClick = onDeleteClick,
                        content = {
                            Icon(
                                painter = painterResource(id =R.drawable.ic_backspace_x),
                                contentDescription = "Delete",
                                tint = darkBlue,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    )
                }
                "done" -> {
                    NumpadButton(
                        onClick = onDoneClick,
                        containerColor = darkBlue,
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_chevron_right),
                                contentDescription = "Done",
                                tint = Color.White,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    )
                }
                else -> {
                    NumpadButton(
                        onClick = { onNumberClick(key) },
                        content = {
                            Text(
                                text = key,
                                fontSize = 32.sp,
                                color = Color.DarkGray
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun NumpadButton(
    onClick: () -> Unit,
    containerColor: Color = Color(0xFFF8F9FA),
    content: @Composable () -> Unit
) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        shape = RoundedCornerShape(8.dp),
        color = containerColor
    ) {
        Box(contentAlignment = Alignment.Center) {
            content()
        }
    }
}