import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestAlert {
	
	@Test
	public void deveInteragirComAlertSimples() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("alert")).click();
		
		// Abre alerta
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Alert Simples", alert.getText());
		String text = alert.getText();
		
		// Fecha alerta
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(text);
		
	}
	
	@Test
	public void deveInteragirComAlertComposto() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();
		
		driver.findElement(By.id("confirm")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.accept();
		
		
	}
	
	public void deveInteragirComAlertPrompt() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys("12");
		alerta.accept();
		Assert.assertEquals("Era 12?", alerta.getText());
		alerta.accept();
		
	}
	
	@Test
	public void deveRealizarUmCadastro() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Marlon");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Bohn");
		driver.findElement(By.id("elementosForm:sexo")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		new Select(driver.findElement(By.id("elementosForm:escolaridade")))
					.selectByVisibleText("Superior");
		new Select(driver.findElement(By.id("elementosForm:esportes")))
				.selectByVisibleText("Natacao");
		
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Uma sugestão qualquer...");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Cadastrado!"));	
		
		Assert.assertEquals("Nome: Marlon", driver.findElement(By.id("descNome")).getText());
		Assert.assertEquals("Sobrenome: Bohn", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Carne Pizza", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText());
		Assert.assertEquals("Sugestoes: Uma sugestão qualquer...", driver.findElement(By.id("descSugestoes")).getText());
		
		
	}
	

}
