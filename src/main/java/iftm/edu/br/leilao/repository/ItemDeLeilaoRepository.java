package iftm.edu.br.leilao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iftm.edu.br.leilao.model.ItemDeLeilao;

@Repository
public interface ItemDeLeilaoRepository extends CrudRepository<ItemDeLeilao, Long>{
    
}
