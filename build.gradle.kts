plugins {
    kotlin("jvm") version "1.4.0"
    id("org.openjfx.javafxplugin") version "0.0.8"
    id("com.github.johnrengelman.shadow") version "6.0.0"
}

group = "dev.hikari"
version = "1.0.0"

repositories {
    mavenCentral()
}

javafx {
    version = "11.0.2"
    modules = listOf("javafx.controls", "javafx.graphics")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("no.tornado:tornadofx:1.7.20")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    manifest {
        attributes["Main-Class"] = "dev.hikari.Main"
    }
}
