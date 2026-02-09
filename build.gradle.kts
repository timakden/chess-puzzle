import org.gradle.api.JavaVersion.VERSION_25
import org.gradle.api.file.DuplicatesStrategy.INCLUDE
import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_25

plugins {
    idea
    alias(libs.plugins.versions)
    alias(libs.plugins.kotlin.jvm)
}

group = "ru.timakden"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.tinylog)

    testImplementation(libs.bundles.kotest)
}

kotlin {
    jvmToolchain(25)
}

java {
    toolchain {
        targetCompatibility = VERSION_25
    }
}

tasks {
    compileKotlin {
        compilerOptions {
            jvmTarget.set(JVM_25)
        }
    }
    jar {
        manifest {
            attributes("Main-Class" to "ru.timakden.chess.MainKt")
        }

        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })

        duplicatesStrategy = INCLUDE
    }
    test {
        useJUnitPlatform()
    }
    wrapper {
        gradleVersion = "9.3.1"
    }
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
