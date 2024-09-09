package iftm.edu.br.leilao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import iftm.edu.br.leilao.model.ItemDeLeilao;
import iftm.edu.br.leilao.model.Lance;
import iftm.edu.br.leilao.repository.ItemDeLeilaoRepository;

@Service
public class ItemDeLeilaoService {

    private final ItemDeLeilaoRepository repository;

    private final LanceService lanceService;

    public ItemDeLeilaoService(ItemDeLeilaoRepository repository, LanceService lanceService) {
        this.repository = repository;
        this.lanceService = lanceService;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ItemDeLeilao busca(Long id) {
        return repository.findById(id).get();
    }

    public ItemDeLeilao atualiza(Long id, ItemDeLeilao item) {
        ItemDeLeilao itemExistente = repository.findById(id).get();
		itemExistente.setNome(item.getNome());
		itemExistente.setValorMinimo(item.getValorMinimo());
		itemExistente.setLeilaoAberto(item.isLeilaoAberto());
		return repository.save(itemExistente);
    }

    public ItemDeLeilao salva(ItemDeLeilao item) {
        return repository.save(item);
    }

    public List<ItemDeLeilao> itens() {
        List<ItemDeLeilao> listaItens = new ArrayList<>();
        repository.findAll().forEach(p -> listaItens.add(null));
        return listaItens;
    }

    public ItemDeLeilao registraLance(Lance lance, Long id) {
        ItemDeLeilao item = repository.findById(id).get();
        if(item.isLeilaoAberto()) {
            Lance lancePersiste = lanceService.salva(lance);
            item.getLancesRecebidos().add(lancePersiste);
            if(item.getLanceVencedor() == null || item.getLanceVencedor().getValor() < lance.getValor()) {
                item.setLanceVencedor(lancePersiste);
            }
        }else {
            throw new UnsupportedOperationException("Leilão já finalizado");
        }
        return repository.save(item);
    }

    public ItemDeLeilao finalizaLeilao(Long id) {
        ItemDeLeilao item = repository.findById(id).get();
        item.setLeilaoAberto(false);
        return repository.save(item);
    }
}
