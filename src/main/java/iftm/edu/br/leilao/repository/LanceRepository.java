package iftm.edu.br.leilao.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iftm.edu.br.leilao.model.Lance;

@Repository
public interface LanceRepository extends CrudRepository<Lance, Long>{
    List<Lance> findByParticipanteId(Long id); //select * from lance l join participante p where l.id_participante = p.id_participante
    List<Lance> findByParticipanteIdAndValorGreaterThan(Long id, Double valor); //select * from lance l join participante p where id = n and valor > 100
}