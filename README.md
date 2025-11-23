#  First Spring App

Projeto de estudo utilizando Spring Framework.

## Escopo geral

Uma API REST para executar CRUD de usuários e Tarefas.

## Tecnologias

[![My Skills](https://skillicons.dev/icons?i=java,spring,maven,git)](https://skillicons.dev)

![](https://img.shields.io/badge/Lombok-Lib-blue)
![](https://img.shields.io/badge/Hibernate-Lib-blue)
![](https://img.shields.io/badge/H2_Database-Lib-blue)
![](https://img.shields.io/badge/Bcrypt-Lib-blue)

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


### GET

`/users` - Listar todos os usuários.

`users/{id}` - Buscar usuário específico.

---

### POST
  
`/users/create` - Criar novo usuário.

```
{
  "name": "Filipe Martins",
  "email": "felps@gmail.com"
}
```

`/users/createAll` - Criar vários usuários.

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
### DELETE

`/users/delete/{id}` - Deletar usuário.

---
