pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidKotlinJavaDsWorkbench"
include(":cheezy_code_compose")
include(":cheezy_code_compose_advance")
include(":libJavaPractice")
include(":libKotlinPractice")
include(":cheezy_code_unit_testing")
include(":cheezy_code_dagger2")
include(":cheezy_code_hilt")
include(":libLeetCode")
include(":philipp_lackner")
include(":java_kotlin_documentation")
include(":realm_sdk_android")
include(":cheezy_code_workmanager")
include(":mobile_app_info")
include(":my_android_library")
include(":androidtopics")
