import org.jagrkt.submitter.submit

plugins {
  java
  application
  id("org.jagrkt.submitter").version("0.3.1")
}

submit {
  assignmentId = "H00" // do not change assignmentId
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
  // JUnit only available in "test" source set (./src/test)
  testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

application {
  mainClass.set("H00.Main")
}

tasks {
  test {
    useJUnitPlatform()
  }
}
