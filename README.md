# Password Validation

## Description
It's a password validation side project. You can test API on Swagger UI page. After validated you will get a `PasswordResult` class which contains `isPassed` and `failedReasons` fields. 

You can find unit test case and integration test case in test package. and view testing coverage statistic by Jacoco.

## Command Line

### Build Docker Image

```shell
./mvnw package && docker build -t st890670/password-validation .
```

### Generate jacoco report

1. execute below command

```shell
./mvnw clean && ./mvnw test && ./mvnw jacoco:report
```

2. look for report at `./target/site/index.html`
