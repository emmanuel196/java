# java

utilizar java8 y apache maven

para ejecutar:
ir a la raiz del proyecto y ejecutar

```
mvn clean
mvn install
mvn spring-boot:run
```

el servicio recibe dos parametros por el metodo post
ruta del servicio -> http://localhost:8080/timezones
formato de entrada -> { "hour": " ", "timezone": " " }
formato de salida -> {"response":{ "time":"21:31:45", "timezone":"utc" }}
