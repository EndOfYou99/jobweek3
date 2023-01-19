package hangman.businessLogic;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("gameService")
public class GameService implements IGameService {

	Random rand = new Random();

	@Autowired
	IGameRepository gameRepository;

	public GameService(IGameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	public void startNewGame(UUID id, String difficulty, GameBean game) {

		setDifficulty(game, difficulty);

		chooseWord(game);

		gameRepository.add(id, game);
	}

	public boolean checkEmpty() {
		boolean result = gameRepository.isEmpty();
		return result;
	}

	public GameBean getGame(UUID id) {
		GameBean game = null;
		game = gameRepository.getGameById(id);
		return game;
	}

	public void makeTry(UUID id, String letter) {
		GameBean myBean = getGame(id);
		if (letter.equals("")) {
			gameRepository.update(id, myBean);

		}

		char[] res = myBean.getHiddenWord().toLowerCase().toCharArray();
		char c = letter.charAt(0);
		for (int i = 0, l = myBean.getWord().length(); i < l; i++) {
			if (myBean.getWord().toLowerCase().charAt(i) == c) {
				res[i] = c;
			}
		}
		res[0] = Character.toUpperCase(res[0]);
		myBean.setHiddenWord(String.valueOf(res));

		gameRepository.update(id, myBean);
	}

	public void setDifficulty(GameBean game, String difficulty) {
		if (difficulty.equals("Easy")) {
			game.setDiff(0);
		}
		if (difficulty.equals("Medium")) {
			game.setDiff(13);
		}
		if (difficulty.equals("Hard")) {

			game.setDiff(25);
		}
	}

	public void chooseWord(GameBean game) {
		game.setWord(getRandomWord(game));
		String firstLetter = Character.toString(game.word.charAt(0)).toLowerCase();
		String lastLetter = Character.toString(game.word.charAt(game.word.length() - 1));
		hide(game);
		game.setHiddenWord(Check(game.getWord(), game.getHiddenWord(), firstLetter, lastLetter));
	}

	public String getRandomWord(GameBean game) {
		return game.getWordList()[rand.nextInt(12) + game.diff];
	}

	public String Check(String word, String hiddenWord, String first, String last) {

		char[] res = hiddenWord.toLowerCase().toCharArray();
		char space = '_';
		for (int i = 0, len = word.length(); i < len; i++) {
			if (word.toLowerCase().charAt(i) == space) {
				res[i] = space;
			}
		}

		char l = last.charAt(0);
		for (int i = 0, len = word.length(); i < len; i++) {
			if (word.toLowerCase().charAt(i) == l) {
				res[i] = l;
			}
		}
		char f = first.charAt(0);
		for (int i = 0, len = word.length(); i < len; i++) {
			if (word.toLowerCase().charAt(i) == f) {
				res[i] = f;
			}
		}

		res[0] = Character.toUpperCase(res[0]);
		return new String(res);
	}

	public void hide(GameBean game) {
		String hiddenWord = "";
		for (int i = 0; i < game.word.length(); i++) {
			hiddenWord += "*";
		}
		game.setHiddenWord(hiddenWord);
	}

	public void updateUsedList(GameBean game, String firstLetter, String lastLetter, String letter) {
		if (game.getUsedLetters().contains("There are no letters currently tried.") && firstLetter.equals(lastLetter)) {
			game.getUsedLetters().add(firstLetter.toLowerCase());
			game.getUsedLetters().remove(0);
		}

		if (game.getUsedLetters().contains("There are no letters currently tried.") && firstLetter != lastLetter) {
			game.getUsedLetters().add(firstLetter.toLowerCase());
			game.getUsedLetters().add(lastLetter);
			game.getUsedLetters().remove(0);
		}
		if (game.getUsedLetters().contains(letter)) {
			game.tries--;
		} else {
			game.getUsedLetters().add(letter);
		}
	}

	public void checkAttempt(GameBean game, String temp) {
		if (temp.equals(game.hiddenWord)) {
			game.tries++;
		}

		if (game.tries == game.maxTries + 1) {
			game.setResult("L");
		}
		if (game.hiddenWord.equals(game.word)) {
			game.setResult("W");
		}
	}

	@Override
	public String toString() {
		return "GameService [rand=" + rand + ", gameRepository=" + gameRepository + "]";
	}
}
