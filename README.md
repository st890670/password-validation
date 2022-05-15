# Password Validation

## Description
It's a password validation side project. You can test API on Swagger UI page. After validated you will get a `PasswordResult` class which contains `isPassed` and `failedReasons` fields. 

You can find unit test case and integration test case in test package. and view testing coverage statistic by Jacoco.

## Command Line

### Generate jacoco report

1. execute below command

```shell
./mvnw clean && ./mvnw test && ./mvnw jacoco:report && ./mvnw process-resources 
```

2. look for report at `/target/site/index.html`

### Build Docker Image

```shell
./mvnw package && docker build -t password-validation .
```

