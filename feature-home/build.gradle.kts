plugins {
    id("dailyranking.android.library")
    id("dailyranking.android.library.compose")
    id("dailyranking.android.feature")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(project(":core-navigation"))

    implementation(libs.material3.windowSizeClass)
}