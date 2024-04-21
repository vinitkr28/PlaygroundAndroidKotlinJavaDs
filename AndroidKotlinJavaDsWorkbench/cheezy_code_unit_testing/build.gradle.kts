plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
//    id("com.google.devtools.ksp")
    id("kotlin-kapt")
}

android {
    namespace = "cheezy_code.unit_testing"
    compileSdk = 34

    defaultConfig {
        applicationId = "cheezy_code.unit_testing"
        minSdk = 34
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
    implementation("androidx.activity:activity:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


    implementation(Dependencies.google_gson)

    testImplementation("junit:junit:4.13.2")
    //testImplementation("junit:junit:4.12")


    // To use the androidx.test.core APIs
    androidTestImplementation("androidx.test:core:1.5.0")
    // Kotlin extensions for androidx.test.core
    androidTestImplementation("androidx.test:core-ktx:1.5.0")
    // To use the JUnit Extension APIs
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    // Kotlin extensions for androidx.test.ext.junit
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.5")
    androidTestImplementation("androidx.test:rules:1.5.0")
    // To use the androidx.test.espresso
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.1")


    // To use the Truth Extension APIs
    androidTestImplementation("androidx.test.ext:truth:1.5.0")

    // To use the androidx.test.runner APIs
    androidTestImplementation("androidx.test:runner:1.5.2")

    // To use android test orchestrator
    androidTestUtil("androidx.test:orchestrator:1.4.2")


//    val room_version = "2.3.0"
    val room_version = "2.5.2"
//    kapt("org.xerial:sqlite-jdbc:3.41.2.2")
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
//    ksp("androidx.room:room-compiler:$room_version")
    kapt("androidx.room:room-compiler:$room_version")

    testImplementation("androidx.room:room-testing:$room_version")
    androidTestImplementation("androidx.room:room-testing:$room_version")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0")

    implementation("androidx.room:room-coroutines:2.1.0-alpha04")
    androidTestImplementation("androidx.room:room-coroutines:2.1.0-alpha04")
    testImplementation("androidx.room:room-coroutines:2.1.0-alpha04")


    testImplementation("org.mockito:mockito-core:4.0.0")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
//    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")

//    testImplementation("org.mockito:mockito-inline:5.2.0")








/*
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    kapt("org.xerial:sqlite-jdbc:3.41.2.2")
    implementation("androidx.room:room-runtime:2.3.0")
//    kapt("androidx.room:room-compiler:2.3.0")
    annotationProcessor("androidx.room:room-compiler:2.3.0")
    implementation("androidx.room:room-ktx:2.3.0")*/

}