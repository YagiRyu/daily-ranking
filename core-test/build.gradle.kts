plugins {
    id("dailyranking.android.library")
    kotlin("kapt")
}

dependencies {
    implementation(project(":core-common"))

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    api(libs.junit.test)
    api(libs.coroutine.test)
    api(libs.arch.core)
    api(libs.turbine)

    api(libs.espresso.core)
    api(libs.androidx.ui.test.junit)
    api(libs.androidx.compose.ui.test)
    api(libs.androidx.test.rules)
    api(libs.androidx.test.runner)
    api(libs.hilt.android.test)
}
