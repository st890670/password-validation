# Password Validation

## Description
It's a password validation side project. You can test API on Swagger UI page. After validated you will get a `PasswordResult` class which contains `passed` and `failedReasons` fields. 

You can find unit test case and integration test case in test package. and view testing coverage statistic by Jacoco.

---

## Demo

- [Swagger UI](https://jasonjiang.info/password-validation/swagger-ui/#/)
- [Jacoco Report](http://jasonjiang.info/password-validation/jacoco/index.html)

---

## Command Line

### Generate jacoco report

1. execute below command

```shell
./mvnw test && ./mvnw jacoco:report && ./mvnw process-resources 
```

2. look for report at `/target/site/index.html`

### Build Docker Image

```shell
./mvnw package && docker build -t password-validation .
```

### Run Docker Container

```shell
docker run -p 8888:8888 password-validation
```
