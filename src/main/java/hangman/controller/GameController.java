package hangman.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.NestedServletException;

import hangman.businessLogic.GameBean;
import hangman.businessLogic.GameRepository;
import hangman.businessLogic.GameService;
import hangman.businessLogic.User;
import hangman.businessLogic.wordList;
import jakarta.validation.Valid;

@Controller
public class GameController {

	@Autowired
	GameRepository gameRepo;

	@Autowired
	GameService gameService;

	@GetMapping("/login")
	public String getLogin(Model model) {

		User user = new User();
		model.addAttribute("user", user);
		return "login.jsp";
	}

	// Games starting point
	@PostMapping("/loginform")
	public String Startup(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "login.jsp";
		}
		if (!user.getUsername().equals("Kaan") || !user.getPassword().equals("123456")) {
			model.addAttribute("error", "Sorry you used invalid username or password");
			return "login.jsp";
		} else {
			return "/index";
		}
	}

	@PostMapping("/index")
	public String index() {
		return "index.jsp";
	}

	@ModelAttribute("game")
	public GameBean myGame() {
		wordList wordList = new wordList();
		String[] list = wordList.getWordList();
		GameBean myGame = new GameBean(0, 0, 6, 0, 1, "", "", list, "N");
		return myGame;
	}

	// Creating a new game
	@GetMapping("/Init")
	public String Init(@ModelAttribute("game") GameBean game, @RequestParam String difficulty, Model model)
			throws Exception {

		UUID id = UUID.randomUUID();

		gameService.startNewGame(id, difficulty, game);

		model.addAttribute("myGame", gameService.getGame(id));
		model.addAttribute("id", id);
		model.addAttribute("gameService", gameService);

		return "/game/" + id;
	}

	// passing the new game to the jsp page
	@GetMapping("/game/{id}")
	public String getGameById(@PathVariable String id, Model model) {

		GameBean game = gameService.getGame(UUID.fromString(id));

		model.addAttribute("myGame", game);
		model.addAttribute("id", id);
		model.addAttribute("gameService", gameService);

		return "myGame.jsp";
	}

	// Guessing letters
	@GetMapping("/Game/{id}")
	public String Guess(@PathVariable String id, @RequestParam String letter, Model model)
			throws NestedServletException {
		UUID stringId = UUID.fromString(id);

		if (!gameRepo.contains(stringId)) {
			throw new IllegalArgumentException("Sorry, but the game you are looking for is not found.");
		}

		GameBean myGame = gameService.getGame(stringId);
		String temp = myGame.getHiddenWord();
		String firstLetter = String.valueOf(myGame.getWord().charAt(0));
		String lastLetter = String.valueOf(myGame.getWord().charAt(myGame.getWord().length() - 1));

		gameService.updateUsedList(myGame, firstLetter, lastLetter, letter);
		gameService.makeTry(stringId, letter);
		gameService.checkAttempt(myGame, temp);

		model.addAttribute("id", id);
//		model.addAttribute("gameService", gameService);
//
//		return "gameCheck";

		model.addAttribute("myGame", myGame);

		return "myGame.jsp";
	}

	// Passing the game to the jsp page after guess is done
	@GetMapping("gameCheck/{id}")
	public String gameCheck(@RequestParam String id, Model model) {

		UUID stringID = UUID.fromString(id);
		GameBean myGame = gameService.getGame(stringID);

		model.addAttribute("myGame", myGame);

		return "myGame.jsp";
	}
}
