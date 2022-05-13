# Password Validation

## Command Line
### Bootrun 
```shell
./mvnw spring-boot:run
```

### Build jar
```shell
./mvnw package
```

### Generate jacoco report
1. execute below command
```shell
./mvnw test && ./mvnw jacoco:report
```
2. look for report in `./target/site/index.html`
