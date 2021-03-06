plugins {
    id("dailyranking.android.application.compose")
    id("dailyranking.android.application")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.github.ryutaro.daily_ranking"

    defaultConfig {
        applicationId = "com.github.ryutaro.daily_ranking"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.github.ryutaro.core_test.CustomTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":core-navigation"))
    implementation(project(":core-designsystem"))
    implementation(project(":core-datastore"))

    implementation(project(":feature-home"))
    implementation(project(":feature-profile"))

    androidTestImplementation(":core-test")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.material3.core)
    implementation(libs.material3.windowSizeClass)
    implementation(libs.material.icon)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kaptAndroidTest(libs.hilt.compiler)
    androidTestImplementation(libs.hilt.android.test)
}