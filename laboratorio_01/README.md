## Laboratório 1: Introdução ao Spring Boot com JPA e MySQL

**Bem-vindos ao seu primeiro laboratório prático de Spring Boot\!** 🎉

Neste laboratório, vamos construir uma aplicação simples para gerenciar uma lista de tarefas.  Aprenderemos os conceitos básicos do Spring Boot, Spring Data JPA e como integrar com um banco de dados MySQL.

**Objetivos:**

  * Criar um projeto Spring Boot.
  * Configurar o Spring Data JPA para persistência de dados.
  * Conectar a aplicação a um banco de dados MySQL.
  * Implementar operações CRUD (Criar, Ler, Atualizar, Deletar) para gerenciar tarefas.
  * Testar a aplicação.

**Pré-requisitos:**

  * Java Development Kit (JDK) instalado.
  * IDE (ex: IntelliJ IDEA, Eclipse, VS Code).
  * MySQL Server instalado e em execução.
  * Conhecimento básico de Java e conceitos de banco de dados.

**Tecnologias:**

  * Spring Boot
  * Spring Data JPA
  * Spring Web
  * MySQL
  * Maven (para gerenciamento de dependências)

**Etapas:**

1.  **Configurar o projeto:**

      * Criar um novo projeto Spring Boot usando Spring Initializr ou sua IDE.
      * Adicionar as dependências do Spring Web, Spring Data JPA e MySQL Connector.

2.  **Criar a entidade `Tarefa`:**

      * Criar uma classe `Tarefa` com atributos como `id`, `titulo`, `descricao` e `concluida`.
      * Anotar a classe com `@Entity` e os atributos com `@Id`, `@GeneratedValue`, `@Column`, etc.

3.  **Criar o repositório `TarefaRepository`:**

      * Criar uma interface `TarefaRepository` que estende `JpaRepository`.

4.  **Criar o controlador `TarefaController`:**

      * Criar uma classe `TarefaController` com métodos para lidar com as requisições HTTP (GET, POST, PUT, DELETE).
      * Injetar o `TarefaRepository` no controlador.
      * Implementar a lógica para as operações CRUD.

5.  **Configurar o banco de dados:**

      * Criar um banco de dados MySQL.
      * Configurar as propriedades de conexão com o banco de dados no arquivo `application.properties`.

6.  **Executar e testar a aplicação:**

      * Iniciar a aplicação Spring Boot.
      * Testar as operações CRUD usando um cliente REST (ex: Postman, Insomnia).

**Recursos Adicionais:**

  * Documentação do Spring Boot](https://spring.io/projects/spring-boot)
  * [Documentação do Spring Data JPA](https://www.google.com/url?sa=E&source=gmail&q=https://spring.io/projects/spring-data-jpa)
  * [Tutorial do Spring Boot com JPA e MySQL [URL inválido removido] (Exemplo de tutorial)

**Dicas:**

  * Use nomes descritivos para suas classes, métodos e variáveis.
  * Organize seu código em pacotes.
  * Escreva testes unitários para garantir que sua aplicação funcione corretamente.
  * Comente seu código para explicar a lógica e as decisões de design.

**Divirta-se construindo sua primeira aplicação Spring Boot\!** 🚀
