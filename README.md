# Erudio

**Descrição:**  
O projeto **Erudio** é uma API RESTful desenvolvida em Java utilizando Spring Boot. Ele segue os princípios do REST para fornecer uma interface eficiente, escalável e padronizada para interações cliente-servidor que a principio se molda atraves da necessidade sobre o estudos de upload de arquivos.

## 📦 Funcionalidades do Projeto

- **API RESTful**: Exposição de endpoints para gerenciar recursos do sistema.
- **HATEOAS**: Implementação de links de navegação para enriquecer as respostas das APIs.
- **Autenticação JWT**: Segurança robusta para proteger os endpoints.
- **Documentação OpenAPI**: Geração automática da documentação dos endpoints usando SpringDoc.
- **Banco de Dados Relacional**: Gerenciamento de dados com Spring Data JPA e suporte ao MySQL.
- **Conversão de Objetos**: Uso do Dozer Mapper para facilitar o mapeamento entre entidades e DTOs.
- **Testes Automatizados**: Configurado com Mockito e Spring Boot Starter Test.

---

## 🔧 Dependências Principais

### Backend
- **Spring Boot Starter Web**: Criação de APIs RESTful.
- **Spring Boot Starter Data JPA**: Interação com bancos de dados relacionais.
- **Spring Boot Starter Security**: Implementação de segurança com autenticação e autorização (JWT).
- **Spring HATEOAS**: Suporte a Hypermedia nos endpoints.
- **SpringDoc OpenAPI**: Geração de documentação interativa (Swagger UI).

### Banco de Dados
- **MySQL**: Conector JDBC para comunicação com o banco de dados MySQL.

### Utilitários
- **Jackson**: Suporte a JSON, XML e YAML para serialização/deserialização.
- **Dozer**: Mapeamento de objetos (Entidades para DTOs e vice-versa).
- **Lombok**: Redução de código boilerplate (como getters e setters).

### Testes
- **Mockito**: Mocking para testes unitários.
- **Spring Boot Starter Test**: Testes de integração e unitários.

---

## ⚙️ Configuração e Execução

### Pré-requisitos
- Java 22 ou superior.
- Maven 3.8+.
- Banco de dados MySQL configurado.

### Passos
1. Clone este repositório:
   ```bash
   git clone (https://github.com/matheusbsi1992/Estudos-RestFul-Erudio).git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd erudio
   ```
3. Configure as credenciais do banco de dados no arquivo `application.properties`.
4. Compile e execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
5. Acesse a API em: `http://localhost:9293`.

---

### Swagger
A documentação dos endpoints pode ser acessada em:
```
http://localhost:8080/swagger-ui.html
```

---

## 🌟 Tecnologias Utilizadas

- **Java 22**
- **Spring Boot 3.2.8**
- **Maven**
- **MySQL**


