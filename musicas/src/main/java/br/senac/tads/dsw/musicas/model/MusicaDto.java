package br.senac.tads.dsw.musicas.model;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MusicaDto (
    @Id
    Integer id,

    @NotBlank(message = "Título não deve estar em branco.")
    String titulo,

    @NotBlank(message = "Artista não deve estar em branco.")
    String artista,

    @NotNull(message = "Ano de lançamento não deve estar em branco.")
    @Min(value = 1000, message = "Não pode ser um ano anterior a 1000.")
    @Max(value = 2023, message = "Não pode ser um ano posterior a 2023.")
    Integer anoLancamento
) { 
}
