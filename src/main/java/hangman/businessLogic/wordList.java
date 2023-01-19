package hangman.businessLogic;

import java.util.Arrays;

public class wordList {
	String[] wordList;

	public wordList() {
		String[] list = new String[] { "Abyss", "Bubbly", "Buzz", "Buff", "Cozy", "Fluff", "Fluffy", "Fizz", "Fizzy",
				"Fox", "Jinx", "Lucky", "Puzzle",
				// <!-- medium words-->
				"Foxglove", "Abruptly", "Voyeurism", "Pneumonia", "Jiujitsu", "Espionage", "Witchcraft", "Razzmatazz",
				"Zigzagging", "Buckaroo", "Iatrogenic", "Jawbreaker",
				// <!-- hard words-->
				"Voodoo", "Jazz_singer_drops_beats", "Buzzing_around_the_beekeeper", "Awkward_klutzy_numbskull",
				"Croquet_players_fix_games", "Throwing_gnarly_punches", "Absurd_wizard_mystifies",
				"Jiujitsu_masters_train", "Wimpy_geek_panics", "Twelve_foxes_hunt", "A_quiet_jinx_sulks",
				"Nine_tailed_demon_fox", "The_great__wall_of_china", "Sage_of_six_paths" };
		this.wordList = list;
	}

	public String[] getWordList() {
		return wordList;
	}

	@Override
	public String toString() {

		return "wordList [wordList=" + Arrays.toString(wordList) + "]";
	}
}
