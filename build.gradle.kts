import org.gradle.api.file.DuplicatesStrategy.INCLUDE
import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21

val kotestVersion: String by project
val kotlinVersion: String by project
val tinylogVersion: String by project

plugins {
    idea
    id("com.github.ben-manes.versions") version "0.51.0"
    kotlin("jvm") version "1.9.23"
}

group = "ru.timakden"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib"))
    implementation("org.tinylog:tinylog-api-kotlin:$tinylogVersion")
    implementation("org.tinylog:tinylog-impl:$tinylogVersion")

    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-framework-datatest:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
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
        gradleVersion = "8.6"
    }
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
