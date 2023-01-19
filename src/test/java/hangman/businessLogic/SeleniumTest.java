package hangman.businessLogic;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(MockitoJUnitRunner.class)
class SeleniumTest {

	@InjectMocks
	private IGameService gameService;

	@Mock
	private IGameRepository gameRepo;

	@Test
	void testChooseWord() throws InterruptedException {

		Random rand = new Random();

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/HangmanGame/login");

		WebElement username = driver.findElement(By.id("username"));

		WebElement password = driver.findElement(By.id("password"));

		WebElement submitlogin = driver.findElement(By.cssSelector("input[type='submit']"));

		username.sendKeys("Kaan");

		password.sendKeys("123456");
		Thread.sleep(300);

		submitlogin.click();
		Thread.sleep(300);

		WebElement difficulty = driver.findElement(By.cssSelector("input[id='hard']"));

		difficulty.click();
		Thread.sleep(300);

		WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));

		submit.click();
		Thread.sleep(300);

		boolean check = true;
		while (check) {
			int letter = rand.nextInt(25) + 1;
			String id = Integer.toString(letter);

			WebElement me = driver.findElement(By.id(id));
			me.click();
			Thread.sleep(500);

			List<WebElement> l = driver.findElements(By.xpath("//*[contains(text(),'!')]"));
			if (l.size() > 0) {
				check = false;
				break;
			}
		}
	}

}
