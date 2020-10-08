package com.studio.stepdefinitions;

import org.junit.Assert;

import com.studio.utils.PropFileHandler;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DoctorStaffAdminStepDef extends StepDefinitionInit {

	@When("^I enter \"([^\"]*)\" in Email2 field$")
	public void i_enter_something_in_email2_field(String email) throws Throwable {
		doctorStaffAdminPO.enter_Email(email);
	}

	@When("^I enter \"([^\"]*)\" in Password2 field$")
	public void i_enter_something_in_password2_field(String password) throws Throwable {
		doctorStaffAdminPO.enter_Password(password);
	}

	@When("^I search \"([^\"]*)\" in Patient List$")
	public void i_search_something_in_patient_list(String patient) throws Throwable {
		doctorStaffAdminPO.search_Patients(patient);
	}

	@Then("^I verify that i navigate to Dashboard12$")
	public void i_verify_that_i_navigate_to_dashboard12() throws Throwable {
		Assert.assertTrue(doctorStaffAdminPO.verify_FieldOnPage3("SearchPatient"));
	}

	@And("^I verify that I navigated to Login Page of Doctor2$")
	public void i_verify_that_i_navigated_to_login_page_of_doctor2() throws Throwable {
		Assert.assertTrue(doctorStaffAdminPO.verify_FieldOnPage3("ForgotPassword"));
	}

	@And("^I click on Login button111$")
	public void i_click_on_login_button111() throws Throwable {
		Assert.assertTrue(doctorStaffAdminPO.click_Loginbtn());
	}

	@And("^I click on the selected patient Form and verify FormList Page opens$")
	public void i_click_on_the_selected_patient_form_and_verify_formlist_page_opens() throws Throwable {
		String FullName=PropFileHandler.readProperty("FullName");
    	Assert.assertTrue(doctorStaffAdminPO.click_SubmittedFormBtn(FullName));
	}
	
    @And("^I verify that only \"([^\"]*)\" patient list is displayed$")
    public void i_verify_that_only_something_patient_list_is_displayed(String patient) throws Throwable {
    	Assert.assertTrue(doctorStaffAdminPO.verify_PatientListName(patient));
    }

}
