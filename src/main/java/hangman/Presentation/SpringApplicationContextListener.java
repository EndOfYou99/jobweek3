//package hangman.Presentation;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import hangman.GameConfig;
//import hangman.businessLogic.GameRepository;
//import hangman.businessLogic.GameService;
//import hangman.businessLogic.wordList;
//import jakarta.servlet.ServletContextEvent;
//import jakarta.servlet.ServletContextListener;
//import jakarta.servlet.annotation.WebListener;
//
//
//@WebListener
//@ComponentScan(basePackages={"hangman.businessLogic","hangman.Presentation"})
//public class SpringApplicationContextListener implements ServletContextListener{
//
//	public void contextInitialized(ServletContextEvent sce) {
//		
//
//	     ApplicationContext ac1 = new AnnotationConfigApplicationContext(GameConfig.class);
//		 GameRepository gameRepository=ac1.getBean("gameRepository",GameRepository.class);
//		 GameService gameService=ac1.getBean("gameService",GameService.class);
//
//		 sce.getServletContext().setAttribute("gameService", gameService);
//		 sce.getServletContext().setAttribute("GameRepository",gameRepository);
//		 
//		 System.out.println("hello from listener");
//	}
//}
