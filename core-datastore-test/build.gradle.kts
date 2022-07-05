plugins {
    id("dailyranking.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    api(project(":core-datastore"))
    implementation(project(":core-test"))

    api(libs.data.store)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kaptAndroidTest(libs.hilt.compiler)
}