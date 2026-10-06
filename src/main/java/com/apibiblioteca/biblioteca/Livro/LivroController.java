package com.apibiblioteca.biblioteca.Livro;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController (LivroService livroService){
        this.livroService = livroService;
    }

    @PostMapping 
                    //  Spring Framework usada para mapear o corpo de uma requisição HTTP diretamente para um objeto Java
    public Livro save(@RequestBody Livro livro){
        return livroService.salvar(livro);
    }

    @GetMapping
    public List <Livro> listarLivros(){
        return livroService.buscarTodos();
    }

    @GetMapping ("/{id}")
    public ResponseEntity <Livro> buscarPorId(@PathVariable Long id){
        Livro livro = livroService.buscarPorId(id);
        return ResponseEntity.ok(livro);

    }

    @PutMapping ("/{id}")
    public ResponseEntity <Livro> atualizar(
        @PathVariable Long id,
        @RequestBody Livro livro){
            livro.setIdLivro(id);
            return ResponseEntity.ok(livroService.salvar(livro));
        }

    @GetMapping ("/buscarportitulo")
    public List<Livro> buscarPorTitulo(@RequestParam String titulo){
        return livroService.buscarPorTitulo(titulo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletar(@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
