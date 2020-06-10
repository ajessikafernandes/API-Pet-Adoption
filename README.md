# API-Pet-Adoption

API para registrar informações de PETS para adoção.


## Pré-requisitos

Java 11.

Maven.

### Montando ambiente:

Baixar o projeto usando o comando git clone.

Executando pela linha de comando na pasta da raiz do projeto, crie o jar do projeto: 
```
./mvnw clean install
```
Para executar o projeto via terminal, use o comando :
```
java -jar -Dspring.profiles.active=local target/pet-0.0.1-SNAPSHOT.jar
```

Para executar os testes unitários, use o comando: 
```
./mvnw test
```

### Acesso as collections usando o Postman:

Faça o download do arquivo na pasta resources :
```
postman_collection.json
```
Import o arquivo no postman para acessar as collections.

### Acesso a cobertura de testes do Jacoco:

Acesse o arquivo ```index.html``` do Jacoco:
```
target/site/jacoco/index.html
```
Depois execute o arquivo em um browser de sua preferência.
