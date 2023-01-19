//package hangman.Presentation;
//
//import java.io.IOException;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import hangman.businessLogic.GameBean;
//import hangman.businessLogic.GameRepository;
//import hangman.businessLogic.GameService;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet(name="Game", urlPatterns= {"/Game"})
//public class Game extends HttpServlet{
//
//	GameRepository gameRepo;
//
//	GameService gameService;
//	public void init(ServletConfig config) throws ServletException {
//		super.init( config);
//	
//		
//		gameRepo=(GameRepository)config.getServletContext().getAttribute("GameRepository");
//		gameService=(GameService)config.getServletContext().getAttribute("gameService");
//	}
//
//	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
//String  stringid=request.getParameter("id");
//	
//System.out.println("Game servlet gameService: " + gameService.toString());
//System.out.println("Game servlet gamerepo: " + gameRepo.toString());
//		UUID id=UUID.fromString(stringid);
//		if(!gameRepo.contains(id)) {
//			response.sendRedirect("/HangmanGame/NotFound.jsp");
//			return;
//
//		}
//		GameBean myGame=gameService.getGame(id);
//		
//
//		String letter=request.getParameter("letter");
//		String firstLetter=String.valueOf(myGame.getWord().charAt(0));
//		String lastLetter=String.valueOf(myGame.getWord().charAt(myGame.getWord().length()-1));
//	
//		gameService.updateUsedList(myGame,firstLetter,lastLetter,letter);
//	
//		String temp=myGame.getHiddenWord();
//		
//		gameService.makeTry(id,letter);
//		
//		gameService.checkAttempt(myGame,temp);
//
//		request.setAttribute("id",id);
//	
//		RequestDispatcher rd= request.getRequestDispatcher("myGame.jsp");	
//	    rd.forward(request,response);
//	}
//
//    
//	
//
//	
//
//}
