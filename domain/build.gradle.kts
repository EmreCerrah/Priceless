plugins {
    id("java")
}

group = "com.emre"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

/*
 * ENGEL MEKANİZMASI:
 * testImplementation ve testRuntimeOnly dışındaki tüm dependency eklemeleri build’i fail edecektir.
 */
gradle.projectsEvaluated {
    val allowed = setOf("testImplementation", "testRuntimeOnly")

    configurations.forEach { cfg ->
        if (cfg.name !in allowed && cfg.dependencies.isNotEmpty()) {
            throw GradleException(
                "❌ Sadece testImplementation ve testRuntimeOnly kullanabilirsiniz! " +
                        "Hatalı configuration: ${cfg.name}, Eklenenler: ${cfg.dependencies}"
            )
        }
    }
}
