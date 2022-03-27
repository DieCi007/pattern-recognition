# Pattern recognition exercise

- Requirements:
    - Java 11

Start the service by 'cd' in the project root dir and launching the command:
`./gradlew bootRun`

Start the service with some dummy data (points) by passing an extra argument:
`./gradlew bootRun --args='--com.welld.patternrecognition.default-set=true'`

Test the service by 'cd' in the project root dir and launching the command:
`./gradlew test`

### Test APIs by using Postman or curl:

- GET /space
  `curl --location --request GET 'http://localhost:8080/space'`
- DELETE /space
  `curl --location --request DELETE 'http://localhost:8080/space'`
- POST /point
  `curl --location --request POST 'http://localhost:8080/point' --header 'Content-Type: application/json' --data-raw '{"x": 3.0, "y": 5.0}'`
- GET /lines/{n}
  `curl --location --request GET 'http://localhost:8080/lines/2'`
