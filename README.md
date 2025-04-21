# CRUD em Java com JDBC

Este projeto é um sistema simples de CRUD (Create, Read, Update, Delete) desenvolvido em Java, utilizando JDBC para conexão com banco de dados MySQL.

## Objetivo

O projeto tem como objetivo:

- Praticar os conceitos fundamentais da linguagem Java
- Aplicar o uso de JDBC para interagir com bancos de dados relacionais
- Implementar um CRUD completo em modo console
- Fortalecer o conhecimento sobre a estrutura de projetos Java e orientação a objetos

## Estrutura do Projeto

A estrutura de diretórios e arquivos do projeto é organizada da seguinte forma:

## Estrutura do Projeto

A estrutura de diretórios do projeto é a seguinte:

```
src/
├── br.com.produtos.aplicacao
│   └── Main.java
├── br.com.produtos.factory
│   └── ConnectionFactory.java
├── br.com.produtos.model
│   └── Produto.java
└── br.com.produtos.produto.dao
    └── ProdutoDAO.java
```


## Banco de Dados

O banco utilizado é o MySQL. Abaixo está o script SQL para criação da tabela `contatos`:

```sql
CREATE DATABASE cadastroprodutos;
USE cadastroprodutos;

CREATE TABLE contatos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100),
  email VARCHAR(100),
  telefone VARCHAR(20)
);
```
## Tecnologias Utilizadas
- Java 17 ou superior

- JDBC (Java Database Connectivity)

- MySQL

- Eclipse IDE (ou qualquer IDE compatível com Java)

## Como Executar
- Clone este repositório:

```bash
git clone https://github.com/c0mcod/crud_java.git
```
- Importe o projeto em sua IDE de preferência.

- Baixe o driver JDBC do MySQL (caso ainda não tenha) e adicione ao build path do projeto:

[Download do driver JDBC](https://dev.mysql.com/downloads/connector/j/)

- Verifique e ajuste os dados de conexão na classe Conexao.java:

```java
private static final String URL = "jdbc:mysql://localhost:3306/cadastroprodutos";
private static final String USUARIO = "seu_usuario";
private static final String SENHA = "sua_senha";
```
- altere o nome do BD na URL para o nome que você colocou quando criou o banco
- Execute a classe Main.java.
## Funcionalidades
- Inserir novo contato

- Listar todos os contatos

- Atualizar um contato existente

- Remover um contato

## Contribuição
Contribuições são bem-vindas. Sinta-se à vontade para abrir issues ou enviar pull requests com sugestões e melhorias.

| **_Desenvolvido por [c0mcod](https://github.com/c0mcod)_**