package hangman.businessLogic;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@RunWith(MockitoJUnitRunner.class)
class GameServiceTest {
	
	IGameRepository gameRepo;
	
	private IGameService gameService;
	
	GameBean game;
	
	@BeforeEach
	public void setUp() {
		gameRepo=Mockito.mock(IGameRepository.class);
		gameService=new GameService(gameRepo);
		gameService=Mockito.spy(gameService);
		String[] list=new String[] {"Abyss", "Bubbly", "Buzz", "Buff", "Cozy", "Fluff", "Fluffy", "Fizz", "Fizzy", "Fox", "Jinx", "Lucky", "Puzzle", "Foxglove", "Abruptly", "Voyeurism", "Pneumonia", "Jiujitsu", "Espionage", "Witchcraft", "Razzmatazz", "Zigzagging", "Buckaroo", "Iatrogenic", "Jawbreaker", "Voodoo", "Jazz_singer_drops_beats", "Buzzing_around_the_beekeeper", "Awkward_klutzy_numbskull", "Croquet_players_fix_games", "Throwing_gnarly_punches", "Absurd_wizard_mystifies", "Jiujitsu_masters_train", "Wimpy_geek_panics", "Twelve_foxes_hunt", "A_quiet_jinx_sulks", "Nine_tailed_demon_fox", "The_great__wall_of_china", "Sage_of_six_paths"};
		game=new GameBean(0,0,6,0,1,"","",list,"N");
		
	}
	
	@Test
	void testChooseWord() {
		gameService.chooseWord(game);
	}
	
	@Test
	public void testGetGame() {
		UUID id=UUID.fromString("668c1752-ae7a-4675-b18f-e6204d359078");

		Mockito.when(gameService.getGame(id)).thenReturn(game);

		GameBean check=gameService.getGame(id);
		
		verify(gameRepo).getGameById(id);
		assertEquals(check,game);
	}
	
	@Test
	public void testcheckEmpty() {
		Mockito.when(gameService.checkEmpty()).thenReturn(true);
		boolean check=gameService.checkEmpty();
		
		verify(gameRepo).isEmpty();
		assertEquals(check,true);
	}

	@Test
	public void testCheckAttemptFalse() {
		//given

		game.setHiddenWord("h***o");
		game.setTries(0);
		game.setMaxTries(6);
		game.setResult("N");
		String temp="h***o";
		//when
		gameService.checkAttempt( game, temp);
		
		//then
		assertEquals(game.getHiddenWord(),temp);
		assertEquals(game.getResult(),"N");
		assertEquals(game.getTries(),1);
	}
	
	@Test
	public void testCheckAttemptTrue() {
		//given

		game.setHiddenWord("h*llo");
		game.setTries(0);
		game.setMaxTries(6);
		game.setResult("N");
		String temp="h***o";
		//when
		gameService.checkAttempt( game, temp);
		
		//then
		assertNotEquals(game.getHiddenWord(),temp);
		assertEquals(game.getResult(),"N");
		assertEquals(game.getTries(),0);
	}
	
	@Test
	public void testCheckForLose() {
		//given

		game.setHiddenWord("h***o");
		game.setTries(6);
		game.setMaxTries(6);
		game.setResult("N");
		String temp="h***o";
		//when
		gameService.checkAttempt( game, temp);
		
		//then
		assertEquals(game.getHiddenWord(),temp);
		assertEquals(game.getResult(),"L");
		assertEquals(game.getTries(),7);
	}
	
	@Test
	public void testCheckForWin() {
		//given

		game.setWord("hello");
		game.setHiddenWord("hello");
		game.setTries(6);
		game.setMaxTries(6);
		game.setResult("N");
		String temp="h*llo";
		//when
		gameService.checkAttempt( game, temp);
		
		//then
		assertEquals(game.getHiddenWord(),game.getWord());
		assertEquals(game.getResult(),"W");
		assertEquals(game.getTries(),6);
	}
	
	@ParameterizedTest
	@CsvSource({"0,Easy","12,Medium","25,Hard"})
	public void testSetDifficulty(int result,String difficulty) {

		gameService.setDifficulty(game,difficulty);
	}
	
	@Test
	public void testHide() {

		game.setWord("hello");
		gameService.hide(game);
		String hidden=game.getHiddenWord();
		assertNotNull(hidden);
		assertEquals(game.getWord().length(),game.getHiddenWord().length());
	}
	
	@ParameterizedTest
	@CsvSource({"hello,h***o,h,o","hello_i_am_me,h****_*_****e,h,e"})
	public void testCheck(String word,String hiddenWord,String f,String l) {
		gameService.Check(word,hiddenWord,f,l);
	}

	@Test
	public void testStartNewGame() {
		UUID id=UUID.fromString("668c1752-ae7a-4675-b18f-e6204d359078");
		String difficulty="Easy";
		gameService.startNewGame(id,difficulty,game);
		
		verify(gameService).startNewGame(id,difficulty,game);
		
		verify(gameService).setDifficulty(game,difficulty);
		
		verify(gameService).chooseWord(game);
	   	}
	
	@Test
	public void testmakeTry() {
		HashMap<UUID,GameBean> myRepomap=new HashMap<UUID,GameBean>();
		UUID id=UUID.fromString("668c1752-ae7a-4675-b18f-e6204d359078");
		String difficulty="Easy";
		IGameRepository myRepo=new GameRepository(myRepomap);
		IGameService myGameService=new GameService(myRepo);
	    myGameService.startNewGame(id,difficulty,game);
	    
		game.setHiddenWord("scary");
		myRepo.contains(id);
		System.out.println("This is the game:" + gameService.getGame(id));
		myGameService.makeTry(id,"a");
	}
	
	@ParameterizedTest
	@CsvSource({"hello,h,o,o","welcome,w,e,d"})
	public void testUpdateUsedList(String word,String first, String last, String letter) {
		game.setWord(word);
		gameService.updateUsedList(game,first,last,letter);
	}
	
	@Test
	public void testUpdateUsedListEmpty() {
		ArrayList<String> list=new ArrayList<String>();
		list.add("There are no letters currently tried.");
		game.setUsedLetters(list);
		game.setWord("coconutc");
		gameService.updateUsedList(game,"c","c","o");
	}


	

}
