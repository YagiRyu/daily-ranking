package com.github.ryutaro.daily_ranking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.view.WindowCompat
import com.github.ryutaro.daily_ranking.ui.DailyRankingApp
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent { DailyRankingApp(calculateWindowSizeClass(this)) }
    }
}
