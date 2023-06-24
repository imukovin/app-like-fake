plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            val mokoResourcesVersion = extra["moko.resources.version"] as String

            dependencies {
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                api("dev.icerock.moko:resources:${mokoResourcesVersion}")
                api("dev.icerock.moko:resources-compose:${mokoResourcesVersion}")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.imukstudio.applikefake.string_resources"
}

android {
    namespace = "com.imukstudio.applikefake.string_resources"

    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}

tasks.matching { it.name == "iosSimulatorArm64ProcessResources" }.configureEach {
    dependsOn(tasks.matching { it.name == "generateMRiosSimulatorArm64Main" })
}
tasks.matching { it.name == "metadataIosMainProcessResources" }.configureEach {
    dependsOn(tasks.matching { it.name == "generateMRcommonMain" })
}
tasks.matching { it.name == "metadataCommonMainProcessResources" }.configureEach {
    dependsOn(tasks.matching { it.name == "generateMRcommonMain" })
}
tasks.matching { it.name == "iosX64ProcessResources" }.configureEach {
    dependsOn(tasks.matching { it.name == "generateMRiosX64Main" })
}
tasks.matching { it.name == "iosArm64ProcessResources" }.configureEach {
    dependsOn(tasks.matching { it.name == "generateMRiosArm64Main" })
}
