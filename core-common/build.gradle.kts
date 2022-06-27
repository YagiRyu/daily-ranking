plugins {
    id("dailyranking.android.library")
    kotlin("kapt")
}

dependencies {
    implementation(libs.coroutine)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
