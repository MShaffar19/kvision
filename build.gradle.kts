plugins {
    val kotlinVersion: String by System.getProperties()
    id("kotlinx-serialization") version kotlinVersion
    kotlin("js")
    id("maven-publish")
    val dokkaVersion: String by System.getProperties()
    id("org.jetbrains.dokka") version dokkaVersion
}

repositories()

// Versions
val kotlinVersion: String by System.getProperties()
val serializationVersion: String by project
val coroutinesVersion: String by project
val snabbdomKotlinVersion: String by project
val navigoKotlinVersion: String by project
val jqueryKotlinVersion: String by project

// Custom Properties
val webDir = file("src/main/web")

kotlin {
    kotlinJsTargets()
}

dependencies {
    api(project(":kvision-modules:kvision-common-types"))
    api("org.jetbrains.kotlinx:kotlinx-serialization-json-js:$serializationVersion")
    api("com.github.snabbdom:snabbdom-kotlin:$snabbdomKotlinVersion")
    api("pl.treksoft:navigo-kotlin:$navigoKotlinVersion")
    api("pl.treksoft:jquery-kotlin:$jqueryKotlinVersion")
//    for local development
//    implementation(npm("kvision-assets", "http://localhost:8001/kvision-assets-1.0.1.tgz"))
    implementation(npm("kvision-assets", "^1.0.1"))
    implementation(npm("css-loader", "^3.5.2"))
    implementation(npm("style-loader", "^1.1.4"))
    implementation(npm("less", "^3.11.1"))
    implementation(npm("less-loader", "^5.0.0"))
    implementation(npm("imports-loader", "^0.8.0"))
    implementation(npm("uglifyjs-webpack-plugin", "^2.2.0"))
    implementation(npm("file-loader", "^6.0.0"))
    implementation(npm("url-loader", "^4.1.0"))
    implementation(npm("jquery", "^3.5.1"))
    implementation(npm("fecha", "^4.2.0"))
    implementation(npm("snabbdom", "^0.7.4"))
    implementation(npm("snabbdom-virtualize", "^0.7.0"))
    implementation(npm("jquery-resizable-dom", "^0.35.0"))
    implementation(npm("navigo", "^7.1.2"))
    testImplementation(kotlin("test-js"))
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(kotlin.sourceSets.main.get().kotlin)
}

publishing {
    publications {
        create<MavenPublication>("kotlin") {
            from(components["kotlin"])
            artifact(tasks["sourcesJar"])
            pom {
                defaultPom()
            }
        }
    }
}

setupPublication()

tasks {
    /*
    // Forcing specific npm package versions (not required at the moment but commented for future use)
    withType<org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask> {
        doLast {
            yarnLock.parentFile.resolve("package.json").apply {
                writeText(readText().replace(
                    "\"dependencies\": {},",
                    "\"dependencies\": {},\n  \"resolutions\": { \"jquery\": \"3.4.1\" },"
                ))
            }
            org.jetbrains.kotlin.gradle.targets.js.yarn.YarnWorkspaces()
                .yarnExec(project, yarnLock.parentFile, "Relaunching Yarn to fix resolutions")
        }
    }
    */
}
tasks.dokkaHtml {
    outputDirectory = "$buildDir/kdoc"
    dokkaSourceSets {
        register("kvision") {
            includes = listOf("Module.md")
            displayName = "JS"
            platform = "js"
            includeNonPublic = false
            skipDeprecated = false
            reportUndocumented = false
            this.sourceRoot {
                this.path = "src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-bootstrap/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-bootstrap-css/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-bootstrap-datetime/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-bootstrap-dialog/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-bootstrap-select/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-bootstrap-select-remote/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-bootstrap-spinner/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-bootstrap-typeahead/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-bootstrap-typeahead-remote/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-bootstrap-upload/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-chart/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-chart/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-common-remote/src/jsMain/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-common-types/src/jsMain/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-cordova/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-datacontainer/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-electron/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-event-flow/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-fontawesome/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-handlebars/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-i18n/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-maps/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-moment/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-onsenui/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-onsenui-css/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-pace/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-react/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-redux/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-richtext/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-server-ktor/src/jsMain/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-tabulator/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-tabulator-remote/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-testutils/src/main/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-toast/src/main/kotlin"
            }
        }
        register("kvision-common") {
            includes = listOf("Module.md")
            displayName = "Common"
            platform = "common"
            includeNonPublic = false
            skipDeprecated = false
            reportUndocumented = false
            this.sourceRoot {
                this.path = "kvision-modules/kvision-common-annotations/src/commonMain/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-common-remote/src/commonMain/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-common-types/src/commonMain/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-server-ktor/src/commonMain/kotlin"
            }
        }
        register("kvision-jvm") {
            includes = listOf("Module.md")
            displayName = "JVM"
            platform = "jvm"
            includeNonPublic = false
            skipDeprecated = false
            reportUndocumented = false
            this.sourceRoot {
                this.path = "kvision-modules/kvision-common-types/src/jvmMain/kotlin"
            }
            this.sourceRoot {
                this.path = "kvision-modules/kvision-server-ktor/src/jvmMain/kotlin"
            }
        }
    }
}
