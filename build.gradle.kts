import org.sourcegrade.submitter.submit

plugins {
  java
  application
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
  maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
  // FOPBot available in all source sets
  implementation("org.sourcegrade:fopbot:0.1.0-SNAPSHOT")
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
  test {
    useJUnitPlatform()
  }
}
