# DemoRest
Package 
```
mvn package
```

Run 
```
mvn spring-boot:run
```
or
```
mvn package
java -jar  target/transaction-0.0.1-SNAPSHOT.jar
```
Test App

http://localhost:8080/transactions{?page,size,sort}

In *nix
```
$curl http://localhost:8080/transactionservice/transaction/123

$curl http://localhost:8080/transactionservice/types/car

$curl http://localhost:8080/transactionservice/sum/1

$curl -i -X PUT -H "Content-Type:application/json" -d '{ "amount":300,"type":"tech","parent_id":0 }' http://localhost:8080/transactionservice/transaction/123
```