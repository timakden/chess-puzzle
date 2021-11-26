import org.gradle.api.file.DuplicatesStrategy.INCLUDE
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    id("com.github.ben-manes.versions") version "0.39.0"
    kotlin("jvm") version "1.6.0"
}

group = "ru.timakden"
version = "1.0"

repositories {
    mavenCentral()
}

val kotestVersion = "5.0.0"
val tinylogVersion = "2.3.2"

dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.tinylog:tinylog-api-kotlin:$tinylogVersion")
    implementation("org.tinylog:tinylog-impl:$tinylogVersion")

    // kotest
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-property-jvm:$kotestVersion")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }

    withType<Test> {
        useJUnitPlatform()
    }

    jar {
        manifest {
            attributes("Main-Class" to "ru.timakden.chesspuzzle.MainKt")
        }

        from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })

        duplicatesStrategy = INCLUDE
    }
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
