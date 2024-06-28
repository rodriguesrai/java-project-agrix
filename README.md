<h1 align="center" style="font-weight: bold;">Footbal Leaderboard</h1>

<p align="center">
    <b>O Agrix é uma API RESTful sobre plantações e gerenciamento agrícola! 🌾⚽️</b>
</p>
<p align="center">
    Nesse projeto, fui responsável por construir um back-end utilizando Spring Boot e JPA para modelagem de dados. O desenvolvimento respeitou regras de negócio providas no projeto e a API RESTful é capaz de ser consumida por um front-end que pode ser desenvolvido separadamente.
</p>

<details>
  <summary>🗄️ Exemplos de retorno da API</summary><br>
</details>

<h2 id="technologies">💻 Principais tecnologias</h2>

- Spring Boot

- Sequelize
- JPA (Java Persistence API)
- Hibernate
- Spring Security
- JWT (JSON Web Token)
- Maven

- Bcrypt
- JWT(JSON web Token)

 <b> Para desenvolver os testes: </b>
 
- JUnit
- Mockito

<details>
  <summary>🗄️ Descrição do banco de dados</summary><br>
  
![agrix-tabelas-fase-c](https://github.com/rodriguesrai/project-agrix/images/agrix-tableas-face-c.png)

  Nesse modelos, temos as seguintes tabelas:
- `farm`: representa uma fazenda
- `crop`: representa uma plantação, e está em relacionamento `n:1` ("muitos para um") com a tabela `farm`
- `fertilizer`: esta nova tabela representa um fertilizante, e está em um relacionamento `n:n` ("muitos para muitos") com a tabela `crop`. Esse relacionamento é realizado através da tabela `crop_fertilizer`.
</details>

<details>
  <summary>🗄️ 🚀 Getting started</summary><br>
<h3>Cloning</h3>

Após usar o comando acessar a pasta do projeto para fazer os próximos passos

```bash
git clone your-project-url-in-github
```

<h3>Instalação</h3>

- Para instalar as dependências do projeto, execute:

```bash
mvn clean install
```

- Para instalar as dependências do projeto, execute:

```bash
mvn spring-boot:run
```

- (EM DESENVOLVIMENTO)Utilizando o comando para executar os containers docker através do docker compose

```bash
npm run compose:up
```
  
- Para acessar o back-end basta acessar a url http://localhost:8080/
</details>


