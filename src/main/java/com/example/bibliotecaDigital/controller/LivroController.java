package com.example.bibliotecaDigital.controller;

import com.example.bibliotecaDigital.model.Livro;
import com.example.bibliotecaDigital.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService service;

    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody Livro livro) {
        return ResponseEntity.ok(service.save(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Livro> findById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(service.findById(uuid));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Livro> update(@PathVariable UUID uuid, @RequestBody Livro livro) {
        return ResponseEntity.ok(service.update(uuid, livro));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        service.delete(uuid);
        return ResponseEntity.noContent().build();
    }
}