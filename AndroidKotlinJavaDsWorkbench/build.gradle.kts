// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.21" apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.21" apply false

//    id("org.jetbrains.dokka") version "1.6.0" apply false
//    id("org.jetbrains.dokka") version "1.9.10"
}

// The versioning plugin must be applied in all submodules
/*subprojects {
    repositories {
        mavenCentral()
    }
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.dokka")
    }
    val dokkaPlugin by configurations
    dependencies {
        dokkaPlugin("org.jetbrains.dokka:versioning-plugin:1.9.10")
    }
}*/

