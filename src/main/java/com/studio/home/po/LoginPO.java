package com.studio.home.po;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.studio.helper.*;
import com.studio.automation.framework.TestSession;
import com.studio.qe.automation.framework.pagefactory.MobileWebViewPage;
import com.studio.utils.PropFileHandler;

public class LoginPO extends MobileWebViewPage {

	public LoginPO(TestSession session) throws Exception {
		super(session, "Applications/studio/Login");
	}
	
	/**
	 * Used to verify Fields on any Page
	 * @param element
	 * @return
	 */

	public boolean verify_FieldsOnLoginPage(String element) {
		WebDriverWait wait = new WebDriverWait(session.driver, 20);

		WebElement status = wait.until(ExpectedConditions.visibilityOf(element(element)));
		return status.isDisplayed();
	}

	/**
	 * Used to verify whether any webelement is disable or not
	 * 
	 * @param element
	 * @return
	 */

	public boolean verify_EnterInFieldsOnLoginPage(String element) {
		boolean status = false;

		if (element(element).isDisplayed()) {
			element(element).sendKeys("abcd");
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	/**
	 *  Used to verify Login button disable
	 * @return
	 */
	
	public boolean verify_LoginButtonDisable() {
		boolean status = false;

		if (element("LoginButton").isEnabled()) {
			status = false;
		} else {
			status = true;
		}
		return status;
	}
	
	/**
	 *  Used to Enter in Email field
	 * @param email
	 */

	public void enter_Email(String email) {
		element("Email_Field").sendKeys(email);
	}

	/**
	 *  Used to verify error message on Login page
	 * @return
	 */
	
	public boolean verify_errorForEmail() {
		boolean status = false;
		String text = element("EmailErrorMsg").getText();
		System.out.println(element("EmailErrorMsg").getText());

		if (text.contains("Please include an '@' in the email address")) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}
	
	/**
	 *  Used to enter password
	 * @param Password
	 */

	public void enter_Password(String Password) {
		element("Password").sendKeys(Password);
	}
	
	/**
	 *  Used to verify Login buton Enable
	 * @return
	 */

	public boolean verify_LoginButtonEnable() {
		boolean status = false;

		if (element("LoginButton").isEnabled()) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}
	
	/**
	 *  Used to click on Login button
	 * @return
	 */

	public boolean click_LoginButton() {
		boolean status = false;

		if (element("LoginButton").isEnabled()) {
			element("LoginButton").click();
			status = true;
		} else {
			status = false;
		}
		return status;
	}
	
	/**
	 * Used to verify error message on login page after entering Invalid credentials
	 * @return
	 */

	public boolean verifyLoginWithInvalidCredentials() {
		WebDriverWait wait = new WebDriverWait(session.driver, 20);

		WebElement status = wait.until(ExpectedConditions.visibilityOf(element("ErrorMsg")));
		return status.isDisplayed();
	}
	
	/**
	 *  Used to click on forgot password button
	 */

	public void click_ForgotLink() {
		element("ForgotPassword").click();
	}
	
	/**
	 *  Used to click on Back to login button
	 */

	public void click_BackToLogin() {
		Actions action = new Actions(session.driver);
		action.moveToElement(element("BackToLogin")).click().build().perform();
	}
	
	/**
	 *  Used to verify error message dissappears on login page when switch back to login page from password screen
	 * @return
	 * @throws InterruptedException
	 */

	public boolean verify_ErrorOnLoginDissapears() throws InterruptedException {
		boolean status = false;
		Thread.sleep(2000);
		if (element("ErrorMsg").isDisplayed()) {
			status = false;
		} else {
			status = true;
		}
		return status;
	}

	/**
	 *  Used to verify Successful login
	 * @return
	 */
	
	public boolean verify_dashboard() {
		WebDriverWait wait = new WebDriverWait(session.driver, 30);

		WebElement status = wait.until(ExpectedConditions.visibilityOf(element("SendFormButton")));
		return status.isDisplayed();
	}
	
	/**
	 *  Used to click Logout button
	 * @return
	 */
	
	 public boolean click_LogoutButton1() throws InterruptedException {
	    	boolean status=false;
	    	Actions action=new Actions(session.driver);
	    	action.moveToElement(element("SeedDctrAdmin")).click().build().perform();	
	    	Thread.sleep(2000);
	    	if(element("Logout").isDisplayed()) {
	    		element("Logout").click();
	    	    status=true;
	    	}else {
	    		status=false;
	    	}
	    	
	    	return status;
	    }

}
