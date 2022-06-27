plugins {
    id("dailyranking.android.library")
    id("dailyranking.android.library.compose")
}

dependencies {
    api(libs.androidx.ui)
    api(libs.material.icon)
    api(libs.material3.core)
    api(libs.androidx.ui.tooling.preview)
    api(libs.androidx.core.ktx)
}