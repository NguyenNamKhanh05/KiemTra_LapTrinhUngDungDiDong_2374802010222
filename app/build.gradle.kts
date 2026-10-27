plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.kiemtra_2374802010222"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.kiemtra_2374802010222"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
}
