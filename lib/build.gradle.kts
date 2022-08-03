plugins {
    `java-platform`
    `maven-publish`
    signing
}

publishing {
    repositories {
        maven {
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2")
            credentials {
                username = System.getenv("OSSRH_USERNAME")
                password = System.getenv("OSSRH_TOKEN")
            }
        }
    }

    publications {
        create<MavenPublication>("mavenJava") {
            pom {
                from(components["javaPlatform"])
                groupId = "io.github.ferhatwi"
                artifactId = "supabase-kt-bom"
                version = "0.1.6"
                name.set("Supabase BOM")
                description.set("Supabase BOM")
                url.set("http://www.github.com/ferhatwi/supabase-kt-bom")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("ferhatwi")
                        name.set("Ferhat")
                        email.set("ferhatyigit7@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/ferhatwi/supabase-kt-bom.git")
                    developerConnection.set("scm:git:ssh://github.com/ferhatwi/ferhatwi.git")
                    url.set("http://github.com/ferhatwi/supabase-kt-bom/")
                }
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}

repositories {
    mavenCentral()
}

dependencies {
    constraints {
        api("io.github.ferhatwi:supabase-auth-kt:0.1.2")
        api("io.github.ferhatwi:supabase-storage-kt:0.1.2")
        api("io.github.ferhatwi:supabase-database-kt:0.4.0")
    }
}