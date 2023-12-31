/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/8.0.2/userguide/building_java_projects.html
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.1-jre")

    // Vert.x
 	implementation("io.vertx:vertx-core:4.4.5")
 	implementation("io.vertx:vertx-web:4.4.5")

    // Hibernate
        implementation("org.hibernate.orm:hibernate-core:6.4.1.Final")
        // Hibernate Validator
        implementation("org.hibernate.validator:hibernate-validator:8.0.0.Final")
        implementation("org.glassfish:jakarta.el:4.0.2")
        // Agroal connection pool
        implementation("org.hibernate.orm:hibernate-agroal:6.4.1.Final")
        implementation("io.agroal:agroal-pool:2.1")
        // logging via Log4j
        implementation("org.apache.logging.log4j:log4j-core:2.20.0")
        // JPA Metamodel Generator
        annotationProcessor("org.hibernate.orm:hibernate-jpamodelgen:6.4.1.Final")
        implementation("org.hibernate:hibernate-c3p0:5.6.5.Final")

    // Aggiungi anche la dipendenza per il driver JDBC del tuo database (es. MySQL)
    implementation("mysql:mysql-connector-java:8.0.26")

implementation("javax.validation:validation-api:2.0.1.Final")


}

application {
    // Define the main class for the application.
    mainClass.set("escooter.java.App")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
