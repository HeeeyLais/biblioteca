package com.apibiblioteca.biblioteca.Livro;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deletar(Long idLivro) {
        livroRepository.deleteById(idLivro);
    }

    public List <Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    
}
