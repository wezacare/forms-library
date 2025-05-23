import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.vanniktech.mavenPublish)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "library"
            binaryOption("bundleId", "com.wezacare.forms")
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.materialIconsExtended)
        }

    }

}

android {
    namespace = "com.wezacare.forms"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    ndkVersion = "21.1.6528147"
}



mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    coordinates("io.github.samoramachel", "forms.library", libs.versions.versionName.get())

    pom {
        name = "Forms Library"
        description = "A library with custom component for form creation "
        inceptionYear = "2025"
        url = "https://github.com/wezacare/forms-library"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "wezacare.org"
                name = "Samora Machel"
                url = "dev@wezacare.org"
            }
        }
        scm {
            url = "https://github.com/wezacare/forms-library"
            connection = "scm:git:git://github.com/wezacare/forms-library.git"
            developerConnection = "scm:git:ssh://git@github.com/wezacare/forms-library.git"
        }
    }

    signAllPublications()
}

dependencies {
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.runtime.android)
    debugImplementation(compose.uiTooling)
}
