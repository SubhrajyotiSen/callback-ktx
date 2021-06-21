import kotlinx.validation.ApiValidationExtension

plugins {
    id("org.jetbrains.kotlinx.binary-compatibility-validator") version "0.6.0"
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.GRADLE_PLUGIN}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:${Versions.KTLINT_PLUGIN}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

extensions.configure<ApiValidationExtension>() {
    ignoredProjects = mutableSetOf("test")
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}