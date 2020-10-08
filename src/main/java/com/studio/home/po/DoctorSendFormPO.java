package com.studio.home.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.studio.automation.framework.TestSession;
//import com.studio.helper.GMailDoctorReset;
import com.studio.helper.GMailFetch;
import com.studio.qe.automation.framework.pagefactory.MobileWebViewPage;

public class DoctorSendFormPO extends MobileWebViewPage {

	public DoctorSendFormPO(TestSession session) throws Exception {
		super(session, "Applications/studio/DoctorSendForm");
	}

	/**
	 * Used to verify Fields on page
	 * 
	 * @param element
	 * @return
	 */

	public boolean verify_FieldOnPage12(String element) {		
		WebDriverWait wait = new WebDriverWait(session.driver, 30);

		WebElement status = wait.until(ExpectedConditions.visibilityOf(element(element)));
		return status.isDisplayed();
	}

	/**
	 * Used to enter Email under forgot password page
	 * 
	 * @param email
	 */

	public void enter_Email1(String email) {
		element("EmailAddress_Field").sendKeys(email);
	}

	/**
	 * Used to enter Email under forgot password page
	 * 
	 * @param email
	 */

	public void enter_Password1(String Password) {
		element("Password_Field1").sendKeys(Password);
	}

	/**
	 * Used to click on Login button
	 * 
	 * @return
	 */

	public boolean click_LoginButton1() {
		boolean status = false;

		if (element("Login_Btn").isEnabled()) {
			element("Login_Btn").click();
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	/**
	 * Used to click Logout button
	 * 
	 * @return
	 * @throws InterruptedException
	 */

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

	/**
	 * Used to click SendForm button
	 */

	public void click_SendFormBtn() {
		Actions action = new Actions(session.driver);
		action.moveToElement(element("SendForm_Button1")).click().build().perform();
	}

	/**
	 * Used to verify Form Fields
	 * 
	 * @return
	 */

	public boolean verify_FormFields() {
		boolean status = false;

		if ((element("FirstName").isDisplayed()) && (element("LastName").isDisplayed())
				&& (element("Email").isDisplayed()) && (element("PhoneNumber").isDisplayed())
				&& (element("DateOfBirth").isDisplayed()) && (element("ChooseForm").isDisplayed())) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

	/**
	 * Used to verify Form Fields 1
	 * 
	 * @return
	 */

	public boolean verify_FormFields12() {
		boolean status = false;

		if ((element("AppointmentType").isDisplayed()) && (element("SelectDoctor").isDisplayed())
				&& (element("Appointmentdate").isDisplayed()) && (element("Appointmenttime").isDisplayed())) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

	/**
	 * Used to verify Send form button disable
	 * 
	 * @return
	 */

	public boolean verifySendFormdisable() {
		boolean status = false;

		if (element("SendFormButtonOnForm").isEnabled()) {
			status = false;
		} else {
			status = true;
		}

		return status;
	}

	/***
	 * Used to verify I am able to type in First name field
	 * 
	 * @return
	 */

	public boolean verify_EnterInFirstName() {
		boolean status = false;

		String FirstName = "Dalton";
		element("FirstName").sendKeys(FirstName);
		String FirstName1 = element("FirstName").getAttribute("value");

		if (FirstName.equals(FirstName1)) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

	/***
	 * Used to verify I am able to type in Last name field
	 * 
	 * @return
	 */

	public boolean verify_EnterInLastName() {
		boolean status = false;

		String LastName = "Dalton";
		element("LastName").sendKeys(LastName);
		String LastName1 = element("LastName").getAttribute("value");

		if (LastName.equals(LastName1)) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

	/***
	 * Used to verify I am not able to type invalid First name
	 * 
	 * @return
	 */

	public boolean verify_InvalidEnterInFirstName() {
		boolean status = false;

		String FirstName = "Dalton  12@#$%%D#@D@#D";
		element("FirstName").sendKeys(FirstName);
		String FirstName1 = element("FirstName").getAttribute("value");

		if (FirstName.equals(FirstName1)) {
			status = false;
		} else {
			status = true;
		}

		return status;
	}

	/***
	 * Used to verify I am not able to type invalid Last name
	 * 
	 * @return
	 */

	public boolean verify_InvalidEnterInLastName() {
		boolean status = false;

		String LastName = "Dalton  12@#$%%D#@D@#D";
		element("LastName").sendKeys(LastName);
		String LastName1 = element("LastName").getAttribute("value");

		if (LastName.equals(LastName1)) {
			status = false;
		} else {
			status = true;
		}

		return status;
	}

	/***
	 * Used to verify enter in email
	 * 
	 * @return
	 */

	public boolean verify_EnterInEmail() {
		boolean status = false;

		String Email = "Dalton@gmail.com";
		element("Email").sendKeys(Email);
		String Email1 = element("Email").getAttribute("value");

		if (Email.equals(Email1)) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

	/***
	 * Used to verify I am not able to type invalid Email
	 * 
	 * @return
	 */

	public boolean verify_InvalidEnterInEmail() {
		boolean status = false;
		String Email = "Dalton@gmail";
		element("Email").sendKeys(Email);
		// String Email1=element("Email").getAttribute("value");

		if (element("MsgForInvalidEmail").isDisplayed()) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

	/***
	 * Used to verify I am able to type DOB
	 * 
	 * @return
	 */

	public boolean verify_EnterDOB(String DOB) throws ParseException {
		boolean status = false;

	//	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
	//	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");
	//	String DOB2 = sdf2.format(sdf1.parse(DOB));
        System.out.println("entered DOB is:" +DOB);
   //     System.out.println("coverted DOB is:" +DOB2);
        
		element("DateOfBirth").sendKeys(DOB);
		element("PhoneNumText").click();
		String DOB1 = element("DateOfBirth").getAttribute("value");
		System.out.println("added DOB is:" +DOB1);
		if (DOB1.equals(DOB)) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

	/***
	 * Used to verify I am not able to type invalid DOB
	 * 
	 * @return
	 */

	public boolean verify_EnterInvalidDOB(String DOB) throws ParseException {
		boolean status = false;

	//	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
	//	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");
	// DOB2 = sdf2.format(sdf1.parse(DOB));

		element("DateOfBirth").sendKeys(DOB);
		element("PhoneNumText").click();
		String DOB1 = element("DateOfBirth").getAttribute("value");
		System.out.println("DOB is:" + DOB);
		System.out.println("DOB1 is:" + DOB1);
	//	System.out.println("DOB2 is:" + DOB2);
		if (element("DateValidationMSg").isDisplayed()) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

	/***
	 * Used to verify I am able to type in PhoneNumber field
	 * 
	 * @return
	 */

	public boolean verify_EnterPhoneNum(String Phone) {
		boolean status = false;

		element("PhoneNumber").sendKeys(Phone);
		String Phone1 = element("PhoneNumber").getAttribute("value");
		Phone1 = Phone1.replaceAll(" ", "");
		System.out.println("Phone is:" + Phone);
		System.out.println("Phone1 is:" + Phone1);
		if (Phone.equals(Phone1)) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

	/***
	 * Used to verify I am not able to type invalid PhoneNumber
	 * 
	 * @return
	 */

	public boolean verify_EnterInvalidPhoneNum(String Phone) {
		boolean status = false;

		element("PhoneNumber").sendKeys(Phone);
		element("PhoneErrorClick").click();
		if (element("MsgForInvalidPhone").isDisplayed()) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

	/***
	 * Used to verify I am able to select form
	 * 
	 * @return
	 */

	public boolean verify_SelectForm() throws InterruptedException {
		boolean status = false;

		element("ChooseForm").click();
		Thread.sleep(2000);
		if (element("TestFormQA").isDisplayed()) {
			element("TestFormQA").click();
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	/***
	 * Used to verify I am able to select Appointment Type
	 * 
	 * @return
	 */

	public boolean verify_SelectAppointmentType() throws InterruptedException {
		boolean status = false;

		element("AppointmentType").click();
		Thread.sleep(2000);
		if (element("AppointTypeText").isDisplayed()) {
			element("AppointTypeText").click();
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	/***
	 * Used to verify I am able to select Doctor
	 * 
	 * @return
	 */

	public boolean verify_SelectDoctor() throws InterruptedException {
		boolean status = false;

		element("SelectDoctor").click();
		Thread.sleep(2000);
		if (element("Doctor").isDisplayed()) {
			element("Doctor").click();
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	/***
	 * Used to verify I am able to Enter Appointment Date
	 * 
	 * @return
	 */

	public boolean verify_EnterAppointmentDate(String AppDate) throws ParseException {
		boolean status = false;

	//	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
	//	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");
	//	String AppDate2 = sdf2.format(sdf1.parse(AppDate));

		element("Appointmentdate").sendKeys(AppDate);
		String AppDate1 = element("Appointmentdate").getAttribute("value");

		if (AppDate1.equals(AppDate)) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

	/***
	 * Used to verify I am not able to invalid appointment date
	 * 
	 * @return
	 */

	public boolean verify_EnterInvalidAppointmentDate(String AppDatePast) throws ParseException {
		boolean status = false;

	//	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
	//	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");
	//	String AppDatePast2 = sdf2.format(sdf1.parse(AppDatePast));

		element("Appointmentdate").sendKeys(AppDatePast);
		element("DoctorText").click();
		String AppDatePast1 = element("Appointmentdate").getAttribute("value");

	//	System.out.println("AppDatePast2 is :" + AppDatePast2);
		System.out.println("AppDatePast1 is :" + AppDatePast1);

		if (element("DateValidationMSg").isDisplayed()) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

	/**
	 * Used to Enter Time
	 * 
	 * @return
	 */

	public boolean verify_EnterInTime() {
		boolean status = false;

		String AppTime = "10:23";

		element("Appointmenttime").sendKeys(AppTime);
		String AppTime1 = element("Appointmenttime").getAttribute("value");
		System.out.println("AppTime is:" + AppTime);
		System.out.println("AppTime1 is:" + AppTime1);

		if (AppTime.equals(AppTime1)) {
			status = true;
		} else {
			status = false;
		}

		return status;

	}

	/**
	 * Used to Enter in Firstname,Lastname, Email and Choose form
	 * 
	 * @throws InterruptedException
	 */

	public void enter_FirstNameLstNameEmailChooseForm(String Firstname, String Lastname, String Email)
			throws InterruptedException {
		element("FirstName").sendKeys(Firstname);
		Thread.sleep(1000);
		element("LastName").sendKeys(Lastname);
		Thread.sleep(1000);
		element("Email").sendKeys(Email);
		Thread.sleep(1000);
		element("ChooseForm").click();
		Thread.sleep(2000);
		element("TestFormQA").click();
		Thread.sleep(1000);
	}

	/**
	 * Used to verify Send form button Enable
	 * 
	 * @return
	 */

	public boolean verifySendFormEnable() {
		boolean status = false;

		if (element("SendFormButtonOnForm").isEnabled()) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}
	
	/** 
	 * Used to enter Appointment date and Time
	 * @param AppointDate
	 * @param AppointTime
	 * @throws InterruptedException
	 */

	public void verify_EnterAppointmentDateTime(String AppointDate, String AppointTime) throws InterruptedException {
		element("Appointmentdate").sendKeys(AppointDate);
		Thread.sleep(1000);
		element("Appointmenttime").sendKeys(AppointTime);
		Thread.sleep(1000);
	}
	
	/** 
	 * Used to enter PhoneNumber, Appointment Type,Doctor
	 * @throws InterruptedException
	 */

	public void enter_PhoneAppointTypeTime() throws InterruptedException {
		element("PhoneNumber").sendKeys("512-335-2541");
		Thread.sleep(1000);
		element("AppointmentType").click();
		Thread.sleep(2000);
		element("AppointTypeText").click();
		Thread.sleep(1000);
		element("SelectDoctor").click();
		Thread.sleep(2000);
		element("Doctor").click();
		Thread.sleep(1000);
	}
	
	/**
	 *  Used to verify Whether fields get reset on click of Reset button
	 * @return
	 * @throws InterruptedException
	 */

	public boolean verify_FieldsClearOnResetClick() throws InterruptedException {
		boolean status = false;

		String FirstN = element("FirstName").getAttribute("value");
		String LastN = element("LastName").getAttribute("value");
		String Email = element("Email").getAttribute("value");
		// String Form=element("ChooseForm").getAttribute("value");
		String Phone = element("PhoneNumber").getAttribute("value");
		String AppointDate = element("Appointmentdate").getAttribute("value");
		String AppointTime = element("Appointmenttime").getAttribute("value");
		// String AppointType=element("AppointmentType").getAttribute("value");
		// String Doctor=element("SelectDoctor").getAttribute("value");
		Thread.sleep(1000);

		Actions action = new Actions(session.driver);
		action.moveToElement(element("ResetBtn")).click().build().perform();
		Thread.sleep(1000);

		String FirstN1 = element("FirstName").getAttribute("value");
		String LastN1 = element("LastName").getAttribute("value");
		String Email1 = element("Email").getAttribute("value");
		// String Form1=element("ChooseForm").getAttribute("value");
		String Phone1 = element("PhoneNumber").getAttribute("value");
		String AppointDate1 = element("Appointmentdate").getAttribute("value");
		String AppointTime1 = element("Appointmenttime").getAttribute("value");
		// String AppointType1=element("AppointmentType").getAttribute("value");
		// String Doctor1=element("SelectDoctor").getAttribute("value");
		Thread.sleep(1000);

		if ((FirstN.equals(FirstN1)) && (LastN.equals(LastN1)) && (Email.equals(Email1)) && (Phone.equals(Phone1))
				&& (AppointDate.equals(AppointDate1)) && (AppointTime.equals(AppointTime1))) {
			status = false;
		} else {
			status = true;
		}

		return status;
	}
	
	/**
	 *  Used to click on SendForm button
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
	
	/** 
	 * Used to verify mail is generated for already registered user or not
	 * @return
	 */

	public boolean verify_MailForRegisteredUser() {
		boolean status = false;
		HashMap<String, String> hm = GMailFetch
				.getGmailData("subject:Seed Doctor Office. LLC invites you to fill out your paperwork online");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC invites you to fill out your paperwork online");

		if (exist) {
			String body = hm.get("body");
			System.out.println(body);
			if (body.contains("Seed Doctor Office. LLC")) {
				status = true;
			} else {
				status = false;
			}
		} else {
			status = false;
		}
		return status;
	}
	
	public boolean verify_MailBodyTextForRegisteredUser() {
		boolean status = false;
		HashMap<String, String> hm = GMailFetch
				.getGmailData("subject:Seed Doctor Office. LLC invites you to fill out your paperwork online");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC invites you to fill out your paperwork online");

		if (exist) {
			String body = hm.get("body");
			System.out.println(body);
			if (body.contains("Are you interesting in scheduling online? Let us know.")) {
				status = true;
			} else {
				status = false;
			}
		} else {
			status = false;
		}
		return status;
	}
	
	/** 
	 * Used to verify URL under mail for already registered user or not
	 * @return
	 */

	public boolean verify_URLUnderMailBody() {
		boolean status = false;
		HashMap<String, String> hm = GMailFetch
				.getGmailData("Seed Doctor Office. LLC invites you to fill out your paperwork online");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC invites you to fill out your paperwork online");
		if (exist) {
			String body = hm.get("body");
			if (body.contains("Seed Doctor Office. LLC")) {
				// String link= hm.get("link");
				// System.out.println(link);
				if (body.contains("https://seed-doctor-office.patients.qa.patientstudio.com")) {
					status = true;
				} else {
					status = false;
				}
			} else {
				status = false;
			}
		} else {
			status = false;
		}

		return status;
	}
	
	/** 
	 * Used to verify FirstName under mail for already registered user or not
	 * @return
	 */

	public boolean verify_FirstNameUnderMailBody(String FirstName) {
		boolean status = false;

		HashMap<String, String> hm = GMailFetch
				.getGmailData("Seed Doctor Office. LLC invites you to fill out your paperwork online");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC invites you to fill out your paperwork online");
		if (exist) {
			String body = hm.get("body");
			if (body.contains(FirstName)) {
				status = true;
			} else {
				status = false;
			}
		} else {
			status = false;
		}

		return status;
	}
	
	/** 
	 * Used to verify mail is generated for already registered user with Appointment type or not
	 * @return
	 */

	public boolean verify_MailForRegisteredUserAppointType() {
		boolean status = false;
		HashMap<String, String> hm = GMailFetch
				.getGmailData("subject:Seed Doctor Office. LLC invites you to fill out your paperwork online");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC invites you to fill out your paperwork online");

		if (exist) {
			String body = hm.get("body");
			System.out.println(body);
			if (body.contains("Are you interesting in scheduling online? Let us know.")) {
				status = false;
			} else {
				status = true;
			}
		} else {
			status = false;
		}
		return status;
	}
	
	/** 
	 * Used to verify URL under mail is generated for already registered with Appointment type or not
	 * @return
	 */

	public boolean verify_URLUnderMailBody1() {
		boolean status = false;
		HashMap<String, String> hm = GMailFetch
				.getGmailData("Seed Doctor Office. LLC invites you to fill out your paperwork online");
		String body = hm.get("body");
		if (body.contains("Are you interesting in scheduling online? Let us know.")) {
			status = false;
		} else {
			if (body.contains("https://seed-doctor-office.patients.qa.patientstudio.com")) {
				status = true;
			} else {
				status = false;
			}
		}
		return status;
	}
	
	/** 
	 * Used to verify FirstName under mail is generated for already registered user with Appointment type or not
	 * @return
	 */

	public boolean verify_FirstNameUnderMailBody1(String FirstName1) {
		boolean status = false;

		HashMap<String, String> hm = GMailFetch
				.getGmailData("Seed Doctor Office. LLC invites you to fill out your paperwork online");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC invites you to fill out your paperwork online");
		if (exist) {
			String body = hm.get("body");
			if (body.contains(FirstName1)) {
				status = true;
			} else {
				status = false;
			}
		} else {
			status = false;
		}

		return status;
	}
	
	/** 
	 * Used to verify Practice name under mail is generated for already registered user with Appointment type or not
	 * @return
	 */

	public boolean verify_PracticeNameUnderMailBody() {
		boolean status = false;

		HashMap<String, String> hm = GMailFetch
				.getGmailData("Seed Doctor Office. LLC invites you to fill out your paperwork online");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC invites you to fill out your paperwork online");
		if (exist) {
			String body = hm.get("body");
			if (body.contains("Practice Name")) {
				status = true;
			} else {
				status = false;
			}
		} else {
			status = false;
		}

		return status;
	}
	
	/** 
	 * Used to verify  mail is generated for New Profile under already registered user or not
	 * @return
	 */
	
	public boolean verify_MailForRegisteredUserNewProfile(String FirstName1) {
		boolean status = false;
		HashMap<String, String> hm = GMailFetch
				.getGmailData("subject:Seed Doctor Office. LLC invites you to fill out your paperwork online");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC invites you to fill out your paperwork online");

		if (exist) {
			String body = hm.get("body");
			if ((body.contains(FirstName1)) && (body.contains("Seed Doctor Office. LLC"))){
				status=true;
			}else {
				status=false;
			}
		}else {
			status=false;
		}
		return status;
	}
	
	public boolean verify_MailbodyTextForRegisteredUserNewProfile(String FirstName1) {
		boolean status = false;
		HashMap<String, String> hm = GMailFetch
				.getGmailData("subject:Seed Doctor Office. LLC invites you to fill out your paperwork online");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC invites you to fill out your paperwork online");

		if (exist) {
			String body = hm.get("body");
		  if ((body.contains(FirstName1)) && (body.contains("Seed Doctor Office. LLC"))) {
			if (body.contains("Are you interesting in scheduling online? Let us know.")) {
				status=true;
			}else {
				status=false;
			}
		  }else {
			  status=false;
		  }
		}else {
			status=false;
		}
		return status;
	}
	
	/** 
	 * Used to verify URL under mail is generated for New Profile under already registered user or not
	 * @return
	 */
	
	public boolean verify_URLUnderMailBodyNewProfile(String FirstName1) {
		boolean status = false;
		HashMap<String, String> hm = GMailFetch
				.getGmailData("subject:Seed Doctor Office. LLC invites you to fill out your paperwork online");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC invites you to fill out your paperwork online");

		if (exist) {
			String body = hm.get("body");
			if((body.contains(FirstName1)) && (body.contains("Seed Doctor Office. LLC"))) {
				if (body.contains("https://seed-doctor-office.patients.qa.patientstudio.com")) {
					status = true;
				} else {
					status = false;
				}
				//status=true;
			}else {
				status=false;
			}
		}else {
			status=false;
		}
		return status;
	}
	
	/** 
	 * Used to verify  mail is generated for New Profile under already registered user with Appointment type or not
	 * @return
	 */
	
	public boolean verify_MailForRegisteredUserNewProfileAppoint(String FirstName2) {
		boolean status = false;
		HashMap<String, String> hm = GMailFetch
				.getGmailData("subject:Seed Doctor Office. LLC invites you to fill out your paperwork online");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC invites you to fill out your paperwork online");

		if (exist) {
			String body = hm.get("body");
			if ((body.contains(FirstName2)) && (body.contains("Practice Name"))) {
				if(body.contains("Are you interesting in scheduling online? Let us know.")) {
				  status=false;
				}else {
					status=true;
				}
			}else {
				status=false;
			}
		}else {
			status=false;
		}
		return status;
	}
	
	/** 
	 * Used to verify URL under mail is generated for New Profile under already registered user with Appointment type or not
	 * @return
	 */

	
	public boolean verify_URLUnderMailBodyNewProfileAppoint(String FirstName2) {
		boolean status = false;
		HashMap<String, String> hm = GMailFetch
				.getGmailData("subject:Seed Doctor Office. LLC invites you to fill out your paperwork online");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC invites you to fill out your paperwork online");

		if (exist) {
			String body = hm.get("body");
			if ((body.contains(FirstName2)) && (body.contains("Practice Name"))) {
				if(body.contains("https://seed-doctor-office.patients.qa.patientstudio.com")) {
				  status=true;
				}else {
					status=false;
				}
			}else {
				status=false;
			}
		}else {
			status=false;
		}
		return status;
	}
	
	/** 
	 * Used to verify Practice Name under mail is generated for New Profile under already registered user with Appointment type or not
	 * @return
	 */

	
	public boolean verify_PracticeNameUnderMailBody1(String FirstName2){
		boolean status = false;
		HashMap<String, String> hm = GMailFetch
				.getGmailData("subject:Seed Doctor Office. LLC invites you to fill out your paperwork online");
		boolean exist = GMailFetch.isMailExist("Seed Doctor Office. LLC invites you to fill out your paperwork online");

		if (exist) {
			String body = hm.get("body");
			if (body.contains(FirstName2)) {
				if(body.contains("Practice Name")) {
				  status=true;
				}else {
					status=false;
				}
			}else {
				status=false;
			}
		}else {
			status=false;
		}
		return status;
	}
}
