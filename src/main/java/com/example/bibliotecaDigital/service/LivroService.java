package com.example.bibliotecaDigital.service;

import com.example.bibliotecaDigital.model.Livro;
import com.example.bibliotecaDigital.repository.JpaLivroRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final JpaLivroRepository jpaLivroRepository;

    public List<Livro> findAll() {
        return jpaLivroRepository.findAll();
    }

    public Livro findById(UUID uuid) {
        return jpaLivroRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + uuid));
    }

    @Transactional
    public Livro save(Livro livro) {
        return jpaLivroRepository.save(livro);
    }

    @Transactional
    public Livro update(UUID uuid, Livro livroAtualizado) {
        Livro livroExistente = jpaLivroRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + uuid));

        livroExistente.setTitulo(livroAtualizado.getTitulo());
        livroExistente.setAutor(livroAtualizado.getAutor());
        livroExistente.setCategoria(livroAtualizado.getCategoria());

        livroExistente.setQtdPaginas(livroAtualizado.getQtdPaginas());

        return jpaLivroRepository.save(livroExistente);
    }

    @Transactional
    public void delete(UUID uuid) {
        Livro livro = jpaLivroRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + uuid));
        jpaLivroRepository.delete(livro);

    }



}