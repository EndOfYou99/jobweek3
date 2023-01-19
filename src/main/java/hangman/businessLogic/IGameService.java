package hangman.businessLogic;

import java.util.UUID;

public interface IGameService {

	public void startNewGame(UUID id, String difficulty, GameBean game);

	public GameBean getGame(UUID id);

	public void makeTry(UUID id, String letter);

	public boolean checkEmpty();

	public void chooseWord(GameBean game);

	public void checkAttempt(GameBean game, String temp);

	public void setDifficulty(GameBean game, String difficulty);

	public void hide(GameBean game);

	public String Check(String word, String hiddenWord, String first, String last);

	public void updateUsedList(GameBean game, String firstLetter, String lastLetter, String letter);

	public String getRandomWord(GameBean game);
}
