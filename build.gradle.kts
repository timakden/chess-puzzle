import org.gradle.api.file.DuplicatesStrategy.INCLUDE
import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21

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
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib"))
    implementation(libs.bundles.tinylog)

    testImplementation(libs.bundles.kotest)
}

kotlin {
    jvmToolchain(21)
}

tasks {
    compileKotlin {
        compilerOptions {
            freeCompilerArgs.add("-Xjsr305=strict")
            jvmTarget.set(JVM_21)
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
        gradleVersion = "9.0.0"
    }
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
