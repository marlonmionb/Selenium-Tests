import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoDeTreinamento {
	

	@Test
	public void testeTextField() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", "C://driver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement formNome = driver.findElement(By.id("elementosForm:nome"));
		formNome.sendKeys("Teste de Escrita");
		Assert.assertEquals("Teste de Escrita", formNome.getAttribute("value"));
		
	}
	
	@Test
	public void deveInteragirComTextArea() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement textAreaSugestion = driver.findElement(By.id("elementosForm:sugestoes"));
		textAreaSugestion.sendKeys("Teste");
		Assert.assertEquals("Teste", textAreaSugestion.getAttribute("value"));
		
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		
		WebElement radioGenderButton = driver.findElement(By.id("elementosForm:sexo:0"));
		radioGenderButton.click();
		Assert.assertTrue(radioGenderButton.isSelected());
		
	}
	
	@Test
	public void deveInteragirComCheckbox() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement checkboxFavoriteFood = driver.findElement(By.id("elementosForm:comidaFavorita:2"));
		checkboxFavoriteFood.click();
		Assert.assertTrue(checkboxFavoriteFood.isSelected());
		
	}
	
	@Test
	public void deveInteragirComCombo() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement comboEscolaridade = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(comboEscolaridade);
		combo.selectByVisibleText("2o grau completo");
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement comboEscolaridade = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(comboEscolaridade);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		
		for (WebElement option: options) {
			if(option.getText().equals("Mestrado"));
				encontrou = true;
				break;
		}
		
		Assert.assertTrue(encontrou);
	}
		
	@Test
	public void deveVerificarValoresComboMultiplo() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement comboEscolaridade = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(comboEscolaridade);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
	}
	
	@Test
	public void deveInteragirComBotoes() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement buttonClickMe = driver.findElement(By.id("buttonSimple"));
		buttonClickMe.click();
		
		Assert.assertEquals("Obrigado!", buttonClickMe.getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComLinks() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement link = driver.findElement(By.linkText("Voltar"));
		link.click();
		
		WebElement textElement = driver.findElement(By.id("resultado"));
		
		
		Assert.assertEquals("Voltou!", textElement.getText());
		
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		System.setProperty("webdriver.gecko.driver", "C://driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// Assert.assertTrue(driver.findElement(By.tagName("body"))
		//		.getText().contains("Campo de treinamento"));
		
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
	}
	
	
}
