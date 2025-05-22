## 🗒️ Task API

Este é um projeto que estou desenvolvendo enquanto aprendo **Java** e **Spring Boot**. A **Task API** é uma aplicação simples de gerenciamento de tarefas que permite **criar, listar, atualizar e excluir tarefas**. O objetivo principal é colocar em prática conceitos fundamentais do desenvolvimento backend com Java, como construção de APIs REST, persistência no banco de dados e boas práticas de desenvolvimento.

---

### ✨ Sobre o projeto

- ✅ Estruturação de uma API REST com Spring Boot
- ✅ Modelagem de dados usando JPA e Hibernate
- ✅ Uso de UUID como identificador único
- ✅ Implementação de operações CRUD
- ✅ Mapeamento objeto-relacional
- ✅ Controle de datas com `LocalDateTime`
- ✅ Prática de versionamento, organização e boas práticas

---

### 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- Docker (opcional)
- Maven

---

### 🔗 Endpoints

| Método | Endpoint     | Descrição             |
|--------|--------------|-----------------------|
| POST   | `/task`      | Criar uma nova tarefa |
| GET    | `/task`      | Listar todas          |
| GET    | `/task/{id}` | Buscar por ID         |
| PUT    | `/task/{id}` | Atualizar uma tarefa  |
| DELETE | `/task/{id}` | Deletar uma tarefa    |

---

