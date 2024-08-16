package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import setUp.baseTest;
import static interfaces.ClassObjects.*;

public class FormPage extends baseTest{
	
	
	@FindBy(id="nameField")
	private WebElement nameField;
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
	
	@FindBy(id="radioFemale")
	private WebElement femaleOption;
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']"))
	
	@FindBy(id="radioMale")
	private WebElement maleOption;
	
	@FindBy(id = "spinnerCountry")
	private WebElement countrySelection;
	
	@FindBy(id = "btnLetsShop")
	private WebElement shopButton;
	
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
		
	}
	
	
	public void setGender(String gender)
	{
		if (gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
			
	}
	
	public void setCountrySelection(String countryName)
	
	{
		countrySelection.click();
		util.scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
		
	}
	
	public void submitForm()
	{
		shopButton.click();
		
	}
	
	
	
	
	
}
