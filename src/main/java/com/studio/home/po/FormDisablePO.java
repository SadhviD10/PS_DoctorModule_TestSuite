package com.studio.home.po;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.studio.automation.framework.TestSession;
import com.studio.helper.GMailFetch;
import com.studio.qe.automation.framework.pagefactory.MobileWebViewPage;

public class FormDisablePO extends MobileWebViewPage {

	public FormDisablePO(TestSession session) throws Exception {
		super(session, "Applications/studio/FormDisable");
	}

	/**
	 * Used to verify Fields on page
	 * 
	 * @param element
	 * @return
	 */

	public boolean verify_FieldOnPage(String element) {
		// session.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(session.driver, 30);

		WebElement status = wait.until(ExpectedConditions.visibilityOf(element(element)));
		return status.isDisplayed();
	}

	/**
	 * Enter Login Credentials
	 * 
	 * @throws InterruptedException
	 */

	public void login_ToApplication() throws InterruptedException {
		element("Email_Field").sendKeys("office-admin@patientstudio.com");
		Thread.sleep(1000);
		element("Password").sendKeys("1 Super Safe Password!");
		Thread.sleep(1000);
		element("LoginButton").click();
		Thread.sleep(1000);
	}

	/**
	 * Used to Enter in Firstname,Lastname, Email and Choose form
	 * 
	 * @throws InterruptedException
	 */

	public void enter_FirstNameLstNameEmailChooseForm() throws InterruptedException {
		Actions action = new Actions(session.driver);
		action.moveToElement(element("SendFormButton")).click().build().perform();
		Thread.sleep(4000);
		session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		element("FirstName").sendKeys("test");
		Thread.sleep(1000);
		element("LastName").sendKeys("test");
		Thread.sleep(1000);
		element("Email").sendKeys("Patient.studiotest@gmail.com");
		Thread.sleep(1000);
		element("ChooseForm").click();
		Thread.sleep(2000);
		element("Field1Form").click();
		Thread.sleep(1000);
	}

	/**
	 * Used to click on SendForm button
	 * 
	 * @return
	 * @throws InterruptedException
	 */

	public boolean click_SendFormBtn1() throws InterruptedException {
		boolean status = false;
		Actions action = new Actions(session.driver);
		if (element("SendFormButtonOnForm").isEnabled()) {
			action.moveToElement(element("SendFormButtonOnForm")).click().build().perform();
			Thread.sleep(6000);
			status = true;
		} else {
			status = false;
		}
		Thread.sleep(8000);
		return status;
	}

	public boolean open_SecondTab() throws AWTException, InterruptedException {
		boolean status = false;
		
		String value=Keys.chord(Keys.CONTROL, Keys.RETURN);		
        element("Dashboard").sendKeys(value);
		Set<String> child = session.driver.getWindowHandles();
		int count = child.size();
		System.out.println("Total number of tabs opened are" + count);
		if (count > 1) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	public boolean switch_SecondBrowserTab(String AdminURL) throws InterruptedException {
		boolean status = false;

		String parent = session.driver.getWindowHandle();
		Thread.sleep(1000);
		Set<String> child = session.driver.getWindowHandles();
		int count = child.size();
		System.out.println("Total number of tabs opened are" + count);
		if (count > 1) {
			ArrayList<String> tabs = new ArrayList<>(child);
			session.driver.switchTo().window(tabs.get(1));
			Thread.sleep(1000);
			session.driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			session.driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
			session.driver.get(AdminURL);

			status = true;
		} else {
			status = false;
		}
		Thread.sleep(1000);
		return status;
	}

	public boolean openAndSwitch_NextTab() throws AWTException, InterruptedException {
		boolean status = false;
		Robot robot = new Robot();
		String value=Keys.chord(Keys.CONTROL, Keys.RETURN);		
        element("Form_Button").sendKeys(value);

		Set<String> child = session.driver.getWindowHandles();
		int count = child.size();
		System.out.println("Total number of tabs opened are" + count);

		if (count > 2) {
			ArrayList<String> tabs = new ArrayList<>(child);
			session.driver.switchTo().window(tabs.get(2));
			Thread.sleep(1000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(1000);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(1000);
			session.driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			session.driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	/**
	 * Enter Login Credentials to Admin Panel
	 * 
	 * @throws InterruptedException
	 */

	public void login_ToAdminApplication() throws InterruptedException {
		element("Admin_UserName").sendKeys("admin@patientstudio.com");
		Thread.sleep(1000);
		element("Admin_Password").sendKeys("1 Super Safe Password!");
		Thread.sleep(1000);
		Actions action = new Actions(session.driver);
		action.moveToElement(element("Admin_Submit")).click().build().perform();
		Thread.sleep(1000);
	}

	public void enter_AdminSearchField(String practice) throws InterruptedException {
		element("SearchFieldOnAdmin").sendKeys(practice);
		Thread.sleep(1000);
		element("ClickFieldOnAdmin").click();
	}

	public void click_FormBtn() throws InterruptedException {
		Actions action = new Actions(session.driver);
		action.moveToElement(element("Form_Button")).click().build().perform();
		Thread.sleep(1000);
	}

	public void search_FormInList(String formName) throws InterruptedException {
		element("SearchFormField").sendKeys(formName);
		Thread.sleep(1000);
		Actions action = new Actions(session.driver);
		action.moveToElement(element("EditButton")).click().build().perform();
	}

	public void search_FormInListAndClickWebSiteLinkButton(String formName) throws InterruptedException {
		element("SearchFormField").sendKeys(formName);
		Thread.sleep(1000);
		Actions action = new Actions(session.driver);
		action.moveToElement(element("WebsiteLink_button")).click().build().perform();
	}

	public boolean disable_ToggleAndClickSave() throws InterruptedException {
		boolean status = true;
		Thread.sleep(1000);
		element("DisableToggle").click();
		Thread.sleep(1000);
		Actions action = new Actions(session.driver);
		action.moveToElement(element("SaveBtnOnDisablePopup")).click().build().perform();
		Thread.sleep(1000);
		return status;
	}

	public boolean enable_ToggleAndClickSave() throws InterruptedException {
		boolean status = true;
		Thread.sleep(1000);
		element("EnableToggle").click();
		Thread.sleep(1000);
		Actions action = new Actions(session.driver);
		action.moveToElement(element("SaveBtnOnDisablePopup")).click().build().perform();
		Thread.sleep(1000);
		return status;
	}

	public boolean close_BrowserTab() throws InterruptedException {
		boolean status = false;

		Set<String> child = session.driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(child);
		session.driver.close();
		session.driver.switchTo().window(tabs.get(0));
		String Url = session.driver.getCurrentUrl();
		if (Url.contains("https://doctors.qa.patientstudio.com")) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}
	
	public boolean close_SecondAndThirdBrowserTab() throws InterruptedException {
		boolean status = false;

		Set<String> child = session.driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(child);
		session.driver.close();
		session.driver.switchTo().window(tabs.get(1));
		Thread.sleep(1000);
		session.driver.close();
		session.driver.switchTo().window(tabs.get(0));
		String Url = session.driver.getCurrentUrl();
		if (Url.contains("https://doctors.qa.patientstudio.com")) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	public void click_SendFormOnDashboard() throws InterruptedException {
		Actions action = new Actions(session.driver);
		action.moveToElement(element("SendFormButton")).click().build().perform();
		Thread.sleep(1000);
	}

	public boolean verify_FormDisabledFromDropdown(String FormName) throws InterruptedException {
		boolean status = false;

		element("ChooseForm").click();
		Thread.sleep(2000);
		List<WebElement> formLists = elements("FormDropDownOptions");

		for (int i = 0; i < formLists.size(); i++) {
			WebElement form = formLists.get(i);
			String Formname1 = form.getText();
			if (Formname1.equals(FormName)) {
				System.out.println("Form is present");
				status = false;
				break;
			} else {
				System.out.println("Form is not present");
				status = true;
			}
		}
		return status;
	}

	public boolean verify_FormEnabledFromDropdown(String FormName) throws InterruptedException {
		boolean status = false;

		element("ChooseForm").click();
		Thread.sleep(4000);
		List<WebElement> formLists = elements("FormDropDownOptions");

		for (int i = 0; i < formLists.size(); i++) {
			WebElement form = formLists.get(i);
			String Formname1 = form.getText();
			if (Formname1.equals(FormName)) {
				System.out.println("Form is present");
				status = true;
				break;
			} else {
				System.out.println("Form is not present");
				status = false;
			}
		}
		return status;
	}

	public void enter_PatientEmailPassword() throws InterruptedException {
		element("EmailIDFieldPat").sendKeys("Patient.studiotest@gmail.com");
		Thread.sleep(1000);
		element("PasswordFieldPat").sendKeys("Test@123");
		Thread.sleep(1000);
		Actions action = new Actions(session.driver);
		action.moveToElement(element("LoginPat")).click().build().perform();
		Thread.sleep(1000);
	}

	public boolean verifyAndOpen_Form(String form) {
		boolean status = false;

		List<WebElement> form_list = elements("FormList");

		for (int i = 0; i < form_list.size(); i++) {
			WebElement form_name = form_list.get(i);
			String formname = form_name.getText();
			if (formname.equals(form)) {
				form_name.click();
				status = true;
				break;
			} else {
				status = false;
			}
		}
		return status;
	}

	public void fillAndSubmit_form() throws InterruptedException {
	//	element("FormField").sendKeys("Form Fill");
		Thread.sleep(2000);
		Actions action = new Actions(session.driver);
		action.moveToElement(element("SubmitFormBtn")).click().build().perform();
		Thread.sleep(5000);
	}

	public boolean verify_MailFormSuccessfulFormSubmit() {
		boolean status = false;

		HashMap<String, String> hm = GMailFetch
				.getGmailData("subject:Seed Doctor Office. LLC has received your paperwork");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC has received your paperwork");

		if (exist) {
			String body = hm.get("body");
			System.out.println(body);
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	public boolean click_PatientTab() {
		element("PatientTab").click();
		WebDriverWait wait = new WebDriverWait(session.driver, 40);

		WebElement status = wait.until(ExpectedConditions.visibilityOf(element("SearchPatientField")));
		return status.isDisplayed();
	}

	public void search_PatientFromList(String patient) throws InterruptedException, AWTException {
		element("SearchPatientField").sendKeys(patient);
		Thread.sleep(1000);
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
	}

	public boolean verify_PatientSearchResult_EmailPhoneFullName(){
		boolean status=false;
		
		if(element("SearchResult_EmailPhone").isDisplayed()) {
			status=false;
		}else {
			status=true;
		}
		
		return status;
	}
	
	
	public boolean click_PatientFromList() throws InterruptedException {
		((JavascriptExecutor) session.driver).executeScript("arguments[0].scrollIntoView();", element("PatientName"));
		Thread.sleep(1000);
		Actions action = new Actions(session.driver);
		action.moveToElement(element("PatientName")).click().build().perform();

		WebDriverWait wait = new WebDriverWait(session.driver, 40);
		WebElement status = wait.until(ExpectedConditions.visibilityOf(element("PatientPageVerify")));
		return status.isDisplayed();
	}

	public boolean verify_FormSUnderPatientPage() throws InterruptedException {
		boolean status = false;
		((JavascriptExecutor) session.driver).executeScript("arguments[0].scrollIntoView();", element("ScrollToForms"));
		Thread.sleep(1000);

		return status;
	}
	
	public boolean click_LogoutButton11() throws InterruptedException {
		boolean status = false;

		element("SeedDctr_Admin").click();
		Thread.sleep(2000);
		if (element("Logout1").isDisplayed()) {
			element("Logout1").click();
			status = true;
		} else {
			status = false;
		}

		return status;
	}

}
