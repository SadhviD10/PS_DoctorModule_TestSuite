package com.studio.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ForgotPasswordStepDef extends StepDefinitionInit{
       
	@When("^I click On Forgot_Password$")
    public void i_click_on_forgotpassword() throws Throwable {
       forgotPasswordPO.click_ForgotPasswordLink();
    }

    @Then("^I verify That I navigated to Forgot_password Screen$")
    public void i_verify_that_i_navigated_to_forgotpassword_screen() throws Throwable {
    	//session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(forgotPasswordPO.verify_FieldOnPage("BackTo_Login"));
    }

    @And("^I verify that I navigated to Login Page of Doctor$")
    public void i_verify_that_i_navigated_to_login_page_of_doctor() throws Throwable {
    	//session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Assert.assertTrue(forgotPasswordPO.verify_FieldOnPage("Forgot_Password"));
    }
    
    @When("^I press browser back button $")
    public void i_press_browser_back_button() throws Throwable {
    	Thread.sleep(1000);
    	forgotPasswordPO.browser_Back();
    }
    
    @When("^I press back_To_Login button$")
    public void i_press_backtologin_button() throws Throwable {
    	forgotPasswordPO.click_BackTo_Login();
    }


    @And("^I verify that Email_Field is present$")
    public void i_verify_that_email_field_is_present() throws Throwable {
    	//session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(forgotPasswordPO.verify_FieldOnPage("EmailField_Forgot"));
    }

    @And("^I verify that SendPassword button is disable$")
    public void i_verify_that_sendpassword_button_is_disable() throws Throwable {
    	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertFalse(forgotPasswordPO.verify_SendButtonDisable()); 
    }
    
    @When("^I Enter \"([^\"]*)\" in Email Field$")
    public void i_enter_something_in_email_field(String email) throws Throwable {
    	forgotPasswordPO.enter_Email(email);
    }
    
    @And("^I verify that SendPassword button is Enabled$")
    public void i_verify_that_sendpassword_button_is_enabled() throws Throwable {
    	//session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(forgotPasswordPO.verify_SendPasswordEnable());
    }
    
    @Then("^I verify that Send Password button is clickable for First Time$")
    public void i_verify_that_send_password_button_is_clickable_for_first_time() throws Throwable {
    	//session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(forgotPasswordPO.verify_SendPasswordClickable());
    }
    
    @Then("^I verify that Valid message for Non-Registered user gets displayed$")
    public void i_verify_that_valid_message_for_nonregistered_user_gets_displayed() throws Throwable {
    	//session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(forgotPasswordPO.verify_ErrorForNonRegisteredMsg());
    }
    
    @When("^I click on Send Password button$")
    public void i_click_on_send_password_button() throws Throwable {
        forgotPasswordPO.click_SendPassword();
    }
    
    @And("^I verify that Doctor receives Email for reset password$")
    public void i_verify_that_doctor_receives_email_for_reset_password() throws Throwable {
    	Assert.assertTrue(forgotPasswordPO.verify_EmailForResetCode());
    }
    
    @Then("^I verify that user redirect to Reset Password screen$")
    public void i_verify_that_user_redirect_to_reset_password_screen() throws Throwable {
    	//session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(forgotPasswordPO.verify_FieldOnPage("NewPasswordField"));
    }
    
    @Then("^I verify that Mail body contains reset code$")
    public void i_verify_that_mail_body_contains_reset_code() throws Throwable {
    	Assert.assertTrue(forgotPasswordPO.verify_MailBody());
    }
    
    @And("^I verify that Email,ResetCode,NewPassword are present$")
    public void i_verify_that_emailresetcodenewpassword_are_present() throws Throwable {
    //	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(forgotPasswordPO.verifyFieldOnResetScreen());
    }
    
    @And("^I verify that i am not able to Edit Edit under Email field$")
    public void i_verify_that_i_am_not_able_to_edit_edit_under_email_field() throws Throwable {
       Assert.assertTrue(forgotPasswordPO.verify_EmailFieldEditable());
    }
    
    @When("^I enter \"([^\"]*)\" in Reset Code Field$")
    public void i_enter_something_in_reset_code_field(String email) throws Throwable {
    	forgotPasswordPO.enter_ResetCode(email);
    }

    @Then("^I verify that Reset Password button is Disable$")
    public void i_verify_that_reset_password_button_is_disable() throws Throwable {
    	 Assert.assertFalse(forgotPasswordPO.verify_ResetButtonDisable());
    }
    
    @When("^I enter \"([^\"]*)\" in New Password Field$")
    public void i_enter_something_in_new_password_field(String password) throws Throwable {
        forgotPasswordPO.enter_NewPassword(password);
    }
    
    @And("^I verify that Reset Password button is Enabled$")
    public void i_verify_that_reset_password_button_is_enabled() throws Throwable {
        Assert.assertTrue(forgotPasswordPO.verify_ResetButtonEnable());
    }
    
    @Then("^I verif that i get error message for invalid reset code$")
    public void i_verif_that_i_get_error_message_for_invalid_reset_code() throws Throwable {
    //	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(forgotPasswordPO.verify_ErrorMsgOnResetScreen());
    }

    @And("^I click on Reset button$")
    public void i_click_on_reset_button() throws Throwable {
    	Assert.assertTrue(forgotPasswordPO.click_ResetButton());
    }
    
    @And("^I verify that reset code field doesnot accepts Alphanumeric$")
    public void i_verify_that_reset_code_field_doesnot_accepts_alphanumeric() throws Throwable {
    	Assert.assertTrue(forgotPasswordPO.verify_ResetFieldAcceptAlphabets());
    }
    
    @When("^I enter in Reset Code Field$")
    public void i_enter_in_reset_code_field() throws Throwable {
    	Thread.sleep(30000);
    	forgotPasswordPO.enter_ResetFromMail();
    }
    
    @Then("^I verify that I get mail more than once$")
    public void i_verify_that_i_get_mail_more_than_once() throws Throwable {
    	Assert.assertTrue(forgotPasswordPO.verify_ResetMailMoreThanOnce());
    }
    
    @When("^I Enter \"([^\"]*)\" in email$")
    public void i_enter_something_in_email(String email) throws Throwable {
    	forgotPasswordPO.enter_EmailinField(email);
    }

    @When("^I Enter \"([^\"]*)\" in Password$")
    public void i_enter_something_in_password(String password) throws Throwable {
    	forgotPasswordPO.enter_PasswordinField(password);
    }

    @Then("^I verify that i am not able to login with previous credentials$")
    public void i_verify_that_i_am_not_able_to_login_with_previous_credentials() throws Throwable {
    //	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(forgotPasswordPO.verify_errorOnInvalidLogin());
    }

    @And("^I click on Login button1$")
    public void i_click_on_login_button1() throws Throwable {
    	Assert.assertTrue(forgotPasswordPO.click_LoginBtn());
    }

    @Then("^I verify that I navigated to Dashboard$")
    public void i_verify_that_i_navigated_to_dashboard() throws Throwable {
    	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(forgotPasswordPO.verify_FieldOnPage("SendFormButton1")); 
    }
    
    @And("^I Logout from the page$")
    public void i_logout_from_the_page() throws Throwable {
    	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Thread.sleep(3000);
    	Assert.assertTrue(forgotPasswordPO.click_LogoutButton());
    }

}
