# Cardápio API

* API REST para gerenciamento de cardápio de restaurante, permitindo o controle de categorias, produtos e acesso de usuários.
* Desenvolvida utilizando Spring Boot 3 e empacotada no formato JAR.
* Gerenciamento de dependências feito com Maven.
* Autenticação e autorização implementadas com Spring Security e JWT, com controle de acesso por perfil (ADMIN e CLIENTE).
* Persistência de dados implementada com Spring Data JPA/Hibernate, utilizando banco de dados relacional PostgreSQL.
* Banco de dados containerizado com Docker e Docker Compose.
* Injeção de dependências gerenciada pelo próprio Spring Framework.
* Servidor de aplicação embarcado Tomcat.
* Projeto estruturado em arquitetura de camadas, separando responsabilidades em Controller, Service e Repository, utilizando DTOs para transferência de dados.
* Documentação dos endpoints gerada automaticamente com Swagger/OpenAPI.


## Como rodar

### Pré-requisitos
- Docker instalado
- Java 21

### Passos

```bash
# Sobe o banco
docker-compose up -d

# Roda a aplicação
./mvnw spring-boot:run
```
Acesse o Swagger em: `http://localhost:8080/swagger-ui/index.html`