package br.ce.dalton.tasks.functional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TasksTest {

		public WebDriver acessarAplicacao () throws MalformedURLException{				
								
				
	//	WebDriver driver = new ChromeDriver();
	
	DesiredCapabilities cap =  DesiredCapabilities.chrome();
	
	WebDriver driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"),cap);
		driver.navigate().to("http://192.168.0.12:8081/tasks/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		
		return driver;
		}

	
	/*@Test
	public void testAmbiente() {
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.google.com");
	}*/
	
	@Test
	public void deveSalvarTarefaComSucesso() throws MalformedURLException {
		
		WebDriver driver = acessarAplicacao();
		
	
		
		try {
		
			// clicar em Add Todo
			driver.findElement(By.id("addTodo")).click();
			
			
			//escrever descricao
			
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
			
			
			//escreve a data
			
			
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2020");
			
			//clicar em salvar
			
				driver.findElement(By.id("saveButton")).click();
			
			
			//validar mensagem de sucesso
			
			String mensagem = driver.findElement(By.id("message")).getText();
			
			Assert.assertEquals("Success!!!", mensagem);
		} finally {
		
			// fechar o browser
		
		driver.quit();
			
		}
		
	
		
		
		
	}
	
		@Test
		public void naoDeveSalvarTarefaSemDescricao() throws MalformedURLException {
		
		WebDriver driver = acessarAplicacao();
		
	
		
		try {
		
			// clicar em Add Todo
			driver.findElement(By.id("addTodo")).click();
			
			
					
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
			

			
			//clicar em salvar
			
				driver.findElement(By.id("saveButton")).click();
			
			
			//validar mensagem de sucesso
			
			String mensagem = driver.findElement(By.id("message")).getText();
			
			Assert.assertEquals("Fill the due date", mensagem);
		} finally {
		
		driver.quit();
			
		}
		

		
		
		
	}
	@Test
		public void naoDeveSalvarTarefaSemDueData() throws MalformedURLException {
		
		WebDriver driver = acessarAplicacao();
		
	
		
		try {
		
			// clicar em Add Todo
			driver.findElement(By.id("addTodo")).click();
			
			
					
			
			//escreve a data
			
			
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2020");
			
			//clicar em salvar
			
				driver.findElement(By.id("saveButton")).click();
			
			
			//validar mensagem de sucesso
			
			String mensagem = driver.findElement(By.id("message")).getText();
			
			Assert.assertEquals("Fill the task description", mensagem);
		} finally {
		
		driver.quit();
			
		}
			
		
	}
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() throws MalformedURLException {
		
		WebDriver driver = acessarAplicacao();
		
	
		
		try {
		
			// clicar em Add Todo
			driver.findElement(By.id("addTodo")).click();
			
			
			//escrever descricao
			
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
			
			
			//escreve a data
			
			
			driver.findElement(By.id("dueDate")).sendKeys("10/01/2020");
			
			//clicar em salvar
			
				driver.findElement(By.id("saveButton")).click();
			
			
			//validar mensagem de sucesso
			
			String mensagem = driver.findElement(By.id("message")).getText();
			
			Assert.assertEquals("Due date must not be in past", mensagem);
		} finally {
		
			// fechar o browser
		
		driver.quit();
			
		}
	}
		@Test
		public void deveRemoverTarefaComSucesso() throws MalformedURLException {
			
			WebDriver driver = acessarAplicacao();
					
			
			try {
			
				//inserir tarefa				
				driver.findElement(By.id("addTodo")).click();			
				driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
				driver.findElement(By.id("dueDate")).sendKeys("10/01/2021");
				driver.findElement(By.id("saveButton")).click();						
				String mensagem = driver.findElement(By.id("message")).getText();				
				Assert.assertEquals("Sucesso", mensagem);
				
				//remover a tarefa
				
				driver.findElement(By.xpath("//a[@class='btn btn-outline-danger btn-sm']")).click();
				mensagem = driver.findElement(By.id("message")).getText();				
				Assert.assertEquals("Sucesso", mensagem);
				
				
				
				
			} finally {
			
				// fechar o browser
			
			driver.quit();
				
			}
		
	
		
		
		
	}
	
	
	
	

}
