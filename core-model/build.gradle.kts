plugins {
    id("dailyranking.android.library")
    kotlin("kapt")
}

dependencies {
    api(libs.moshi.kotlin)
    api(libs.moshi)
}
