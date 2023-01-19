package hangman.businessLogic;

import java.util.ArrayList;

public class GameBean {

	int diffLength;

	int gameNum;

	int maxTries;

	int tries;

	int diff;

	String word;

	String hiddenWord;

	String result;

	String[] wordList;

	ArrayList usedLetters;

	public GameBean(int diffLength, int gameNum, int maxTries, int tries, int diff, String word, String hiddenWord,
			String[] wordList, String result) {
		this.diffLength = diffLength;
		this.gameNum = gameNum;
		this.maxTries = maxTries;
		this.tries = tries;
		this.diff = diff;
		this.word = word;
		this.hiddenWord = hiddenWord;
		this.wordList = wordList;
		this.usedLetters = new ArrayList();
		this.result = result;
		usedLetters.add("There are no letters currently tried.");
	}

	public int getDiffLength() {
		return diffLength;
	}

	public void setDiffLength(int diffLength) {
		this.diffLength = diffLength;
	}

	public int getGameNum() {
		return gameNum;
	}

	public void setGameNum(int gameNum) {
		this.gameNum = gameNum;
	}

	public int getMaxTries() {
		return maxTries;
	}

	public void setMaxTries(int maxTries) {
		this.maxTries = maxTries;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}

	public int getDiff() {
		return diff;
	}

	public void setDiff(int diff) {
		this.diff = diff;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getHiddenWord() {
		return hiddenWord;
	}

	public void setHiddenWord(String hiddenWord) {
		this.hiddenWord = hiddenWord;
	}

	public String[] getWordList() {
		return wordList;
	}

	public void setWordList(String[] wordList) {
		this.wordList = wordList;
	}

	public ArrayList getUsedLetters() {
		return usedLetters;
	}

	public void setUsedLetters(ArrayList usedLetters) {
		this.usedLetters = usedLetters;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
