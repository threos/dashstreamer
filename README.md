# CS418 Project 2
Author: Eray Emin Ocak

Date: 2024-04-21

## Introduction
This is a project that provides surveillance over the internet for users,
using ffmpeg to encode the stream with a DASH profile, to be served to
the client using a Kotlin/Spring Boot backend.

A single backend program manages all processes, starting an
embedded Tomcat server, hosting the player page, and encoding/
serving the live stream.

Ffmpeg commands are executed using a custom API written
specifically for this project, named ffexecutor. Ffexecutor API allows us
to run encoding tasks by providing a set of option instances. Commands
are run with a custom FallbackExecutor class, which incrementally
retries tasks with mutated settings in case of failure. FallbackExecutor is
configured with a FallbackProvider to try different camera inputs if
ffmpeg fails to start the encoding.

## Files and Modules
- `CS418 Project Report.pdf`: Project report
- `Latency Result Table.png`: Latency vs Segment Duration table
- `jar`: Pre-built jar file
- `ffexecutor`: Ffexecutor Module (Custom Ffmpeg Interface)
- `build.gradle.kts`: Gradle Build File
- `src/main/kotlin/`: Kotlin Source Files
- `src/main/resources/`: Resource Files
- `src/main/resources/templates/home.html`: Player Page
- `src/main/resources/application.properties`: Application Properties (Base context path can be configured here)

## How to Run
1. Run the project using `./gradlew bootRun`
2. Open `http://localhost:8080` in the browser
3. Click on the play button to start the stream