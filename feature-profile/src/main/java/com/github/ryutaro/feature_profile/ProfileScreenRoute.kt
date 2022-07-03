package com.github.ryutaro.feature_profile

import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreenRoute(
    windowSizeClass: WindowSizeClass,
    modifier: Modifier = Modifier
) {
    ProfileScreen()
}

@Composable
fun ProfileScreen() {
    Text(text = "Profile screen", fontSize = 32.sp)
}
