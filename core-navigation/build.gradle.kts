plugins {
    id("dailyranking.android.library")
    id("dailyranking.android.library.compose")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    api(libs.androidx.hilt.navigation)
    api(libs.androidx.navigation.compose)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
