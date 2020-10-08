package com.studio.home.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.studio.automation.framework.TestSession;
import com.studio.qe.automation.framework.pagefactory.MobileWebViewPage;

public class DoctorStaffAdminPO extends MobileWebViewPage{

	public DoctorStaffAdminPO(TestSession session) throws Exception {
		super(session, "Applications/studio/DoctorStaffAdmin");
	}
	
	/**
	 *  Used to verify Fields on page
	 * @param element
	 * @return
	 */
	
	public boolean verify_FieldOnPage3(String element) {
		//session.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(session.driver, 30);
		
		WebElement status=wait.until(ExpectedConditions.visibilityOf(element(element)));
		return status.isDisplayed();
	}
	
	public void enter_Email(String email) {
		element("Email_Field").sendKeys(email);
	}
	
	public void enter_Password(String password) {
		element("Password").sendKeys(password);
	}
	
	public boolean click_Loginbtn() throws InterruptedException {
		boolean status = false;

		if (element("LoginButton").isEnabled()) {
			element("LoginButton").click();
			status = true;
		} else {
			status = false;
		}
		return status;
	}
	
	public void search_Patients(String patient) throws InterruptedException {
		element("SearchPatient").click();
		element("SearchPatient").sendKeys(patient);
		Thread.sleep(1000);
		Actions action=new Actions(session.driver);
		action.moveToElement(element("SearchButton")).click().build().perform();
	}
	
	public boolean verify_PatientListName(String patient) {
		boolean status=false;
		
		for(int i=1;i<elements("Table").size()-1;i++) {
			String Name= elements("Table").get(i).getText();
			if(Name.contains(patient)) {
				status=true;
			}else {
				status=false;
			}
		}
		
		return status;
	}
	
	public boolean click_SubmittedFormBtn(String patient) throws InterruptedException {
		boolean status=false;
		
		Actions action=new Actions(session.driver);
		for(int i=1;i<elements("Table").size()-1;i++) {
			String Name= elements("Table").get(i).getText();
			if(Name.contains(patient)) {
				 WebElement element=session.driver.findElement(By.xpath("//tr[" +i+ "]//td[2]//button[1]"));
				 action.moveToElement(element).click().build().perform();
				 if(element("SentFormPopUp").isDisplayed()) {
				 status=true;
				 break;
				 }else {
					 status=false;
				 }
			}else {
				  status=false;
			}
		}
		return status;
	}
	

}
