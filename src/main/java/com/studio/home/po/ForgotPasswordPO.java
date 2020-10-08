package com.studio.home.po;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.studio.automation.framework.TestSession;
import com.studio.helper.GMailDoctorReset;
import com.studio.qe.automation.framework.pagefactory.MobileWebViewPage;

public class ForgotPasswordPO extends MobileWebViewPage{

	public ForgotPasswordPO(TestSession session) throws Exception {
		super(session, "Applications/studio/ForgotPassword");
	}
	
	/**
	 *  Used to verify Fields on page
	 * @param element
	 * @return
	 */
	
	public boolean verify_FieldOnPage(String element) {
		//session.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(session.driver, 30);
		
		WebElement status=wait.until(ExpectedConditions.visibilityOf(element(element)));
		return status.isDisplayed();
	}
	
	/**
	 *  Used to click on Forgot Password link
	 */
	
	public void click_ForgotPasswordLink() {
		element("Forgot_Password").click();
	}
	
	/**
	 *  Used to press browser back button
	 */
	
	public void browser_Back() {
		session.driver.navigate().back();
	}
	
	/**
	 *  used to click on Back to Login button
	 */
	
	public void click_BackTo_Login() {
		Actions action =new Actions(session.driver);
		action.moveToElement(element("BackTo_Login")).click().build().perform();
	}
	
	/**
	 *  Used to verify Send Button disable
	 * @return
	 */

	public boolean verify_SendButtonDisable() {
		boolean status=false;
		
		if(element("SendPassword").isEnabled()) {
			status=false;
		}else {
			status=true;
		}
		
		return status;
	}
	
	/**
	 *  Used to enter on Email field
	 * @param email
	 */
	
	public void enter_Email(String email) {
		element("EmailField_Forgot").sendKeys(email);
	}
	
	/**
	 *  Used to verify Send Button Enable
	 * @return
	 */
	
	public boolean verify_SendPasswordEnable() {
		boolean status=false;
		
		if(element("SendPassword").isEnabled()) {
			status=true;
		}else {
			status=false;
		}
		
		return status;
	}
	
	/** 
	 * Used to verify Send password button is clickable for first time or not
	 * @return
	 * @throws InterruptedException
	 */
	
	public boolean verify_SendPasswordClickable() throws InterruptedException {
        boolean status=false;
		Thread.sleep(2000);
		Actions action =new Actions(session.driver);
		action.moveToElement(element("SendPassword")).click().build().perform();
		if(element("BackTo_Login").isDisplayed()) {
			status=false;
		}else {
			status=true;
		}
		
		return status;
	}

	/** 
	 * Used to click on Send password button
	 * @throws InterruptedException
	 */
	
	public void click_SendPassword() throws InterruptedException {
 		Thread.sleep(2000);			 		
 		Actions action =new Actions(session.driver);
 		action.moveToElement(element("SendPassword")).click().build().perform();
        action.moveToElement(element("SendPassword")).click().build().perform();
		 Thread.sleep(2000);		 
	}
	
	/** 
	 * Used to verify Error message for non-registered Email
	 * @return
	 */
	
	public boolean verify_ErrorForNonRegisteredMsg(){
		boolean status=false;
		
		if(element("MsgForNonReg").isDisplayed()) {
			status=true;
		}else {
			status=false;
		}
		
		return status;
	}
	
	/** 
	 * Used to verify Mail for reset code is generated
	 * @return
	 */
	
	public boolean verify_EmailForResetCode() {
		HashMap<String, String> hm = GMailDoctorReset.getGmailData("Your patient portal password reset code");
		boolean exist = GMailDoctorReset.isMailExist("Your patient portal password reset code");
		return exist;
	}
	
	/** 
	 * Used to verify Mailbody for reset code
	 * @return
	 */
	
	public boolean verify_MailBody() {
		boolean status=false;
		HashMap<String, String> hm = GMailDoctorReset.getGmailData("Your patient portal password reset code");
		String body=hm.get("body");
		
		if(body.contains("Your password reset code is")) {
			status=true;
		}else {
			status=false;
		}
		return status;
	}
	
	/** 
	 * Used to verify Fields on Reset screen
	 * @return
	 */
	
	public boolean verifyFieldOnResetScreen() {
		boolean status=false;
		
		if(element("EmailField_Forgot").isDisplayed() && element("ResetCodeField").isDisplayed() && element("NewPasswordField").isDisplayed()) {
			status=true;
		}else {
			status=false;
		}
		
		return status;
	}
	
	/** 
	 * Used to verify Whether Email is editable or not
	 * @return
	 */
	
	public boolean verify_EmailFieldEditable() {
		boolean status=false;
		
		String Email1=element("EmailField_Forgot").getAttribute("value");
		element("EmailField_Forgot").clear();
		String Email2=element("EmailField_Forgot").getAttribute("value");
		
		if(Email1.equals(Email2)) {
			status=true;
		}else {
			status=false;
		}
		
		return status;
	}
	
	/** 
	 * Used to Enter reset code
	 * @return
	 */
	
	public void enter_ResetCode(String email) {
		element("ResetCodeField").sendKeys(email);
	}
	
	/** 
	 * Used to enter New Password
	 * @return
	 */
	
    public void enter_NewPassword(String password) {
    	element("NewPasswordField").sendKeys(password);
	}
    
    /** 
	 * Used to verify Whether reset password button is disable or not
	 * @return
     * @throws InterruptedException 
	 */
    
    public boolean verify_ResetButtonDisable() throws InterruptedException {
    	boolean status=false;
    	Thread.sleep(2000);
    	if(element("ResetButton").isEnabled()) {
    		status=false;
    	}else {
    		status=true;
    	}    	
    	return status;
    }
    
    /** 
	 * Used to verify Whether reset password button is Enable or not
	 * @return
	 */
    
    public boolean verify_ResetButtonEnable() {
    	boolean status=false;
    	
    	if(element("ResetButton").isEnabled()) {
    		status=true;
    	}else {
    		status=false;
    	}    	
    	return status;
    }
    
    /**
     *  Used to click on Reset button
     * @return
     */
    
    public boolean click_ResetButton() {
    	boolean status=false;
    	Actions action =new Actions(session.driver);
 			
    	if(element("ResetButton").isEnabled()) {
    		action.moveToElement(element("ResetButton")).click().build().perform();
    		status=true;
    	}else {
    		status=false;
    	}    	
    	return status;
    }
    
    /**
     *  Used to verify error message on reset screen
     * @return
     */
    
    public boolean verify_ErrorMsgOnResetScreen() {
    	boolean status=false;
    	
    	if(element("ErrorMsgOnReset").isDisplayed()) {
    		status=true;
    	}else {
    		status=false;
    	}    	
    	return status;
    }
    
    /**
     *  Used to verify reset code field accept alphabets or not
     * @return
     */
	
    public boolean verify_ResetFieldAcceptAlphabets() {
    	boolean status=false;
    	
    	element("ResetCodeField").sendKeys("abcd1234");
    	
    	if(element("ResetCodeField").getAttribute("value").equals("abcd1234")) {
    		status=false;
    	}else {
    		status=true;
    	}
    	
    	return status;
    }
    
    /**
     *  Used to Enter Reset code from mail
     * @return
     */
    
    public void enter_ResetFromMail() {
    	HashMap<String, String> hm = GMailDoctorReset.getGmailData("Your patient portal password reset code");
    	String code=hm.get("body").replaceAll("\\D", "");
    	element("ResetCodeField").sendKeys(code);
    }
    
    /**
     *  Used to verify whether getting mail more than once in a day
     * @return
     */
    
    public boolean verify_ResetMailMoreThanOnce() throws InterruptedException{
    	boolean status=false;
    	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	element("Forgot_Password").click();
    	element("EmailField_Forgot").sendKeys("Test.doctordummy@gmail.com");
    	Thread.sleep(2000);			 		
 		Actions action =new Actions(session.driver);
 		action.moveToElement(element("SendPassword")).click().build().perform();
        action.moveToElement(element("SendPassword")).click().build().perform();
		Thread.sleep(30000);
		HashMap<String, String> hm1 = GMailDoctorReset.getGmailData("Your patient portal password reset code");
    	String code1=hm1.get("body").replaceAll("\\D", "");
    	System.out.println("reset code before:" +code1);
    	
    	Thread.sleep(2000);
    	session.driver.navigate().refresh();
    	Thread.sleep(2000);
    	
    	element("Forgot_Password").click();
    	element("EmailField_Forgot").sendKeys("Test.doctordummy@gmail.com");
    	Thread.sleep(2000);			 		
 		Actions action1 =new Actions(session.driver);
 		action1.moveToElement(element("SendPassword")).click().build().perform();
        action1.moveToElement(element("SendPassword")).click().build().perform();
		Thread.sleep(30000);
		HashMap<String, String> hm2 = GMailDoctorReset.getGmailData("Your patient portal password reset code");
    	String code2=hm2.get("body").replaceAll("\\D", "");
    	System.out.println("reset code after:" +code2);
    	
    	if(code1.equals(code2)) {
    		status=false;
    	}else {
    		status=true;
    	}   	
    	return status;    	
    }
    
    /**
     *  Used to enter in email field under login page
     * @return
     */
    
    public void enter_EmailinField(String email) {
    	element("EmailAddressField").sendKeys(email);
    }
    
    /**
     *  Used to enter in password field under login page
     * @return
     */
    
    public void enter_PasswordinField(String password){
    	element("PasswordField1").sendKeys(password);
    }
    
    /**
     *  Used to click on login button on login page
     * @return
     */
    
    public boolean click_LoginBtn() {
    	boolean status=false;
    	
    	if(element("LoginBtn").isEnabled()) {
    		element("LoginBtn").click();
    		status=true;
    	}else {
    		status=false;
    	}    
    	
    	return status;
    }
    
    /**
     *  Used to verify error message for invalid login
     * @return
     */
    
    public boolean verify_errorOnInvalidLogin() {
    	boolean status=false;
    	
    	if(element("ErrorMsgOnReset").isDisplayed()) {
    		status=true;
    	}else {
    		status=false;
    	}    	
    	return status;
    }
    
    /**
     *  Used to Logout from the application of doctor
     * @return
     */
    
    public boolean click_LogoutButton() throws InterruptedException {
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
    	Thread.sleep(2000);
    	return status;
    }
	
}
