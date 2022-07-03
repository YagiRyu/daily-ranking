package com.github.ryutaro.feature_home

import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreenRoute(
    windowSizeClass: WindowSizeClass,
    modifier: Modifier = Modifier
) {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    Text(text = "Home screen", fontSize = 32.sp)
}
