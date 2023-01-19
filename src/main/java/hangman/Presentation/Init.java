//package hangman.Presentation;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import hangman.businessLogic.wordList;
//import hangman.businessLogic.GameBean;
//import hangman.businessLogic.GameRepository;
//import hangman.businessLogic.GameService;
//import jakarta.servlet.ServletConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet(name="Init",urlPatterns= {"/Init"})
//public class Init extends HttpServlet{
//	
//	wordList wordList=new wordList();
//
//	@Autowired
//	GameService gameService;
//	
//	GameRepository gameRepo;
//	Random rand=new Random();
//
//	public void init(ServletConfig config) throws ServletException {
//		super.init( config);
//	
//		gameRepo=(GameRepository)config.getServletContext().getAttribute("gameRepository");
//		//ClassPathXmlApplicationContext ac =  (ClassPathXmlApplicationContext) config.getServletContext().getAttribute("applicationContext");
//		gameService=(GameService)config.getServletContext().getAttribute("gameService");
//		//this.game= ac.getBean("gameBean",GameBean.class);
//     	
//	}
//
//	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
//		String[] list=wordList.getWordList();
//	    System.out.println("list array is: " + wordList);
//	    System.out.println(gameService.toString());
//	    
//	    GameBean game=new GameBean(0,0,6,0,1,"","",list,"N");
//		UUID id=UUID.randomUUID();
//	
//		String difficulty=request.getParameter("difficulty");
//
//		gameService.startNewGame(id,difficulty,game);
//		
//		
//		request.setAttribute("id", id);
//		   
//	    System.out.println(gameService.toString());
//
//	    
//	    response.sendRedirect("myGame.jsp?id="+id);	
//	}
//	}
//	
//
