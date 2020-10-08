package com.studio.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.studio.utils.PropFileHandler;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FormDisableStepDef extends StepDefinitionInit {

	@Then("^I verify that i am able to Login to Doctor page$")
	public void i_verify_that_i_am_able_to_login_to_doctor_page() throws Throwable {
		Assert.assertTrue(formDisablePO.verify_FieldOnPage("SendFormButton"));
	}

	@And("^I verify that Doctor Login1 Page1 Opens$")
	public void i_verify_that_doctor_login1_page1_opens() throws Throwable {
		Assert.assertTrue(formDisablePO.verify_FieldOnPage("ForgotPassword"));
	}

	@And("^I verify that i am able to send Form to Patient$")
	public void i_verify_that_i_am_able_to_send_form_to_patient() throws Throwable {
		Assert.assertTrue(formDisablePO.click_SendFormBtn1());
	}
	
	@When("^I enter Login Credentials$")
    public void i_enter_login_credentials() throws Throwable {
		formDisablePO.login_ToApplication(); 
    }
	
    @When("^I enter submit the form to existing user$")
    public void i_enter_submit_the_form_to_existing_user() throws Throwable {
    	formDisablePO.enter_FirstNameLstNameEmailChooseForm();
    }
    
    @When("^I switch to second Tab and enter Admin URL$")
    public void i_switch_to_second_tab_and_enter_admin_url() throws Throwable {
    	Thread.sleep(2000);
    	String AdminURL=PropFileHandler.readProperty("URL_Admin");
    	Assert.assertTrue(formDisablePO.switch_SecondBrowserTab(AdminURL));
    }

    @And("^I open second Tab on browser$")
    public void i_open_second_tab_on_browser() throws Throwable {
    	Thread.sleep(2000);
    	Assert.assertTrue(formDisablePO.open_SecondTab());
    }

    @And("^I verify that i navigated to Admin Login Page$")
    public void i_verify_that_i_navigated_to_admin_login_page() throws Throwable {
    	session.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	Assert.assertTrue(formDisablePO.verify_FieldOnPage("Admin_UserName"));
    }
    
    @When("^I enter Username,Password and click on SignUpbutton$")
    public void i_enter_usernamepassword_and_click_on_signupbutton() throws Throwable {
    	formDisablePO.login_ToAdminApplication();
    }

    @When("^I enter \"([^\"]*)\" in search field and click on Search button$")
    public void i_enter_something_in_search_field_and_click_on_search_button(String practice) throws Throwable {
    	formDisablePO.enter_AdminSearchField(practice);
    }

    @Then("^I verify that I navigated to Search page of Admin$")
    public void i_verify_that_i_navigated_to_search_page_of_admin() throws Throwable {
    	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(formDisablePO.verify_FieldOnPage("CreatePracticeBtn"));
    }
    
    @When("^I click on Form Button$")
    public void i_click_on_form_button() throws Throwable {
    	formDisablePO.click_FormBtn();
    }

    @And("^I verify that i naviagted to CustomerInfo page$")
    public void i_verify_that_i_naviagted_to_customerinfo_page() throws Throwable {
    	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(formDisablePO.verify_FieldOnPage("Form_Button"));
    }
    
    @When("^I enter \"([^\"]*)\" in Search field of Form page and I click on Form Edit button$")
    public void i_enter_something_in_search_field_of_form_page_and_I_click_on_Form_Edit_button(String formName) throws Throwable {
    	formDisablePO.search_FormInList(formName);
    }

    @And("^I verify that i navigated to Form page$")
    public void i_verify_that_i_navigated_to_form_page() throws Throwable {
    	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(formDisablePO.verify_FieldOnPage("SearchFormField"));
    }
    
    @Then("^I verify that Edit Form Popup opens$")
    public void i_verify_that_edit_form_popup_opens() throws Throwable {
    	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(formDisablePO.verify_FieldOnPage("EditPopup"));
    }
    
    @And("^I Toggle disable button and click onsave button$")
    public void i_toggle_disable_button_and_click_onsave_button() throws Throwable {
    	Thread.sleep(2000);
    	Assert.assertTrue(formDisablePO.disable_ToggleAndClickSave());
    }
    
    @And("^I Toggle Enable button and click onsave button$")
    public void i_toggle_enable_button_and_click_onsave_button() throws Throwable {
    	Thread.sleep(2000);
    	Assert.assertTrue(formDisablePO.enable_ToggleAndClickSave());
    }
    
    @Then("^I verify that Form is disabled successfully$")
    public void i_verify_that_form_is_disabled_successfully() throws Throwable {
    	Assert.assertTrue(formDisablePO.verify_FieldOnPage("DisabledForm"));
    }
    
    @And("^I close the current Browser Tab$")
    public void i_close_the_current_browser_tab() throws Throwable {
    	Assert.assertTrue(formDisablePO.close_BrowserTab());
    }
    
    @When("^I click on Send form button on Dashboard$")
    public void i_click_on_send_form_button_on_dashboard() throws Throwable {
    	formDisablePO.click_SendFormOnDashboard();
    }

    @Then("^I verify that \"([^\"]*)\" is not present in Choose a Form dropdown$")
    public void i_verify_that_something_is_not_present_in_choose_a_form_dropdown(String FormName) throws Throwable {
    	Assert.assertTrue(formDisablePO.verify_FormDisabledFromDropdown(FormName));
    }
    
    @Then("^I verify that \"([^\"]*)\" is present in Choose a Form dropdown$")
    public void i_verify_that_something_is_present_in_choose_a_form_dropdown(String FormName) throws Throwable {
    	Assert.assertTrue(formDisablePO.verify_FormEnabledFromDropdown(FormName));
    }

    @And("^I verify that Doctor Dashboard page open$")
    public void i_verify_that_doctor_dashboard_page_open() throws Throwable {
    	Assert.assertTrue(formDisablePO.verify_FieldOnPage("SendFormButton"));
    }

    @And("^I verify that I navigate to InviteAPatient screen$")
    public void i_verify_that_i_navigate_to_inviteapatient_screen() throws Throwable {
    	Assert.assertTrue(formDisablePO.verify_FieldOnPage("FirstName"));
    }
    
    @When("^I switch to second Tab and enter Patient URL$")
    public void i_switch_to_second_tab_and_enter_patient_url() throws Throwable {
    	Thread.sleep(2000);
    	String PatURL=PropFileHandler.readProperty("URL_Pat");
    	Assert.assertTrue(formDisablePO.switch_SecondBrowserTab(PatURL));
    }

    @When("^I enter Username,Password and click on Loginbutton$")
    public void i_enter_usernamepassword_and_click_on_loginbutton() throws Throwable {
    	formDisablePO.enter_PatientEmailPassword();
    }

    @Then("^I verify that I navigated to DashboardPage of Patient$")
    public void i_verify_that_i_navigated_to_dashboardpage_of_patient() throws Throwable {
    	Assert.assertTrue(formDisablePO.verify_FieldOnPage("LoginTextPat"));
    }

    @And("^I verify that i navigated to Patient Login Page$")
    public void i_verify_that_i_navigated_to_patient_login_page() throws Throwable {
    	Assert.assertTrue(formDisablePO.verify_FieldOnPage("ForgotPasswordPatient"));
    }
    
    @And("^I click on \"([^\"]*)\" from the form list$")
    public void i_click_on_something_from_the_form_list(String form1) throws Throwable {
    	Assert.assertTrue(formDisablePO.verifyAndOpen_Form(form1));
    }

    @And("^I verify that form gets opened$")
    public void i_verify_that_form_gets_opened() throws Throwable {
    	Assert.assertTrue(formDisablePO.verify_FieldOnPage("FormField"));
    }
    
    @When("^I fill the form and click on Submit$")
    public void i_fill_the_form_and_click_on_submit() throws Throwable {
    	formDisablePO.fillAndSubmit_form();
    }

    @Then("^I verify that I Received confirmation mail for successful form submit$")
    public void i_verify_that_i_received_confirmation_mail_for_successful_form_submit() throws Throwable {
    	Thread.sleep(20000);
    	Assert.assertTrue(formDisablePO.verify_MailFormSuccessfulFormSubmit());
    }
    

    @When("^I search for \"([^\"]*)\" patient$")
    public void i_search_for_something_patient(String patient) throws Throwable {
    	formDisablePO.search_PatientFromList(patient);
    }

    @Then("^I verify that Submited form from the patient gets displayed under Form tab$")
    public void i_verify_that_submited_form_from_the_patient_gets_displayed_under_form_tab() throws Throwable {
    	Assert.assertTrue(formDisablePO.verify_FormSUnderPatientPage());
    }

    @And("^I click on Patient Tab$")
    public void i_click_on_patient_tab() throws Throwable {
    	Assert.assertTrue(formDisablePO.click_PatientTab());
    }

    @And("^I click on patient name from the list$")
    public void i_click_on_patient_name_from_the_list() throws Throwable {
    	Assert.assertTrue(formDisablePO.click_PatientFromList());
    }
    
    @Then("^I verify that Form is Enabled successfully$")
    public void i_verify_that_form_is_enabled_successfully() throws Throwable {
    	Assert.assertTrue(formDisablePO.verify_FieldOnPage("EnabledForm"));
    }
    
    @When("^I enter \"([^\"]*)\" in Search field of Form page and I click on WebsiteLink button$")
    public void i_enter_something_in_search_field_of_form_page_and_i_click_on_websitelink_button(String form) throws Throwable {
    	formDisablePO.search_FormInListAndClickWebSiteLinkButton(form);
    }

    @And("^I verify that Link code gets displayed and copied to clipboard$")
    public void i_verify_that_link_code_gets_displayed_and_copied_to_clipboard() throws Throwable {
    	Assert.assertTrue(formDisablePO.verify_FieldOnPage("LinkCode"));
    }

    @And("^I open next Tab and paste the copied link and press enter$")
    public void i_open_next_tab_and_paste_the_copied_link_and_press_enter() throws Throwable {
    	Assert.assertTrue(formDisablePO.openAndSwitch_NextTab());
    }
    
    @Then("^I close all the tabs$")
    public void i_close_all_the_tabs() throws Throwable {
    	Assert.assertTrue(formDisablePO.close_SecondAndThirdBrowserTab());
    }
    
    @Then("^I verify that patient List gets updated as per searching$")
    public void i_verify_that_patient_list_gets_updated_as_per_searching() throws Throwable {
    	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	Assert.assertTrue(formDisablePO.verify_PatientSearchResult_EmailPhoneFullName());
    }
    
    @And("^I logout from the doctor dashboard portal$")
    public void i_logout_from_the_doctor_dashboard_portal() throws Throwable {
    	Assert.assertTrue(formDisablePO.click_LogoutButton11());
    }

}
