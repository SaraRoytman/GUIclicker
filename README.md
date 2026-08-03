# GUIclicker

A Java Spring Boot application that exposes a simple web-based GUI and API for simulating clicks. The app runs locally and serves an HTTP endpoint that increments a counter each time it's called.

## Features

- Spring Boot web application
- HTTP API endpoint: `GET /api/click` — increments and returns a counter
- Uses Java 21 and Maven

## Requirements

- Java 21 (configured in the project's Maven compiler properties)
- Maven 3.6+

## Build

From the repository root:

```bash
mvn package
```

Or run directly with the Spring Boot Maven plugin:

```bash
mvn spring-boot:run
```

## Run

If you built the JAR, run:

```bash
java -jar target/*.jar
```

The application listens on localhost (default port 8080).

## API

- GET /api/click
  - Description: increments an internal counter and returns the new value.
  - Example:

```bash
curl http://localhost:8080/api/click
# -> 1
curl http://localhost:8080/api/click
# -> 2
```

## Project structure

- pom.xml — Maven project file (Spring Boot parent, Java 21)
- src/ — Java source files
  - src/com/example/clicker/ClickerApp.java — main application and REST controller

## Notes

- The project currently uses the artifact coordinates org.example:untitled2 in pom.xml; you may wish to update groupId/artifactId/version to match your project naming.
- This README was added automatically. Update it with screenshots, usage details, or contributor/license information as needed.

## License

No license specified. Add a LICENSE file if you want to make this code reusable.
