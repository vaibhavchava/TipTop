package Step_Def;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Tip_Top.Tip_Top.Browsers;
import Tip_Top.Tip_Top.Test_Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class StepDefinitions extends Test_Base {

	@Given("User launches Browser")
	public void user_launches_browser() {
		System.out.println("Browser Enter");
		Browsers.init("chrome");
	}

	@And("User enters {string};")
	public void user_enters(String url) throws InterruptedException, IOException {
		br.navigateTo("https://d3pv22lioo8876.cloudfront.net/tiptop/");
	}

	@Then("Verify that the text input element with xpath {string} is disabled in the form")
	public void disabled_Input(String xpath) {

		WebElement disabled_Input = driver.findElement(By.xpath("(//input[@name='my-disabled'])"));
		if (disabled_Input.isEnabled()) {
			System.out.println("Disabled Input field is enabled");
		} else
			System.out.println("Disabled Input field is disabled");
	}

	@Then("Verify that the text input with value {string} is in readonly state by using 2 xpaths")
	public void readOnly(String readOnly) {

		WebElement readOnly1 = driver.findElement(By.xpath("//input[@name='my-readonly']"));
		WebElement readOnly2 = driver.findElement(By.xpath("//input[@value='Readonly input']"));
		Assert.assertTrue(readOnly1.getAttribute("readonly").equals("true"), "Element is in readonly state");
		Assert.assertTrue(readOnly2.getAttribute("readonly").equals("true"), "Element is in readonly state");
	}

	@Then("Verify that the dropdown field to select color is having 8 elements using 2 xpaths")
	public void colors_dropdown() {
		int expectedColorSize = 8;
		List<WebElement> colors1 = driver.findElements(By.xpath("//select[@name='my-select']//option"));
		List<WebElement> colors2 = driver.findElements(By.xpath("//select[@class='form-select']//option"));

		int ActualColorSize1 = colors1.size();
		int ActualColorSize2 = colors2.size();
		System.out.println(ActualColorSize1);
		Assert.assertEquals(ActualColorSize1, expectedColorSize, "Element is in readonly state");
		Assert.assertEquals(ActualColorSize1, expectedColorSize, "Element is in readonly state");
		for (WebElement color : colors1) {
			System.out.print(color.getText() + " ");
		}
	}
		
		
		@Then("Verify that the submit button is disabled when no data is entered in Name field")
		public void submit_disabled() {
			WebElement name = driver.findElement(By.xpath("//*[@id='my-name-id']"));
			WebElement submit = driver.findElement(By.xpath("//*[@id='submit-form']"));
			if (name.getText().isBlank()) {
				boolean button = submit.isEnabled();
			Assert.assertFalse(button, "submit button is disabled");
			}
		
	}
		
		@Then("Verify that the submit button enabled when both Name and Password field is entered")
		public void submit_enabled() throws InterruptedException {
			Thread.sleep(4000);
			WebElement name = driver.findElement(By.xpath("//*[@id='my-name-id']"));
			name.sendKeys("abc");
			WebElement password = driver.findElement(By.xpath("//*[@id='my-password-id']"));
			password.sendKeys("123");
			WebElement submit = driver.findElement(By.xpath("//*[@id='submit-form']"));
			if (name.getText() != null && password.getText() != null) {
				boolean button = submit.isEnabled();
			Assert.assertTrue(button, "submit button is enabled");
			}
		
	}
		
		@Then("Verify that on submit of 'Submit' button the page shows 'Received' text")
		public void received_Text() throws InterruptedException {
			
			WebElement received = driver.findElement(By.xpath("//*[@id='message']"));
			WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", submit);
			String expectedText = "Received!";
			String actualText = received.getText();
			Assert.assertEquals(actualText, expectedText, "Received text is displayed");
			
			}
		
		@Then("Verify that on submit of form all the data passed to the URL")
		public void verifyUrl() throws InterruptedException {
			
			String currenturl = driver.getCurrentUrl();
			String expectedurl = "https://d3pv22lioo8876.cloudfront.net/tiptop/submitted.html?my-name=abc&my-password=123&my-readonly=Readonly+input&my-select=white";   
			
			Assert.assertEquals(currenturl, expectedurl, "Received url with all the data");
			
			}
		
	

	

}
