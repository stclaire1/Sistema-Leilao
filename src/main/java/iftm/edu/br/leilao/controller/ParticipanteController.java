package iftm.edu.br.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.leilao.model.Participante;
import iftm.edu.br.leilao.service.ParticipanteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {
    
    @Autowired
    private ParticipanteService service;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Participante participante(@PathVariable Long id) {
        return service.busca(id);
    }

    @PutMapping("/{id}")
    public Participante atualiza(@PathVariable Long id, @RequestBody Participante participante) {
        return service.atualiza(id, participante);
    }
    
    @PostMapping
    public Participante novo(@RequestBody Participante participante) {
        return service.salva(participante);
    }

    @GetMapping
    public List<Participante> participantes() {
        return service.participantes();
    }
    
    
}
