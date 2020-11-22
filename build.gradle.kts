import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    id("com.github.ben-manes.versions") version "0.36.0"
    kotlin("jvm") version "1.4.20"
}

group = "ru.timakden"
version = "1.0"

repositories {
    jcenter()
    mavenCentral()
}

val kotestVersion = "4.3.1"
val tinylogVersion = "2.2.0"

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
    }
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
