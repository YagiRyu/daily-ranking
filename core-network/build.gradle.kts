plugins {
    id("dailyranking.android.library")
    kotlin("kapt")
}

dependencies {
    implementation(project(":core-model"))
    implementation(project(":core-common"))

    api(libs.retrofit.converter.moshi)
    api(libs.retrofit)
}
