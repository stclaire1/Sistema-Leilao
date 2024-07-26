package iftm.edu.br.leilao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iftm.edu.br.leilao.model.Lance;
import iftm.edu.br.leilao.repository.LanceRepository;

@Service
public class LanceService {

    @Autowired
    private LanceRepository repository;

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Lance busca(Long id) {
        return repository.findById(id).get();
    }

    public Lance atualiza(Long id, Lance lance) {
        lance.setId(id);
        return repository.save(lance);
    }

    public List<Lance> lances() {
        List<Lance> listaLances = new ArrayList<Lance>();
        repository.findAll().forEach(p -> listaLances.add(p));
        return listaLances;
    }

    public Lance salva(Lance lance) {
        return repository.save(lance);
    }
}
