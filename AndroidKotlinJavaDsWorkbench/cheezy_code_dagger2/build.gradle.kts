plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "cheezy_code.dagger2"
    compileSdk = 34

    defaultConfig {
        applicationId = "cheezy_code.dagger2"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    /*implementation("com.google.dagger:dagger:2.40.5")
    kapt("com.google.dagger:dagger-compiler:2.40.5")*/


    /*
    // Dagger dependencies
    val dagger_version = "2.44"
    implementation("com.google.dagger:dagger:$dagger_version")
    kapt("com.google.dagger:dagger-compiler:$dagger_version")
    implementation("com.google.dagger:dagger-android:$dagger_version")
//    implementation("com.google.dagger:dagger-android-support:$dagger_version") // if you use the support libraries
    kapt("com.google.dagger:dagger-android-processor:$dagger_version")
    */


    /*
    This block is moved inside buildSrc
    val dagger_version = "2.48.1"
    implementation("com.google.dagger:dagger:$dagger_version")
    implementation("com.google.dagger:dagger-android:$dagger_version")
    implementation("com.google.dagger:dagger-android-support:$dagger_version")
    kapt("com.google.dagger:dagger-compiler:$dagger_version")
    kapt("com.google.dagger:dagger-android-processor:$dagger_version")
    */

    implementation(Dependencies.dagger)
    implementation(Dependencies.dagger_android)
    implementation(Dependencies.dagger_android_support)
    kapt(Dependencies.kapt_dagger_compiler)
    kapt(Dependencies.kapt_dagger_android_processor)
}