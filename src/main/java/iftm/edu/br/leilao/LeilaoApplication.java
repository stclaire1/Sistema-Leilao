package iftm.edu.br.leilao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import iftm.edu.br.leilao.model.ItemDeLeilao;
import iftm.edu.br.leilao.model.Lance;
import iftm.edu.br.leilao.model.Participante;
import iftm.edu.br.leilao.repository.ItemDeLeilaoRepository;
import iftm.edu.br.leilao.repository.LanceRepository;
import iftm.edu.br.leilao.repository.ParticipanteRepository;

@SpringBootApplication
public class LeilaoApplication implements CommandLineRunner {

	@Autowired
	private ItemDeLeilaoRepository itemDeLeilaoRepository;

	@Autowired
	private LanceRepository lanceRepository;

	@Autowired
	private ParticipanteRepository participanteRepository;

	public static void main(String[] args) {
		SpringApplication.run(LeilaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ItemDeLeilao xBoxOne = new ItemDeLeilao("xBox One", 800.0, true);
		Participante ana = new Participante("Ana Clara", "12345678910");
		Lance lance1 = new Lance(800.0, ana);

		xBoxOne.getLancesRecebidos().add(lance1);
		participanteRepository.save(ana);
		lanceRepository.save(lance1);
		itemDeLeilaoRepository.save(xBoxOne);

		System.out.println(lance1);
	}
}
