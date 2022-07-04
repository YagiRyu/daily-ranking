import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc
import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.builtins

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("dailyranking.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    alias(libs.plugins.protobuf)
}

protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                val java by registering {
                    option("lite")
                }
                val kotlin by registering {
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    implementation(project(":core-model"))
    implementation(project(":core-common"))

    testImplementation(project(":core-test"))

    implementation(libs.data.store)

    implementation(libs.protobuf.kotlin.lite)

    implementation(libs.coroutine)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kaptAndroidTest(libs.hilt.android.test)
}
