package com.studio.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.github.javafaker.Faker;
import com.studio.utils.PropFileHandler;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DoctorSendFormStepDef extends StepDefinitionInit{

	@When("^I enter \"([^\"]*)\" in Email field$")
    public void i_enter_something_in_email_field(String email) throws Throwable {
		doctorSendFormPO.enter_Email1(email);
    }

    @When("^I enter \"([^\"]*)\" in Password field$")
    public void i_enter_something_in_password_field(String Password) throws Throwable {
    	doctorSendFormPO.enter_Password1(Password);
    }

    @Then("^I verify that i navigate to Dashboard1$")
    public void i_verify_that_i_navigate_to_dashboard1() throws Throwable {
    //	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Assert.assertTrue(doctorSendFormPO.verify_FieldOnPage12("SendForm_Button1"));
    }

    @And("^I verify that I navigated to Login Page of Doctor1$")
    public void i_verify_that_i_navigated_to_login_page_of_doctor1() throws Throwable {
    //	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Assert.assertTrue(doctorSendFormPO.verify_FieldOnPage12("Forgot_Password1"));
    }

    @And("^I click on Login button11$")
    public void i_click_on_login_button11() throws Throwable {
    	 Assert.assertTrue(doctorSendFormPO.click_LoginButton1());
    }

    @And("^I Logout from the page11$")
    public void i_logout_from_the_page11() throws Throwable {
  //  	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Assert.assertTrue(doctorSendFormPO.click_LogoutButton11()); 
    }
    
    @Then("^I verify that SendForm button present on top right$")
    public void i_verify_that_sendform_button_present_on_top_right() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_FieldOnPage12("SendForm_Button1"));
    }
    
    @Then("^I verify that i am able to click on Send form button$")
    public void i_verify_that_i_am_able_to_click_on_send_form_button() throws Throwable {
  //  	session.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Assert.assertTrue(doctorSendFormPO.verify_FieldOnPage12("ResetBtn"));
    }
    
    @When("^I click on Send Form button$")
    public void i_click_on_send_form_button() throws Throwable {
    	doctorSendFormPO.click_SendFormBtn(); 
    }
    
    @Then("^I verify that Fields are present$")
    public void i_verify_that_fields_are_present() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_FormFields());
    }
    
    @Then("^I verify that AppointmentType Fields are present$")
    public void i_verify_that_appointmenttype_fields_are_present() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_FormFields12());
    }
    
    @And("^I verify that SendForm button under Invite page is disable initially$")
    public void i_verify_that_sendform_button_under_invite_page_is_disable_initially() throws Throwable {
    	Assert.assertFalse(doctorSendFormPO.verifySendFormdisable());
    }
    
    @And("^I verify that i am able to enter in First Name$")
    public void i_verify_that_i_am_able_to_enter_in_first_name() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_EnterInFirstName());
    }
    
    @And("^I verify that i am not able to enter invalid First Name$")
    public void i_verify_that_i_am_not_able_to_enter_invalid_first_name() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_InvalidEnterInFirstName());
    }
    
    @And("^I verify that i am able to enter in Last Name$")
    public void i_verify_that_i_am_able_to_enter_in_last_name() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_EnterInLastName());
    }
    
    @And("^I verify that i am not able to enter invalid Last Name$")
    public void i_verify_that_i_am_not_able_to_enter_invalid_last_name() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_InvalidEnterInLastName());
    }
    
    @And("^I verify that i am able to enter in Email$")
    public void i_verify_that_i_am_able_to_enter_in_email() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_EnterInEmail()); 
    }
    
    @And("^I verify that i get error message for invalid Email$")
    public void i_verify_that_i_get_error_message_for_invalid_email() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_InvalidEnterInEmail());
    }
    
    @And("^I verify that i am able to enter valid DOB$")
    public void i_verify_that_i_am_able_to_enter_valid_dob() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_EnterDOB("11/12/1992"));
    }
    
    @And("^I verify that i am not able to enter FutureDate_FutureMonth_SameYear in DOB$")
    public void i_verify_that_i_am_not_able_to_enter_futuredatefuturemonthsameyear_in_dob() throws Throwable {
        String DOB=PropFileHandler.readProperty("DOB_FD_FM_SY");
        Assert.assertTrue(doctorSendFormPO.verify_EnterInvalidDOB(DOB));
    }
    
    @And("^I verify that i am not able to enter FutureDate_FutureMonth_FutureYear in DOB$")
    public void i_verify_that_i_am_not_able_to_enter_futuredatefuturemonthfutureyear_in_dob() throws Throwable {
        String DOB=PropFileHandler.readProperty("DOB_FD_FM_FY");
        Assert.assertTrue(doctorSendFormPO.verify_EnterInvalidDOB(DOB));
    }
    
    @And("^I verify that i am not able to enter FutureDate_CurrentMonth_CurrentYear in DOB$")
    public void i_verify_that_i_am_not_able_to_enter_futuredatecurrentmonthcurrentyear_in_dob() throws Throwable {
        String DOB=PropFileHandler.readProperty("DOB_FD_SM_SY");
        Assert.assertTrue(doctorSendFormPO.verify_EnterInvalidDOB(DOB));
    }
    
    @And("^I verify that i am able to enter in phone number$")
    public void i_verify_that_i_am_able_to_enter_in_phone_number() throws Throwable {
        String Phone=PropFileHandler.readProperty("PhoneNum1");
        Assert.assertTrue(doctorSendFormPO.verify_EnterPhoneNum(Phone));
    }
    
    @And("^I verify that i am getting error message for invalid phone number$")
    public void i_verify_that_i_am_getting_error_message_for_invalid_phone_number() throws Throwable {
    	 String Phone=PropFileHandler.readProperty("PhoneNum");
         Assert.assertTrue(doctorSendFormPO.verify_EnterInvalidPhoneNum(Phone));
    }
    
    @And("^I verify that i am able to select Form$")
    public void i_verify_that_i_am_able_to_select_form() throws Throwable {
    	 Assert.assertTrue(doctorSendFormPO.verify_SelectForm());
    }
    
    @And("^I verify that i am able to select Appointment Type$")
    public void i_verify_that_i_am_able_to_select_appointment_type() throws Throwable {
    	 Assert.assertTrue(doctorSendFormPO.verify_SelectAppointmentType());
    }
    

    @And("^I verify that i am able to select Doctor$")
    public void i_verify_that_i_am_able_to_select_doctor() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_SelectDoctor());
    }
    
    @And("^I verify that i am able to enter Appointment date$")
    public void i_verify_that_i_am_able_to_enter_appointment_date() throws Throwable {
    	String AppDate=PropFileHandler.readProperty("AppDate");
    	Assert.assertTrue(doctorSendFormPO.verify_EnterAppointmentDate(AppDate));
    }
    
    @And("^I verify that i am not able to enter Past Appointment date$")
    public void i_verify_that_i_am_not_able_to_enter_past_appointment_date() throws Throwable {
    	String AppDatePast=PropFileHandler.readProperty("AppDatePast");
    	Assert.assertTrue(doctorSendFormPO.verify_EnterInvalidAppointmentDate(AppDatePast));
    }

    @And("^I verify that i am able to enter in time$")
    public void i_verify_that_i_am_able_to_enter_in_time() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_EnterInTime());
    }
    
    @When("^I enter in FirstName,LastName,Email and Choose Form$")
    public void i_enter_in_firstnamelastnameemail_and_choose_form() throws Throwable {
    	String FirstName=PropFileHandler.readProperty("FirstName1");
    	String LastName=PropFileHandler.readProperty("LastName1");
    	String Email1=PropFileHandler.readProperty("Email1");
    	doctorSendFormPO.enter_FirstNameLstNameEmailChooseForm(FirstName, LastName, Email1); 
    }

    @Then("^I verify that Send form button is Enabled$")
    public void i_verify_that_send_form_button_is_enabled() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verifySendFormEnable());
    }
    
    @When("^I enter in Appointment Date and Appointment Time$")
    public void i_enter_in_appointment_date_and_appointment_time() throws Throwable {
    	String AppointDate=PropFileHandler.readProperty("AppointDate");
    	String AppointTime=PropFileHandler.readProperty("AppointTime");
    	doctorSendFormPO.verify_EnterAppointmentDateTime(AppointDate, AppointTime);
    }
    
    @When("^I enter PhoneNumber, select AppointmentType and Doctor$")
    public void i_enter_phonenumber_select_appointmenttype_and_doctor() throws Throwable {
    	doctorSendFormPO.enter_PhoneAppointTypeTime();
    }

    @And("^I verify that click on Reset button clear all field values$")
    public void i_verify_that_click_on_reset_button_clear_all_field_values() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_FieldsClearOnResetClick());
    }
    
    @And("^I verify that I am able to click on SendForm button$")
    public void i_verify_that_i_am_able_to_click_on_sendform_button() throws Throwable {
        Assert.assertTrue(doctorSendFormPO.click_SendFormBtn1());
    }
    
    @And("^I verify that I receive mail for form under registered user$")
    public void i_verify_that_i_receive_mail_for_form_under_registered_user() throws Throwable {
    	Thread.sleep(30000);
    	Assert.assertTrue(doctorSendFormPO.verify_MailForRegisteredUser());
    }
    
    @And("^I verify that I receive PatientURL under mail for form under registered user$")
    public void i_verify_that_i_receive_patienturl_under_mail_for_form_under_registered_user() throws Throwable {
    //	Thread.sleep(40000);
    	Assert.assertTrue(doctorSendFormPO.verify_URLUnderMailBody());
    }
    
    @And("^I verify that patient name is displayed under mail body$")
    public void i_verify_that_patient_name_is_displayed_under_mail_body() throws Throwable {
    	String FirstName=PropFileHandler.readProperty("FirstName1");
    	Assert.assertTrue(doctorSendFormPO.verify_FirstNameUnderMailBody(FirstName));
    }
    
    @And("^I verify that mail body contain text for ExistingUSer_withoutAppointmentDate$")
    public void i_verify_that_mail_body_contain_text_for_existinguserwithoutappointmentdate() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_MailBodyTextForRegisteredUser());
    }
    
    @And("^I verify that I receive mail for form under registered user for AppointmentType$")
    public void i_verify_that_i_receive_mail_for_form_under_registered_user_for_appointmenttype() throws Throwable {
    	Thread.sleep(30000);
    	Assert.assertTrue(doctorSendFormPO.verify_MailForRegisteredUserAppointType());
    }
    
    @And("^I verify that I receive PatientURL under mail for form under registered user AppointDate$")
    public void i_verify_that_i_receive_patienturl_under_mail_for_form_under_registered_user_appointdate() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_URLUnderMailBody1());
    }

    @And("^I verify that patient name is displayed under mail body of Existing user Appointment Type$")
    public void i_verify_that_patient_name_is_displayed_under_mail_body_of_existing_user_appointment_type() throws Throwable {
    	String FirstName1=PropFileHandler.readProperty("FirstName1");
    	Assert.assertTrue(doctorSendFormPO.verify_FirstNameUnderMailBody1(FirstName1));
    }

    @And("^I verify that practice name is displayed under mail body of Existing user Appointment Type$")
    public void i_verify_that_practice_name_is_displayed_under_mail_body_of_existing_user_appointment_type() throws Throwable {
    	Assert.assertTrue(doctorSendFormPO.verify_PracticeNameUnderMailBody());
    }
    
    @When("^I enter in FirstName1,LastName1, Email1 and ChooseForm1$")
    public void i_enter_in_firstname1lastname1_email1_and_chooseform1() throws Throwable {
    	Faker faker = new Faker();
		String firstName = faker.name().firstName();
		PropFileHandler.writeToFile("FirstName_NewProfile", firstName);
		String lastName = faker.name().lastName();
    	String Email1=PropFileHandler.readProperty("Email1");
    	doctorSendFormPO.enter_FirstNameLstNameEmailChooseForm(firstName, lastName, Email1); 
    }
    
    @And("^I verify that I receive mail for form under registered user for new profile$")
    public void i_verify_that_i_receive_mail_for_form_under_registered_user_for_new_profile() throws Throwable {
    	Thread.sleep(30000);
    	String FirstName1=PropFileHandler.readProperty("FirstName_NewProfile");
    	Assert.assertTrue(doctorSendFormPO.verify_MailForRegisteredUserNewProfile(FirstName1));
    }
    
    @And("^I verify that I receive PatientURL under mail for form under registered user New Profile$")
    public void i_verify_that_i_receive_patienturl_under_mail_for_form_under_registered_user_new_profile() throws Throwable {
    	String FirstName1=PropFileHandler.readProperty("FirstName_NewProfile");
    	Assert.assertTrue(doctorSendFormPO.verify_URLUnderMailBodyNewProfile(FirstName1));
    }
    
    @And("^I verify that mail body contain text for NewProfile_withoutAppointmentDate$")
    public void i_verify_that_mail_body_contain_text_for_newprofilewithoutappointmentdate() throws Throwable {
    	String FirstName1=PropFileHandler.readProperty("FirstName_NewProfile");
    	Assert.assertTrue(doctorSendFormPO.verify_MailbodyTextForRegisteredUserNewProfile(FirstName1));
    }
    
    @When("^I enter in FirstName2,LastName2, Email and ChooseForm$")
    public void i_enter_in_firstname2lastname2_email_and_chooseform() throws Throwable {
    	Faker faker = new Faker();
		String firstName = faker.name().firstName();
		PropFileHandler.writeToFile("FirstName_NewProfile_Appoint", firstName);
		String lastName = faker.name().lastName();
    	String Email1=PropFileHandler.readProperty("Email1");
    	doctorSendFormPO.enter_FirstNameLstNameEmailChooseForm(firstName, lastName, Email1); 
    }
    
    @And("^I verify that I receive mail for form under registered user for new profile AppointmentType$")
    public void i_verify_that_i_receive_mail_for_form_under_registered_user_for_new_profile_appointmenttype() throws Throwable {
    	Thread.sleep(30000);
    	String FirstName2=PropFileHandler.readProperty("FirstName_NewProfile_Appoint");
    	Assert.assertTrue(doctorSendFormPO.verify_MailForRegisteredUserNewProfileAppoint(FirstName2));
    }
    
    @And("^I verify that I receive PatientURL under mail for form under registered user New Profile Appoint$")
    public void i_verify_that_i_receive_patienturl_under_mail_for_form_under_registered_user_new_profile_appoint() throws Throwable {
    	String FirstName2=PropFileHandler.readProperty("FirstName_NewProfile_Appoint");
    	Assert.assertTrue(doctorSendFormPO.verify_URLUnderMailBodyNewProfileAppoint(FirstName2));
    }
    
    @And("^I verify that I Practice name is displayed for New Profile Appoint$")
    public void i_verify_that_i_practice_name_is_displayed_for_new_profile_appoint() throws Throwable {
    	String FirstName2=PropFileHandler.readProperty("FirstName_NewProfile_Appoint");
    	Assert.assertTrue(doctorSendFormPO.verify_PracticeNameUnderMailBody1(FirstName2));
    }
}
