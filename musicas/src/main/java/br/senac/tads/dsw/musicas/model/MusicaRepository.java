package br.senac.tads.dsw.musicas.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer> {

    List<Musica> findByTituloContainingIgnoreCase(String textoBusca);

    List<Musica> findAll();
}