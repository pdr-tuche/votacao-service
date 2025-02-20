# Votacao Service

Este é o serviço de votação construído utilizando **Spring Boot**. O objetivo deste projeto é fornecer um sistema de votação com suporte para gerenciamento via endpoints REST, e com documentação acessível via Swagger.

## Requisitos

- **Java 21**: Certifique-se de que o Java 21 está instalado no seu sistema.
- **Maven**: Para gerenciar dependências e executar o projeto.
- **Docker e Docker Compose**: São necessários para executar containers relacionados (como banco de dados, ou outros serviços necessários para o ambiente de execução).

## Como executar o projeto

Siga estas etapas para rodar o projeto localmente:

### 1. Subir o ambiente com Docker Compose

Antes de iniciar a aplicação, é necessário garantir que os serviços dependentes do projeto estejam rodando. Execute o seguinte comando na raiz do projeto para subir os serviços usando o **Docker Compose**:

```bash
docker-compose up -d
```

Isso irá iniciar todos os containers necessários para o ambiente (como banco de dados, etc.). Certifique-se de que o Docker esteja instalado e em execução.

### 2. Executar a aplicação

Após garantir que os serviços estão funcionando corretamente, você pode iniciar a aplicação com:

```bash
mvn spring-boot:run
```

A aplicação estará disponível na seguinte URL:

- **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

Essa interface Swagger permite explorar e testar os endpoints REST do serviço.

### 3. Rodando Testes

Você pode executar os testes automatizados do projeto com o seguinte comando:

```bash
mvn test
```

Esse comando irá rodar todos os testes unitários e de integração disponíveis.

### 4. Gerar Coverage com Jacoco

Para gerar o relatório de cobertura de testes utilizando Jacoco, rode o seguinte comando:

```bash
mvn clean verify
```
ou
```bash
mvn jacoco:report
```

Após a execução, o relatório de coverage será gerado no diretório: `target/site/jacoco/index.html
`

###### isso foi oq deu pra fazer em dois dias =)

###### continuarei na branch development