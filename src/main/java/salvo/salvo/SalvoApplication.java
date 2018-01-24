package salvo.salvo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import  java.util.*;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository) {
		return (args) -> {
			// save a couple of customers
			playerRepository.save(new Player("ArthurFrancois", "arthur.francois@gmail.com"));
			playerRepository.save(new Player("Helo", "sdfibvrg@hotmail.com"));
			playerRepository.save(new Player("KimBauer", "KimBauer@hotmail.com"));
			playerRepository.save(new Player("DavidPalmer", "DavidPalmer@hotmail.com"));
			playerRepository.save(new Player("Michelle", "Dessler"));

			Game game1 = new Game();
			game1.startGame();
			game1.updateGameCurrentState();
			gameRepository.save(game1);

			Game game2 = new Game();
			game2.startGame();
			game2.shiftGame(3600);
			game2.updateGameCurrentState();
			gameRepository.save(game2);

			Game game3 = new Game();
			game3.updateGameCurrentState();
			gameRepository.save(game3);

		};
	}
}
