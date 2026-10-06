package com.apibiblioteca.biblioteca.Livro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "Livro")
@Data
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLivro;

    @NotBlank
    @Column(length = 200)
    private String tituloLivro;

    @NotBlank
    @Column(length = 50)
    private String autorLivro;

    @Column (length = 50)
    private String editoraLivro;

    @NotNull
    private String anoPublicacaoLivro;
    
    @Column (unique = true, length = 30)
    private String isbnLivro;

}
