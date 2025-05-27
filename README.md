
# 📞 projetoContatosApi

Uma API REST desenvolvida em **Spring Boot** para gerenciamento de contatos, utilizando **Spring Data JPA**, **PostgreSQL**, **Swagger** para documentação e **Docker** para ambiente de banco de dados.

## 🚀 Tecnologias Utilizadas

- ✅ Spring Boot DevTools  
- ✅ Spring Boot Web  
- ✅ Spring Data JPA  
- ✅ PostgreSQL JDBC Driver  
- ✅ Swagger (springdoc-openapi)  

## 📦 Estrutura do Projeto

```
projetoContatosApi
├── src
│   ├── main
│   │   ├── java
│   │   │   └── br.com.projetocontatos
│   │   │       ├── controllers
│   │   │       │   └── ContatosController.java
│   │   │       ├── entities
│   │   │       │   └── Contato.java
│   │   │       ├── repositories
│   │   │       │   └── ContatoRepository.java
│   │   │       └── ProjetoContatosApiApplication.java
│   │   └── resources
│   │       └── application.properties
├── docker-compose.yml
├── pom.xml
└── README.md
```

## 🗄️ Banco de Dados - PostgreSQL com Docker


## 🧱 Entidade `Contato`

```java
package br.com.projetocontatos.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContato;

    private String nome;
    private String email;
    private String telefone;
}
```

## 📂 Repositório

```java
package br.com.projetocontatos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.projetocontatos.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
```

## 🌐 Controlador `ContatosController`

```java
package br.com.projetocontatos.controllers;

import br.com.projetocontatos.entities.Contato;
import br.com.projetocontatos.repositories.ContatoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatosController {

    private final ContatoRepository repository;

    public ContatosController(ContatoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Contato createContato(@RequestBody Contato contato) {
        return repository.save(contato);
    }

    @PutMapping
    public Contato updateContato(@RequestBody Contato contato) {
        return repository.save(contato);
    }

    @DeleteMapping("/{idContato}")
    public void deleteContato(@PathVariable Long idContato) {
        repository.deleteById(idContato);
    }

    @GetMapping
    public List<Contato> getAllContatos() {
        return repository.findAll();
    }

    @GetMapping("/{idContato}")
    public Contato getContatoById(@PathVariable Long idContato) {
        return repository.findById(idContato).orElse(null);
    }
}
```

## 📝 Endpoints Disponíveis

| Método | Endpoint                        | Descrição                           |
| ------ | ------------------------------- | ----------------------------------- |
| POST   | `/api/contatos`                 | Cadastrar novo contato              |
| PUT    | `/api/contatos`                 | Atualizar contato                   |
| DELETE | `/api/contatos/{idContato}`     | Deletar contato por ID              |
| GET    | `/api/contatos`                 | Listar todos os contatos            |
| GET    | `/api/contatos/{idContato}`     | Consultar contato específico por ID |

## 🖥️ Documentação com Swagger

- Acesse via:  
  ➡️ [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  

## ✅ Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/projetoContatosApi.git
   ```

2. Suba o banco de dados com Docker:
   ```bash
   docker-compose up -d
   ```

3. Execute a aplicação com o Spring Boot (`mvn spring-boot:run` ou pelo IDE).

4. Acesse:  
   ➡️ [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html) 
