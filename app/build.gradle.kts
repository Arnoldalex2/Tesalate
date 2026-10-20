plugins {
    id("com.android.application")
}

android {
    namespace = "com.aa.tesalate"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.aa.tesalate"
        minSdk = 34
        targetSdk = 35
        versionCode = 3
        versionName = "0.3.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
