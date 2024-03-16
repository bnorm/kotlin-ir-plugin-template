buildscript {
  extra["kotlin_plugin_id"] = "com.bnorm.template.kotlin-ir-plugin"
}

plugins {
  kotlin("jvm") version "1.9.22" apply false
  id("org.jetbrains.dokka") version "1.9.10" apply false
  id("com.gradle.plugin-publish") version "1.2.1" apply false
  id("com.github.gmazzo.buildconfig") version "5.3.5" apply false
}

allprojects {
  group = "com.bnorm.template"
  version = "0.1.0-SNAPSHOT"
}

subprojects {
  repositories {
    mavenCentral()
  }
}
