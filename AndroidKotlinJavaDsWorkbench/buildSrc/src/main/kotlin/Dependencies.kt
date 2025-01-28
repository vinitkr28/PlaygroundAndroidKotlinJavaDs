object Dependencies {
    //Dagger
    const val dagger =
        "com.google.dagger:dagger:${Versions.dagger_version}"
    const val dagger_android =
        "com.google.dagger:dagger-android:${Versions.dagger_version}"
    const val dagger_android_support =
        "com.google.dagger:dagger-android-support:${Versions.dagger_version}"
    const val kapt_dagger_compiler =
        "com.google.dagger:dagger-compiler:${Versions.dagger_version}"
    const val kapt_dagger_android_processor =
        "com.google.dagger:dagger-android-processor:${Versions.dagger_version}"


    //HILT
    val hiltAndroid by lazy { "androidx.hilt:hilt-android:${Versions.hilt}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltCompiler}" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }


    //Google GSON
    const val google_gson =
        "com.google.code.gson:gson:${Versions.googleGson}"

    //Junit Jupiter
    const val junit_jupiter_api =
        "org.junit.jupiter:junit-jupiter-api:${Versions.junit_jupiter_version}"
    const val junit_jupiter_engine =
        "org.junit.jupiter:junit-jupiter-engine:${Versions.junit_jupiter_version}"
    const val junit_jupiter_params =
        "org.junit.jupiter:junit-jupiter-params:${Versions.junit_jupiter_version}"

    // Retrofit

    const val junit_retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    const val junit_retrofit_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"








/*

    implementation("")


    androidTestImplementation("")

    */


    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coreKtx}" }

    //implementation
    val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.composeActivity}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val composeGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val composePreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }

    //androidTestImplementation
    val composeUiTestJunit4 by lazy { "androidx.compose.ui:ui-test-junit4" }

    //debugImplementation
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling" }
    val composeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest" }


    //testImplementation
    val junit4 by lazy { "junit:junit:${Versions.junit4}" }


    //androidTestImplementation
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
    val junitExt by lazy { "androidx.test.ext:junit:${Versions.junitExt}" }
}


object Modules {
    const val nativemobilebitsapp1utilities = ":nativemobilebitsapp1utilities"
}