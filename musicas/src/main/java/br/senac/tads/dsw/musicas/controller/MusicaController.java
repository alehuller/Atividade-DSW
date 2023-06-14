package br.senac.tads.dsw.musicas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.senac.tads.dsw.musicas.model.MusicaDto;
import br.senac.tads.dsw.musicas.service.MusicaService;

@Controller
@RequestMapping("/musica")
public class MusicaController {

    @Autowired
    private MusicaService service;

    @GetMapping
    public List<MusicaDto> findAll(
        @RequestParam(value = "pagina", defaultValue = "0") int pagina,
        @RequestParam(value = "quantidade", defaultValue = "3") int quantidade,
        @RequestParam(value = "textoBusca", required = false) String textoBusca) {
            return service.findall(pagina, quantidade, textoBusca);
    }
}
