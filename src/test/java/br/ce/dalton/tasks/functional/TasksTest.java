package br.ce.dalton.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {

		public WebDriver acessarAplicacao (){				
								
				
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8081/tasks/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
		
		return driver;
		}

	
	/*@Test
	public void testAmbiente() {
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.google.com");
	}*/
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		
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
		public void naoDeveSalvarTarefaSemDescricao() {
		
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
		public void naoDeveSalvarTarefaSemDueData() {
		
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
	public void naoDeveSalvarTarefaComDataPassada() {
		
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
	
	
	
	

}
