# API Rest Spring Data JPA

<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">&nbsp;
<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>&nbsp;
<img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white"/>&nbsp;
<img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white"/>&nbsp;
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>

Desenvolvimento de uma API utilizando Spring Data JPA com o objetivo de construir um sistema
de cadastros

### Pré-requisitos
- Java 1.8+
- PostgreSQL
- IDE (Eclipse, IntelliJ, Netbeans ou outro)
- Postman ou Insomnia (Opcional)

### Configurações para conexão com o Banco

Ir em src/main/resources e no arquivo application.properties, modificar de acordo com a sua configuração de usuário.

- Substituir "mjv_db" pelo sua database criada 
```
spring.datasource.url=jdbc:postgresql://localhost:5432/mjv_db
```

- Substituir "postgres" pelo nome do usuário criado por você.
```
spring.datasource.username=postgres
```

- Substituir "postgres" pela sua senha criada.
```
spring.datasource.password=postgres
```

### Endpoints
-  <h3>Curso</h3>
    - Incluir cursos (/cursos), body: JSON, Método: POST
 ```
 {
    "nome": "Python",
    "cargaHoraria": 120,
    "nivel": "AV"
}
 ```
  - Visualizar todos os cursos disponíveis (/cursos), Método: GET
  - Alterar descrição de um curso (/cursos), body:JSON, Método: PUT
```
{
    "id": 3,
    "nome": "Python com Django",
    "cargaHoraria": 250,
    "nivel": "AV"
}
```
  - Excluir cursos (/cursos/{id}), Método: DELETE
 - <h3>Cadastro</h3>
  - Adicionar usuário (/cadastros), body: JSON, Método: POST
```
{
    "nome":"Maria",
    "rg": "222222222",
    "cpf":"12345678901",
    "email":"teste@email.com",
    "telefone":"12345678"
}
```
  - Excluir usuário (/cadastros/{id}), Método: DELETE
  - Informações completas do usuário (/cadastros/{id}), Método: GET
- <h3>Alunos</h3>
 - Cadastrar aluno em um curso (alunos/{id}), body: JSON, Método: POST
 ```
{
    "nivel": "IN",
    "cursos": "Java"
} 
 ```
 - Visualizar cursos de determinado aluno (/alunos/{id}), Método: GET
   
