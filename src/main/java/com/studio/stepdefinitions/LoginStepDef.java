package com.studio.stepdefinitions;

import org.junit.Assert;

import com.studio.stepdefinitions.StepDefinitionInit;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef extends StepDefinitionInit{

	@And("^I verify that I navigated to Login Page$")
    public void i_verify_that_i_navigated_to_login_page() throws Throwable {
        Assert.assertTrue(loginPO.verify_FieldsOnLoginPage("ForgotPassword"));
    }
	
	@Then("^I verify that Email Field is present$")
    public void i_verify_that_email_field_is_present() throws Throwable {
		 Assert.assertTrue(loginPO.verify_FieldsOnLoginPage("Email_Field"));
    }
	
    @Then("^I verify that Password Field is present$")
	public void i_verify_that_password_field_is_present() throws Throwable {
		 Assert.assertTrue(loginPO.verify_FieldsOnLoginPage("Password"));   
	}
	 
	@Then("^I verify That I am able to enter in Email field$")
	public void i_verify_that_i_am_able_to_enter_in_email_field() throws Throwable {
		Assert.assertTrue(loginPO.verify_EnterInFieldsOnLoginPage("Email_Field"));   
	}

	@Then("^I verify That I am able to enter in Password field$")
	public void i_verify_that_i_am_able_to_enter_in_password_field() throws Throwable {
		Assert.assertTrue(loginPO.verify_EnterInFieldsOnLoginPage("Password"));
	}
	
	@Then("^I verify that Forgot Password Link Is Present$")
    public void i_verify_that_forgot_password_link_is_present() throws Throwable {
		Assert.assertTrue(loginPO.verify_FieldsOnLoginPage("ForgotPassword"));
    }
	
	@Then("^I verify That Login button is disabled$")
    public void i_verify_that_login_button_is_disabled() throws Throwable {
		Assert.assertTrue(loginPO.verify_LoginButtonDisable());
    }
	
	@When("^I enter \"([^\"]*)\" in Email fields$")
    public void i_enter_something_in_email_fields(String email) throws Throwable {
		loginPO.enter_Email(email);
    }

    @Then("^I verify that I get validation error message below Email field$")
    public void i_verify_that_i_get_validation_error_message_below_email_field() throws Throwable {
    	Assert.assertTrue(loginPO.verify_errorForEmail());
    }
    
    @When("^I enter \"([^\"]*)\" in Password fields$")
    public void i_enter_something_in_password_fields(String Password) throws Throwable {
    	loginPO.enter_Password(Password);
    }
    
    @Then("^I verify that Login button is Enabled$")
    public void i_verify_that_login_button_is_enabled() throws Throwable {
    	Assert.assertTrue(loginPO.verify_LoginButtonEnable());
    }
    
    @Then("^I verify that with invalid credentials I am unable to Login$")
    public void i_verify_that_with_invalid_credentials_i_am_unable_to_login() throws Throwable {
    	Assert.assertTrue(loginPO.verifyLoginWithInvalidCredentials());
    }

    @And("^I click on Login button$")
    public void i_click_on_login_button() throws Throwable {
    	Assert.assertTrue(loginPO.click_LoginButton());
    }
    
    @When("^I Click on Forgot password link$")
    public void i_click_on_forgot_password_link() throws Throwable {
    	loginPO.click_ForgotLink();
    }

    @When("^I Click on BackToLogin button$")
    public void i_click_on_backtologin_button() throws Throwable {
    	Thread.sleep(1000);
    	loginPO.click_BackToLogin();
    }

    @Then("^I verify that Error msg dissapears$")
    public void i_verify_that_error_msg_dissapears() throws Throwable {
    	Assert.assertTrue(loginPO.verify_ErrorOnLoginDissapears()); 
    }
    
    @Then("^I verify that Error msg appears$")
    public void i_verify_that_Error_msg_appears() throws Throwable {
    	Assert.assertTrue(loginPO.verifyLoginWithInvalidCredentials());
    }
    
    @Then("^I verify that i navigate to Dashboard$")
    public void i_verify_that_i_navigate_to_dashboard() throws Throwable {
    	Assert.assertTrue(loginPO.verify_dashboard());
    }
    
    @And("^I Logout from the page1$")
    public void i_logout_from_the_page1() throws Throwable {
    	Assert.assertTrue(loginPO.click_LogoutButton1());
    }

}
