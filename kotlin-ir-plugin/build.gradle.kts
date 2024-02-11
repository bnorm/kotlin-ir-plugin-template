plugins {
  kotlin("jvm")
  kotlin("kapt")
  id("com.github.gmazzo.buildconfig")
}

dependencies {
  compileOnly("org.jetbrains.kotlin:kotlin-compiler-embeddable")

  kapt("com.google.auto.service:auto-service:1.1.1")
  compileOnly("com.google.auto.service:auto-service-annotations:1.1.1")

  testImplementation(kotlin("test-junit"))
  testImplementation("org.jetbrains.kotlin:kotlin-compiler-embeddable")
  testImplementation("dev.zacsweers.kctfork:core:0.4.0")
}

buildConfig {
  packageName(group.toString())
  buildConfigField("String", "KOTLIN_PLUGIN_ID", "\"${rootProject.extra["kotlin_plugin_id"]}\"")
}
