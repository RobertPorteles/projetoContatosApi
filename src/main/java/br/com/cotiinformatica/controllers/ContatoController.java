
package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.entities.Contato;

import br.com.cotiinformatica.repositories.ContatosRepository;

@RestController // Usar @RestController para APIs REST (em vez de @Controller)
@RequestMapping("/api/contatos") // Prefixo das rotas
public class ContatoController {

    @Autowired
    private ContatosRepository contatoRepository;

    // TODO: Criar um novo contato (POST)
    @PostMapping
    public ResponseEntity<Contato> criar(@RequestBody Contato contato) {
        Contato novo = contatoRepository.save(contato);
        return ResponseEntity.ok(novo);
    }

    // TODO: Listar todos os contatos (GET)
    @GetMapping
    public ResponseEntity<List<Contato>> listarTodos() {
        List<Contato> contatos = contatoRepository.findAll();
        return ResponseEntity.ok(contatos);
    }

    // TODO: Buscar contato por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarPorId(@PathVariable Integer id) {
        Optional<Contato> contato = contatoRepository.findById(id);
        return contato.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // TODO: Atualizar um contato (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizar(@PathVariable Integer id, @RequestBody Contato contato) {
        if (!contatoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        contato.setIdContato(id); // Garante que está atualizando o contato correto
        Contato atualizado = contatoRepository.save(contato);
        return ResponseEntity.ok(atualizado);
    }

    // TODO: Deletar um contato (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (!contatoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        contatoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
