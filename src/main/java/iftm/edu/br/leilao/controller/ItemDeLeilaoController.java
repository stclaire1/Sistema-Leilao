package iftm.edu.br.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.leilao.model.ItemDeLeilao;
import iftm.edu.br.leilao.model.Lance;
import iftm.edu.br.leilao.service.ItemDeLeilaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/itemdeleilao")
public class ItemDeLeilaoController {
    // {DELETE [/itemdeleilao/{id}]}: delete(Integer)
    // {GET [/itemdeleilao/{id}]}: item(Integer)
    // {PUT [/itemdeleilao/{id}]}: atualiza(Integer,ItemDeLeilao)
    // {POST [/itemdeleilao]}: novo(ItemDeLeilao)
    // {GET [/itemdeleilao]}: itens()

    @Autowired
    private ItemDeLeilaoService service;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public ItemDeLeilao item(@PathVariable Long id) {
        return service.busca(id);
    }
    
    @PutMapping("/{id}")
    public ItemDeLeilao atualiza(@PathVariable Long id, @RequestBody ItemDeLeilao item) {
        return  service.atualiza(id, item);
    }

    @PostMapping
    public ItemDeLeilao novo(@RequestBody ItemDeLeilao item) {
        return service.salva(item);
    }

    @GetMapping
    public List<ItemDeLeilao> itens() {
        return service.itens();
    }

    @PostMapping("/{id}")
    public ItemDeLeilao registraLance(@RequestBody Lance lance, @PathVariable Long id) {
        return service.registraLance(lance, id);
    }    
    
    @PatchMapping("/{id}")
    public ItemDeLeilao finalizaLeilao(@PathVariable Long id) {
        return service.finalizaLeilao(id);
    }
}
