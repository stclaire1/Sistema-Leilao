package iftm.edu.br.leilao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iftm.edu.br.leilao.model.Participante;
import iftm.edu.br.leilao.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository repository;

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Participante busca(Long id) {
        return repository.findById(id).get();
    }

    public Participante atualiza(Long id, Participante participante) {
        participante.setId(id);
        return repository.save(participante);
    }

    public Participante salva(Participante participante) {
        return repository.save(participante);
    }

    public List<Participante> participantes() {
        List<Participante> listaParticipantes = new ArrayList<Participante>();
        repository.findAll().forEach(p -> listaParticipantes.add(p));
        return listaParticipantes;
    }
}
