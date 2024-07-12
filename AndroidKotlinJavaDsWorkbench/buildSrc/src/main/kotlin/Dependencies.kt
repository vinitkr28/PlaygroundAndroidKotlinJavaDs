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

}