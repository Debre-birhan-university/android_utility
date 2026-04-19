package org.debrebirhan.dashen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
fun DashboardScreen(
    modifier: Modifier = Modifier
) {
    val darkBlue = Color(0xFF002D72)
    val lightBlue = Color(0xFF194CB0)

    Scaffold(
        bottomBar = { DashboardBottomNavigation() }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFF8F9FA))
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(darkBlue, lightBlue)
                            )
                        )
                        .padding(bottom = 24.dp)
                ) {
                    Column {
                        DashboardHeader()
                        AccountSection()
                        QuickActionsGrid()
                    }
                }
            }

            item {
                ECommerceBanner()
            }

            item {
                PromotionalBanner(
                    title = "Dashen Edil",
                    color = Color(0xFF194CB0)
                )
            }

            item {
                SectionHeader(title = stringResource(id = R.string.three_click_ecommerce))
                ProductHorizontalList()
            }

            item {
                SectionHeader(title = stringResource(id = R.string.featured_products))
                ProductHorizontalList()
            }

            item {
                SectionHeader(title = stringResource(id = R.string.mini_apps))
                MiniAppsGrid()
            }

            item {
                LinkAccountCard()
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun DashboardHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.White.copy(alpha = 0.2f), CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(id = R.string.hello_user),
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                text = stringResource(id = R.string.welcome_back_compact),
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notifications),
                    contentDescription = "Notifications",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun AccountSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.account_name),
            color = Color.White,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.account_balance),
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(modifier = Modifier.size(20.dp).background(Color.White.copy(alpha = 0.3f), CircleShape))
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = R.string.account_number),
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(modifier = Modifier.size(16.dp).background(Color.White.copy(alpha = 0.3f)))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Surface(
            onClick = { },
            shape = RoundedCornerShape(20.dp),
            color = Color.White.copy(alpha = 0.1f),
            border = BorderStroke(1.dp, Color.White.copy(alpha = 0.3f))
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.accounts),
                    color = Color.White,
                    fontSize = 14.sp
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_chevron_right),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
fun QuickActionsGrid() {
    val actions = listOf(
        stringResource(id = R.string.send_to_dashen),
        stringResource(id = R.string.send_to_other),
        stringResource(id = R.string.send_to_wallet),
        stringResource(id = R.string.micro_finance),
        stringResource(id = R.string.mobile_topup),
        stringResource(id = R.string.bill_payments),
        stringResource(id = R.string.merchant_payment),
        stringResource(id = R.string.see_more)
    )

    Column(modifier = Modifier.padding(16.dp)) {
        for (i in 0 until 2) {
            Row(modifier = Modifier.fillMaxWidth()) {
                for (j in 0 until 4) {
                    val index = i * 4 + j
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Surface(
                            modifier = Modifier.size(64.dp),
                            shape = RoundedCornerShape(12.dp),
                            color = Color.White.copy(alpha = 0.1f)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Box(modifier = Modifier.size(24.dp).background(Color.White, RoundedCornerShape(4.dp)))
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = actions[index],
                            color = Color.White,
                            fontSize = 11.sp,
                            textAlign = TextAlign.Center,
                            maxLines = 2,
                            lineHeight = 14.sp
                        )
                    }
                }
            }
            if (i == 0) Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ECommerceBanner() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color(0xFFF0F7FF), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Box(modifier = Modifier.size(24.dp).background(Color(0xFF194CB0)))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(id = R.string.e_commerce),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF002D72)
                )
                Text(
                    text = stringResource(id = R.string.e_commerce_desc),
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_chevron_right),
                contentDescription = null,
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun PromotionalBanner(title: String, color: Color) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        color = color
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "Play Now & Earn Rewards", color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
            }
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .background(Color.White.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
            )
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, color = Color(0xFF002D72), fontSize = 16.sp)
        Text(text = stringResource(id = R.string.see_all), color = Color(0xFF194CB0), fontSize = 14.sp)
    }
}

@Composable
fun ProductHorizontalList() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(5) {
            Surface(
                modifier = Modifier.width(160.dp),
                shape = RoundedCornerShape(12.dp),
                color = Color.White,
                shadowElevation = 1.dp
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .background(Color(0xFFF8F9FA))
                    )
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = "Product Name", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                        Text(text = "100.00 ETB", fontSize = 12.sp, color = Color(0xFF194CB0), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun MiniAppsGrid() {
    val apps = listOf("Dashen Edil", "DSTV", "Ethiopian Airlines", "Beka Geter", "Big Art", "Telecom")

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        for (i in 0 until 2) {
            Row(modifier = Modifier.fillMaxWidth()) {
                for (j in 0 until 3) {
                    val index = i * 3 + j
                    Surface(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        shape = RoundedCornerShape(12.dp),
                        color = Color.White,
                        shadowElevation = 1.dp
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(modifier = Modifier.size(32.dp).background(Color.LightGray, CircleShape))
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = apps[index],
                                fontSize = 11.sp,
                                textAlign = TextAlign.Center,
                                maxLines = 1
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LinkAccountCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFF194CB0)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(40.dp).background(Color.White.copy(alpha = 0.2f), CircleShape))
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = stringResource(id = R.string.link_other_account), color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = stringResource(id = R.string.link_other_account_desc), color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
            }
            Box(modifier = Modifier.size(24.dp).background(Color.White.copy(alpha = 0.2f), RoundedCornerShape(4.dp)))
        }
    }
}

@Composable
fun DashboardBottomNavigation() {
    NavigationBar(
        containerColor = Color.White,
        contentColor = Color(0xFF002D72)
    ) {
        NavigationBarItem(
            icon = { Box(modifier = Modifier.size(24.dp).background(Color(0xFF002D72), CircleShape)) },
            label = { Text(stringResource(id = R.string.home)) },
            selected = true,
            onClick = { }
        )
        NavigationBarItem(
            icon = { Box(modifier = Modifier.size(24.dp).background(Color.Gray, CircleShape)) },
            label = { Text(stringResource(id = R.string.apps)) },
            selected = false,
            onClick = { }
        )
        NavigationBarItem(
            icon = { Box(modifier = Modifier.size(24.dp).background(Color.Gray, CircleShape)) },
            label = { Text(stringResource(id = R.string.transactions)) },
            selected = false,
            onClick = { }
        )
        NavigationBarItem(
            icon = { Box(modifier = Modifier.size(24.dp).background(Color.Gray, CircleShape)) },
            label = { Text(stringResource(id = R.string.profile)) },
            selected = false,
            onClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashenBerhanTheme {
        DashboardScreen()
    }
}
