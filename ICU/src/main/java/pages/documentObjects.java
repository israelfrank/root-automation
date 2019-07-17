package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.Status;

import base.TestBase;

public class documentObjects extends TestBase {
	
	private static final String String = null;

	// elements of opening an entity
	@FindBy (xpath = "/html/body/section/section/div[2]/div[1]/nav/ul/li[5]/div/div[2]/span")
	WebElement pressButtonDocument;
	
	@FindBy(css = "[ng-model='newItem']")
	WebElement pressCreateNewItem;
	
	@FindBy(className = "item-title")
	WebElement enterTitle;
	
	@FindBy(css = "[ng-model='item.description']")
	WebElement description;
	
	// elements of multiple choice
	@FindBy(xpath = "/html/body/section/section/div[2]/div[2]/div[1]/div/div/div/div[3]/div[2]/table/tbody/tr[1]/td[3]")
	WebElement pressOnEntity;

	@FindBy (xpath = "/html/body/section/section/div[2]/div[2]/div[1]/div/div/div/div[3]/div[2]/table/tbody/tr[1]/td[2]")
	WebElement pressMultipleChoice;
	
	@FindBy(css = ".multipleSelected .tick .ng-valid")
	WebElement pressSecondMultipleChoice;
	
	// elements of delete multiple choice
	@FindBy (className =  "delete")
	WebElement pressDeleteMultipleChoice;
	
	@FindBy (className = "action-button")
	WebElement deleteMultipleChoice;
	
	// elements of add tags multiple choice
	@FindBy (className = "tag")
	WebElement TagsMultipleChoice;
	
	@FindBy (css = "[style='width: 501px;']")
	WebElement selectTags;
	
	@FindBy(className = "ui-select-choices-row-inner")
	WebElement clickOnNewTAg;
	
	@FindBy (className = "action-button")
	WebElement updateTags;
	
	@FindBy (xpath = "//*[@id=\"addTag\"]/span/span/span[2]/span")
	WebElement tagsOnTheScreen;
	
	//elements of add date multiple select
	@FindBy(className = "due")
	WebElement pressOnDateMultipleSelect;
	
	@FindBy(className = "hasDatepicker")
	WebElement pressToChooseDate;
	
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[7]/a")
	WebElement chooseADate;
	
	@FindBy (className = "action-button")
	WebElement updateDate;
	
	@FindBy(css = "[ui-date='dueOptions']")
	WebElement dateOnTheScreen;

	// function for wait
	private void waitForVisibility (WebElement element)  {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
		
	public documentObjects() {
		
	 	PageFactory.initElements(driver, this);
	}
	
	
	// a function that press on document tab
	public void pressDocument() throws InterruptedException {
		
		waitForVisibility(pressButtonDocument);
		
		pressButtonDocument.click();
		
		Thread.sleep(3000);
	}
	
	// a function that opens a new entity and adds a title and description
	public void openEntity(String tit , String des) throws InterruptedException {
		
		waitForVisibility(pressCreateNewItem);
		
		pressCreateNewItem.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(enterTitle);
		
		enterTitle.sendKeys(tit);
		
		
		waitForVisibility(description);
		
		description.sendKeys(des);
		
		
		waitForVisibility(pressOnEntity);
		
		pressOnEntity.click();
		
	
	}
	
	// a function that delete entity using multiple select
	public void deleteEntityMultipleChoice() throws InterruptedException {
		
		
		waitForVisibility(pressMultipleChoice);
		
		pressMultipleChoice.click();
		
	
		waitForVisibility(pressDeleteMultipleChoice);
		
		pressDeleteMultipleChoice.click();
		
		
		waitForVisibility(deleteMultipleChoice);
		
		deleteMultipleChoice.click();
		
	
		logger.log(Status.PASS , "delete document using mulitiple choice");
			
		}
	
	// a function that adds tags using multiple select 
	public void addTagsMultipleChoice(String tags) throws InterruptedException {
		 
		
		waitForVisibility(pressMultipleChoice);
		
		pressMultipleChoice.click();
		
		
		waitForVisibility(TagsMultipleChoice);
		
		TagsMultipleChoice.click();
		
		
		waitForVisibility(selectTags);
		
		selectTags.sendKeys(tags);
		
		
		waitForVisibility(clickOnNewTAg);
		
		clickOnNewTAg.click();
		
		
		waitForVisibility(updateTags);
		
		updateTags.click();
		
		Thread.sleep(2000);
		waitForVisibility(pressSecondMultipleChoice);
		
		pressSecondMultipleChoice.click();
		
		
		waitForVisibility(pressOnEntity);
		
		pressOnEntity.click();
		
		
		Thread.sleep(2000);
		
		String check =tagsOnTheScreen.getText();
		
		// checks if the tags have been updated on the side of the screen
		if (check.equals("mission (New)")) {
		
			logger.log(Status.PASS , "add Tags using multiple select");
		}
		
		else {
			
			logger.log(Status.FAIL, "add Tags using multiple select");
		}
		
	}
	
	public void addDateMultipleChoice() throws InterruptedException {
		
		waitForVisibility(pressMultipleChoice);
		
		pressMultipleChoice.click();
		
	
		waitForVisibility(pressOnDateMultipleSelect);
		
		pressOnDateMultipleSelect.click();
		
		
		waitForVisibility(pressToChooseDate);
		
		pressToChooseDate.click();
		
		
		waitForVisibility(chooseADate);
		
		chooseADate.click();
		
		
		Thread.sleep(2000);
		waitForVisibility(updateDate);
		
		updateDate.click();
		
		
		Thread.sleep(1000);
		waitForVisibility(pressSecondMultipleChoice);
		
		pressSecondMultipleChoice.click();
		
		
		waitForVisibility(pressOnEntity);
		
		pressOnEntity.click();
		
		
		Thread.sleep(3000);
		
		String check =dateOnTheScreen.getAttribute("value");
		
		// checks if the date have been updated on the side of the screen
		if (check.equals("27/07/2019")) {
		
			logger.log(Status.PASS , "add Date using multiple select");
		}
		
		else {
			
			logger.log(Status.FAIL, "add Date using multiple select");
		}
		
		
	}
	 
	
		
	
}
	

	
