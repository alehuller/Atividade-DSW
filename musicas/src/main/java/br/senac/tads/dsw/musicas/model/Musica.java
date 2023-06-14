package br.senac.tads.dsw.musicas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "musica")
public class Musica {

    @Id
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Título não deve estar em branco.")
    @Column(name = "titulo")
    private String titulo;

    @NotBlank(message = "Artista não deve estar em branco.")
    @Column(name = "artista")
    private String artista;

    @NotNull(message = "Ano de lançamento não deve estar em branco.")
    @Min(value = 1000, message = "Não pode ser um ano anterior a 1000.")
    @Max(value = 2023, message = "Não pode ser um ano posterior a 2023.")
    @Column(name = "ano_lancamento")
    private Integer anoLancamento;

    public Musica() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
