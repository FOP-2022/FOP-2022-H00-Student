import org.sourcegrade.submitter.submit

plugins {
  java
  application
  id("com.github.johnrengelman.shadow") version "7.1.0"
  id("org.sourcegrade.submitter") version "0.4.0"
}

submit {
  assignmentId = "h00" // do not change assignmentId
  studentId = null // TU-ID  z.B. "ab12cdef"
  firstName = null
  lastName = null
  // Optionally require tests for prepareSubmission task. Default is true
  requireTests = true
}

// !! Achtung !!
// Die studentId (TU-ID) ist keine Matrikelnummer
// Richtig z.B. ab12cdef
// Falsch z.B. 1234567

repositories {
  mavenCentral()
}

dependencies {
  // FOPBot available in all source sets
  implementation("org.sourcegrade:fopbot:0.1.0")
  // JUnit only available in "test" source set (./src/test)
  testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

application {
  mainClass.set("h00.Exercise")
}

tasks {
  withType<JavaCompile> {
    options.encoding = "UTF-8"
  }
  jar {
    enabled = false // only enable shadowJar
  }
  shadowJar {
    archiveFileName.set("h00-nicht-abgeben.jar")
  }
  test {
    useJUnitPlatform()
  }
}
