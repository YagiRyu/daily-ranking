plugins {
    id("dailyranking.android.application.compose")
    id("dailyranking.android.application")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    api(libs.androidx.hilt.navigation)
    api(libs.androidx.navigation.compose)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
