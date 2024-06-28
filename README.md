<h1 align="center" style="font-weight: bold;">Agrix</h1>

<p align="center">
    <b>O Agrix é uma API RESTful sobre plantações e gerenciamento agrícola! 🌾⚽️</b>
</p>
<p align="center">
    Nesse projeto, fui responsável por construir um back-end utilizando Spring Boot e JPA para modelagem de dados. O desenvolvimento respeitou regras de negócio providas no projeto e a API RESTful é capaz de ser consumida por um front-end que pode ser desenvolvido separadamente.
</p>


<h2 id="technologies">💻 Principais tecnologias</h2>

- Spring Boot
- JPA (Java Persistence API)
- Hibernate
- Spring Security
- JWT (JSON Web Token)
- Mysql
- Maven
- Docker
- Docker-Compose

 <b> Para desenvolver os testes: </b>
 
- JUnit
- Mockito

<details>
  <summary>🗄️ Descrição do banco de dados</summary><br>


  <img src="./images/agrix-tabelas-fase-c.png" alt="Modelo database" width="600"/>

  Nesse modelo, temos as seguintes tabelas:
- `farm`: representa uma fazenda
- `crop`: representa uma plantação, e está em relacionamento `n:1` ("muitos para um") com a tabela `farm`
- `fertilizer`: esta nova tabela representa um fertilizante, e está em um relacionamento `n:n` ("muitos para muitos") com a tabela `crop`. Esse relacionamento é realizado através da tabela `crop_fertilizer`.
</details>

<h2 id="routes">📍 API Endpoints</h2>

Aqui estão os principais endpoints da sua API, descrevendo o que cada um faz e os detalhes relevantes.

| Rota                      | Descrição                                           |
|---------------------------|-----------------------------------------------------|
| `GET /crops`              | Retorna todas as plantações cadastradas.             |
| `GET /crops/{id}`         | Retorna uma plantação específica pelo ID.           |
| `GET /crops/search`       | Busca plantações por intervalo de datas.            |
| `GET /crops/{cropId}/fertilizers` | Retorna todos os fertilizantes associados a uma plantação pelo ID da plantação. |
| `POST /crops/{cropId}/fertilizers/{fertilizerId}` | Associa um fertilizante a uma plantação específica. |
| `GET /farms`              | Retorna todas as fazendas cadastradas.              |
| `GET /farms/{id}`         | Retorna uma fazenda específica pelo ID.             |
| `POST /auth/login`         | Realiza o login de um usuário e retorna um token JWT.|
| `POST /persons`           | Cria uma nova pessoa no sistema.                    |


<details>
  <summary>🗄️ 🚀 Getting started</summary><br>
<h3>Cloning</h3>

Após usar o comando acessar a pasta do projeto para fazer os próximos passos.

```bash
git clone your-project-url-in-github
```

- Utilizando o comando para executar os containers docker através do docker compose

```bash
docker-compose -up
```
  
- Para verificar se o back-end está on, acesse http://localhost:8080/actuator/health.
</details>


