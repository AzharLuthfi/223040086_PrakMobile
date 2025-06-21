import io.github.cdimascio.dotenv.dotenv
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp") version "1.9.22-1.0.17" // Untuk Room
    id("kotlin-kapt") // Untuk Hilt
}

val dotenv = dotenv {
    directory = rootProject.projectDir.absolutePath
    ignoreIfMissing = true
}

android {
    namespace = "id.ac.unpas.storyapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "id.ac.unpas.storyapp"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    buildTypes {
        debug {
            buildConfigField("String", "API_URL", "\"${dotenv["API_URL_DEBUG"] ?: "https://api-dev.example.com/v1/"}\"")
        }
        release {
            buildConfigField("String", "API_URL", "\"${dotenv["API_URL_RELEASE"] ?: "https://api.example.com/v1/"}\"")
            // Konfigurasi release lainnya
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Jetpack Compose - untuk membuat UI
    implementation("androidx.activity:activity-compose:1.8.2")      // Activity Compose
    implementation("androidx.compose.ui:ui:1.6.0")                 // Compose UI
    implementation("androidx.compose.ui:ui-graphics:1.6.0")        // Graphics
    implementation("androidx.compose.material3:material3:1.2.0")   // Material Design 3

// Navigation - untuk perpindahan antar halaman
    implementation("androidx.navigation:navigation-compose:2.7.6")

// ViewModel - untuk state management
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

// Room - untuk database lokal
    implementation("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

// Retrofit - untuk network calls
    implementation("com.squareup.retrofit2:retrofit:2.9.0")        // Library utama
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")  // Konverter JSON
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0") // Logging

// DataStore - untuk penyimpanan kecil seperti token
    implementation("androidx.datastore:datastore-preferences:1.0.0")

// WorkManager - untuk background tasks
    implementation("androidx.work:work-runtime-ktx:2.9.0")

// Hilt - untuk dependency injection
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")


}


