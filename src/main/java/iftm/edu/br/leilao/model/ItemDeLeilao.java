package iftm.edu.br.leilao.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//as notações AllArgsConstructor e @NoArgConstructor, respectivamente, geram construtores que aceitam 1) 1 argumento para cada campo da classe; 2) nenhum argumento
// @AllArgsConstructor 
// @NoArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = { "id", "lancesRecebidos","lanceVencedor"})
@EqualsAndHashCode(of = {"nome", "valorMinimo"})
@Entity
public class ItemDeLeilao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valorMinimo;
    private boolean leilaoAberto;

    //relacionamento unidirecional, um item de leilão pode ter vários lances
    @OneToMany
    private List<Lance> lancesRecebidos = new ArrayList<Lance>();

    @OneToOne
    private Lance lanceVencedor;

    public ItemDeLeilao(String nome, Double valorMinimo, Boolean leilaoAberto) {
        super();
        this.nome = nome;
        this.valorMinimo = valorMinimo;
        this.leilaoAberto = leilaoAberto;
    }
}

