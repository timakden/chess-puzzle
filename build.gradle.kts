import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    id("com.github.ben-manes.versions") version "0.28.0"
    kotlin("jvm") version "1.3.71"
}

group = "ru.timakden"
version = "1.0"

repositories {
    jcenter()
    mavenCentral()
}

val kotlinVersion = "1.3.71"

dependencies {
    implementation(kotlin("stdlib-jdk8", kotlinVersion))
    implementation("ch.qos.logback:logback-classic:1.2.3")

    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }

    withType<Test> {
        useJUnitPlatform()
    }
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
