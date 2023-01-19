package hangman.businessLogic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class wordListTest {

	wordList wordList = new wordList();

	@Test
	void testListNotEmpty() {
		assertNotNull(wordList.getWordList());
	}

	@Test
	void testListLength() {
		assertEquals(wordList.getWordList().length, 39);
	}

}
