package br.senac.tads.dsw.musicas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.tads.dsw.musicas.model.Musica;
import br.senac.tads.dsw.musicas.model.MusicaDto;
import br.senac.tads.dsw.musicas.model.MusicaRepository;

import org.springframework.transaction.annotation.Transactional;


@Service
public class MusicaService {
    
    @Autowired
    private MusicaRepository repository;

    private MusicaDto buildDto(Musica entity) {
        MusicaDto dto = new MusicaDto(entity.getId(), entity.getTitulo(),
        entity.getArtista(), entity.getAnoLancamento());
        return dto;
    }

    private Musica buildEntity(MusicaDto dto) {
        Musica entity = new Musica();
        entity.setId(dto.id());
        entity.setTitulo(dto.titulo());
        entity.setArtista(dto.artista());
        entity.setAnoLancamento(dto.anoLancamento());
        return entity;
    }

    @Transactional(readOnly = true)
    public List<MusicaDto> findall(int pagina, int quantidade, String textoBusca) {
        List<Musica> entities;
        if (textoBusca != null && textoBusca.length() > 0) {
            entities = repository.findByTituloContainingIgnoreCase(textoBusca);
        } else {
            entities = repository.findAll();
        }
        List<MusicaDto> resultado = new ArrayList<>();
        for (Musica entity: entities) {
            MusicaDto dto = buildDto(entity);
            resultado.add(dto);
        }
        return resultado;
    }

    @Transactional
    public void addNew(MusicaDto dados) {
        Musica entity = buildEntity(dados);
        repository.save(entity);
    }
}
