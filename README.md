# First Spring App

Projeto de estudo utilizando Spring Framework.

## Escopo geral

Uma API REST para executar CRUD de usuários.

## Tecnologias
- Java 17
- Spring Framework 3.5.7
- Lombok
- Hibernate (ORM)
- H2 Database
- Apache Maven 
- Git

## Requisitos
- Java 17+
- Git
- Apache Maven

## Como executar

   
1. `git clone https://github.com/filipemartinsdev/first-spring-app.git`
2. `cd first-spring-app`
3. `mvn spring-boot:run`
    
Servidor aberto em: http://localhost:8080/
  

## Endpoints

GET `/users`

Listar todos os usuários.

---
  
GET `users/{id}`

Buscar usuário específico.

---
  
POST `/users/create`

Criar novo usuário.

```
{
  "name": "Filipe Martins",
  "email": "felps@gmail.com"
}
```

---

POST `/users/createAll`

Criar vários usuários.

```
[
  {
    "name": "Filipe Martins",
    "email": "felps@gmail.com"
  },
  {
    "name": "Alberto",
    "email": "alberto@gmail.com"
  }
]
```

---
  
DELETE `/users/delete/{id}`

  Deletar usuário.

---
