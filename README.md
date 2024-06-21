
# Content Manager - API

Content Manager - API é uma aplicação que permite o gerenciamento de imagens e páginas, desenvolvido utilizando Spring Boot 3.3.0 e Java 17.

## Índice

- [Apresentação](#apresentação)
- [Endpoints](#endpoints)
- [Instalação](#instalação)


## Apresentação

O Content Manager - API visa fornecer uma API para upload, gerenciamento e exibição de imagens, além de templates de páginas com diversos tipos de conteúdos. A aplicação é integrada com um banco de dados PostgreSQL e um cliente pgAdmin para administração do banco.

## Endpoints

### Pages

| Método | Endpoint                | Descrição                                                                                           |
|--------|-------------------------|-----------------------------------------------------------------------------------------------------|
| POST   | /pages                  | Insere um novo template de página.                                                                  |
| GET    | /pages/{namePage}       | Retorna um template de página pelo nome da página.                                                  |
| PUT    | /pages/{namePage}/edit  | Atualiza um template de página existente pelo nome da página.     

### Images

| Método | Endpoint       | Descrição                                                                                           |
|--------|----------------|-----------------------------------------------------------------------------------------------------|
| POST   | /images        | Insere novas imagens.                                                                               |
| GET    | /images/{id}   | Retorna uma imagem pelo ID.                                                                         |


## Instalação

### Pré-requisitos

- Java 17
- Docker e Docker Compose
- Maven

### Passos para clonar e rodar o projeto

1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/Content Manager - API.git
    ```

2. Navegue até o diretório do projeto:
    ```bash
    cd Content Manager - API
    ```

3. Construa e inicie os contêineres Docker (PostgreSQL e pgAdmin):
    ```bash
    docker-compose up -d
    ```

4. Instale as dependências do projeto:
    ```bash
    mvn clean install
    ```

5. Execute o projeto:
    ```bash
    mvn spring-boot:run
    ```

6. Abra o navegador e acesse o link fornecido no terminal.

