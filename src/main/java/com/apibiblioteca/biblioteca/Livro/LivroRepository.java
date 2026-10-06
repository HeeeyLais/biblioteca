package com.apibiblioteca.biblioteca.Livro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <Livro, Long> {

    List <Livro> findByTituloLivroContainingIgnoreCase(String tituloLivro);

    List <Livro> findByAutorLivroContainingIgnoreCase(String autorLivro);
    
} 