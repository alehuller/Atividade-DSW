package br.senac.tads.dsw.musicas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.senac.tads.dsw.musicas.model.MusicaDto;
import br.senac.tads.dsw.musicas.model.MusicaRepository;
import br.senac.tads.dsw.musicas.service.MusicaService;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;


@Controller
public class MusicaTelaController {

    @Autowired
    private MusicaService service;

    @Autowired
    MusicaRepository repository;

    @GetMapping("musica-tela")
    public String minhaTela(Model model) {
        List<MusicaDto> musicas = service.findall(0, 0, null);
        model.addAttribute("musicas", musicas);
        if(musicas.isEmpty()) {
            return "view/listagemSemMusica";
        } else {
            return "view/listagemComMusica";
        }
    }

    @GetMapping("inclusao")
    public String inclusaoTela(Model model) {
        MusicaDto mudicaDto = new MusicaDto(null, null, null, null);
        model.addAttribute("musicaDto", mudicaDto);
        return "view/inclusao";
    }

    @GetMapping("listagemNovaMusica")
    public String listagemNovaMusica(Model model) {
        List<MusicaDto> musicas = service.findall(0, 0, null);
        model.addAttribute("musicas", musicas);
        return "view/listagemNovaMusica";
    }

    @PostMapping("/incluir")
    public String incluirMusica(@Validated @ModelAttribute("musicaDto") MusicaDto musicaDto,BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("erros", bindingResult.getAllErrors());
            model.addAttribute("musicaDto", musicaDto);
            return "view/inclusao";
        }

        Integer id = getNextId();

        MusicaDto dados = new MusicaDto(id, musicaDto.titulo(), musicaDto.artista(), musicaDto.anoLancamento());
        service.addNew(dados);

        return "redirect:/listagemNovaMusica";
    }

    private static Integer ultimoId = 0;

    private synchronized Integer getNextId() {
        ultimoId++;
        return ultimoId;
    }
}
