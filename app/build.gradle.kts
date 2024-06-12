plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.quiz"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.quiz"
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
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Dependências do Compose
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.ui:ui:1.2.0") // Atualizado para 1.2.0
    implementation("androidx.compose.material:material:1.2.0") // Atualizado para 1.2.0
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.0") // Atualizado para 1.2.0
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0") // Atualizado para 2.4.0
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0-alpha02") // Atualizado para 2.4.0-alpha02
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha10") // Atualizado para 2.4.0-alpha10

    // Dependências do Material 3
    implementation("com.google.android.material:material:1.6.0") // Atualizado para 1.6.0
    implementation("androidx.compose.material3:material3:1.0.0") // Mantida a mesma versão

    // Testes
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.2.0") // Atualizado para 1.2.0

    // Ferramentas de desenvolvimento
    debugImplementation("androidx.compose.ui:ui-tooling:1.2.0") // Atualizado para 1.2.0
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.2.0") // Atualizado para 1.2.0
}




