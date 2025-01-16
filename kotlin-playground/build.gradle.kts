plugins {
    kotlin("jvm") version "1.9.22"
    id("org.jlleitschuh.gradle.ktlint") version "12.0.3"
}

group = "org.gonza"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // test dependencies
    testImplementation("io.mockk:mockk:1.13.9")
    testImplementation("io.kotest:kotest-runner-junit5:5.8.0")
    testImplementation("io.kotest:kotest-assertions-core:5.8.0")
    testImplementation("io.kotest:kotest-framework-engine:5.8.0")
    testImplementation("com.appmattus.fixture:fixture-kotest:1.2.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "21"
    }
}
