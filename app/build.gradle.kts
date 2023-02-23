plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
}

android {
  namespace = "me.varoa.nikkerv"
  compileSdk = 33

  defaultConfig {
    applicationId = "me.varoa.nikkerv"
    minSdk = 24
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles(
        getDefaultProguardFile("proguard-android.txt"),
        "proguard-rules.pro"
      )
    }
  }

  compileOptions {
    sourceCompatibility(JavaVersion.VERSION_11)
    targetCompatibility(JavaVersion.VERSION_11)
  }
  kotlinOptions {
    jvmTarget = "11"
    freeCompilerArgs = freeCompilerArgs + listOf(
      "-Xopt-in=kotlin.ExperimentalStdlibApi",
      "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
      "-Xopt-in=kotlin.RequiresOptIn"
    )
  }

  buildFeatures {
    viewBinding = true
  }
}

dependencies {
  // android
  implementation("androidx.core:core-ktx:1.9.0")
  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("com.google.android.material:material:1.7.0")
  implementation("androidx.constraintlayout:constraintlayout:2.1.4")

  // other
  implementation("io.coil-kt:coil:2.2.0")
  implementation("com.squareup.logcat:logcat:0.1")

  // testing
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}