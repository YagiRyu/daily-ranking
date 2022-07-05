pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven(url = "https://androidx.dev/snapshots/builds/8455591/artifacts/repository") {
            content {
                // The AndroidX snapshot repository will only have androidx artifacts, don't
                // bother trying to find other ones
                includeGroupByRegex("androidx\\..*")
            }
        }
        google()
        mavenCentral()
    }
}
rootProject.name = "daily-ranking"
include(":app")
include(":core-navigation")
include(":feature-home")
include(":core-ui")
include(":feature-profile")
include(":core-datastore")
include(":core-common")
include(":core-designsystem")
include(":core-test")
include(":core-network")
include(":core-model")
include(":core-data")
include(":core-datastore:proto")
include(":core-datastore-test")
