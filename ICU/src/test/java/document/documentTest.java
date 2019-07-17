package document;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.documentObjects;

public class documentTest extends TestBase {
	
	documentObjects documentsobjects;
	
	@BeforeClass
	public void SetUp() throws InterruptedException{	
	initialization(); 
	Login();
	documentsobjects = new documentObjects();

	}
	
	@Test(priority = 1)
	public void openDoc() throws InterruptedException {
	
		// press document tab
		documentsobjects.pressDocument();
	  
		//open doc  enter title and description
		documentsobjects.openEntity("doc1" , "importenet");
	}
	
	@Test(priority = 2)
	public void documentsMulitipleChoice() throws InterruptedException {
	
		logger = extent.createTest("document using multiple choice");
		
		// delete entity using multiple select
		documentsobjects.deleteEntityMultipleChoice();
		
		//open doc  enter title and description
		documentsobjects.openEntity("doc2" , "importenet2");
		
		documentsobjects.addTagsMultipleChoice("mission");
		
		documentsobjects.addDateMultipleChoice();
		
		
		
	}
	
	
	
	
	
	@AfterClass
	public void after() {
		
		extent.flush();
		
	}
		
}
	
		
	


