plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.testproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.testproject"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation (libs.androidx.room.runtime.v243)
    implementation (libs.androidx.room.ktx.v243)
    kapt(libs.androidx.room.compiler.v243)

    testImplementation (libs.androidx.room.testing)
    androidTestImplementation (libs.androidx.room.testing)
    testImplementation (libs.androidx.core.testing.v210)
    androidTestImplementation (libs.androidx.core.testing.v210)

    testImplementation (libs.kotlinx.coroutines.test.v164)
    androidTestImplementation (libs.kotlinx.coroutines.test.v164)
    implementation (libs.kotlinx.coroutines.core.v164)
    implementation (libs.kotlinx.coroutines.android.v164)
    androidTestImplementation (libs.turbine)

    implementation("com.google.code.gson:gson:2.10.1")

    androidTestImplementation("androidx.test:core-ktx:1.5.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.4-rc01")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.4-rc01")
    androidTestImplementation("androidx.test:runner:1.5.0-rc01")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.1")
}