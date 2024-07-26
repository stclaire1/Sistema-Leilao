package iftm.edu.br.leilao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iftm.edu.br.leilao.model.Participante;

@Repository
public interface ParticipanteRepository extends CrudRepository<Participante, Long>{
    
}
