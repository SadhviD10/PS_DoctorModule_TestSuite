Feature: Covering Doctor SendForm Page Scenarios

  # Combined cases-------------------
  # To verify user is able to click on Send form button
  # To verify User is able to view following mentioned fields under Form page 1. First Name 2.Last Name 3. Email 4. Date of Birth 5. Phone Number 6. Choose a form Dropdown
  # To verify User is able to view following mentioned fields under Form page 1.Appointment Type DropDown 2. Doctor Dropdown 3. Date 4. Time
  # To verify user is able to enter in First Name
  # To verify send form button is disable initially
  # To verify user is able to enter in Last Name
  # To verify user is able to enter in Email Field
  # To verify user is able to enter valid DOB
  # To verify User is able to enter Phone number
  # To verify user is able to enter in Appointment time,Appointment Date, Select Form,Select Appointment type, Select Doctor
  @SendForm_001_002_003_004_005_006_007_009_011_013_017_019_020_021_022_025  @Doctor @Smoke
  Scenario: To verify User is able to navigate to dashboard of Doctor
    And I verify that I navigated to Login Page of Doctor1
    When I enter "office-admin@patientstudio.com" in Email field
    When I enter "1 Super Safe Password!" in Password field
    And I click on Login button11
    Then I verify that i navigate to Dashboard1
    Then I verify that SendForm button present on top right
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    Then I verify that Fields are present
    Then I verify that AppointmentType Fields are present
    And I verify that SendForm button under Invite page is disable initially
    And I verify that i am able to enter in First Name
    And I verify that i am able to enter in Last Name
    And I verify that i am able to enter in Email
    And I verify that i am able to enter valid DOB
    And I verify that i am able to enter in phone number
    And I verify that i am able to select Form
    And I verify that i am able to select Appointment Type
    And I verify that i am able to select Doctor
    And I verify that i am able to enter Appointment date
    And I verify that i am able to enter in time

  @SendForm_008  @Doctor
  Scenario: To verify Spaces and Special characters are not allowed in First name Field
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    And I verify that i am not able to enter invalid First Name

  @SendForm_010  @Doctor
  Scenario: To verify Spaces and Special characters are not allowed in Last name Field
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    And I verify that i am not able to enter invalid Last Name

  @SendForm_012  @Doctor
  Scenario: To verify user gets error message for invalid Email
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    And I verify that i get error message for invalid Email

  @SendForm_014  @Doctor
  Scenario: To verify user is not able to enter future dates under future month and current year under DOB
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    And I verify that i am not able to enter FutureDate_FutureMonth_SameYear in DOB

  @SendForm_015  @Doctor
  Scenario: To verify user is not able to enter future dates under Future month and Future year under DOB
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    And I verify that i am not able to enter FutureDate_FutureMonth_FutureYear in DOB

  @SendForm_016  @Doctor
  Scenario: To verify user is not able to enter future dates under current month and current year under DOB
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    And I verify that i am not able to enter FutureDate_CurrentMonth_CurrentYear in DOB

  @SendForm_018  @Doctor
  Scenario: To verify User gets validation error message for invalid phone number
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    And I verify that i am getting error message for invalid phone number

  @SendForm_023  @Doctor
  Scenario: To verify user should not be able to add past Appointment date
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    And I verify that i am not able to enter Past Appointment date

  @SendForm_026  @Doctor @Smoke
  Scenario: To verify Send Form button is enabled once we fill all the mandatory fields 1. First Name 2. Last Name 3. Email 4. choose Form
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    When I enter in FirstName,LastName,Email and Choose Form
    Then I verify that Send form button is Enabled

  @SendForm_027  @Doctor @Smoke
  Scenario: To verify Send Form button remain Enable if we fill other optional fields other than Mandatory fields 1. Appointment Date 2. Appointment Time
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    When I enter in FirstName,LastName,Email and Choose Form
    When I enter PhoneNumber, select AppointmentType and Doctor
    When I enter in Appointment Date and Appointment Time
    Then I verify that Send form button is Enabled

  @SendForm_028  @Doctor @Smoke
  Scenario: To verify when user click on reset button, all the fields content gets cleared
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    When I enter in FirstName,LastName,Email and Choose Form
    When I enter in Appointment Date and Appointment Time
    When I enter PhoneNumber, select AppointmentType and Doctor
    And I verify that click on Reset button clear all field values

  @SendForm_037  @Doctor  @Smoke
  Scenario: To verify Doctor is able to send form to Existing User with already registered account without appointment date
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    When I enter in FirstName,LastName,Email and Choose Form
    And I verify that I am able to click on SendForm button

  @SendForm_038_039_040  @Doctor  @Smoke
  Scenario: To verify user is receiving mail under the registered Email for form without Appointment Date
    Then I verify that i navigate to Dashboard1
    And I verify that I receive mail for form under registered user
    And I verify that I receive PatientURL under mail for form under registered user
    And I verify that patient name is displayed under mail body

  @SendForm_042  @Doctor  @Smoke
  Scenario: To verify Doctor is able to send form to Existing User with Appointment Date
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    When I enter in FirstName,LastName,Email and Choose Form
    When I enter PhoneNumber, select AppointmentType and Doctor
    When I enter in Appointment Date and Appointment Time
    And I verify that I am able to click on SendForm button

  @SendForm_043_044_045_046  @Doctor  @Smoke
  Scenario: To verify user is receiving Form mail for Appointment under the registered Email
    Then I verify that i navigate to Dashboard1
    And I verify that I receive mail for form under registered user for AppointmentType
    And I verify that I receive PatientURL under mail for form under registered user AppointDate
    And I verify that patient name is displayed under mail body of Existing user Appointment Type
    And I verify that practice name is displayed under mail body of Existing user Appointment Type

  @SendForm_047  @Doctor  @Smoke
  Scenario: To verify Doctor is able to send form to new User under Existing Account without Appointment Date
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    When I enter in FirstName1,LastName1, Email1 and ChooseForm1
    And I verify that I am able to click on SendForm button

  @SendForm_048_050_049  @Doctor  @Smoke
  Scenario: To verify user is receiving mail under the registered Email for new Profile
    Then I verify that i navigate to Dashboard1
    And I verify that I receive mail for form under registered user for new profile
    And I verify that I receive PatientURL under mail for form under registered user New Profile

  @SendForm_052  @Doctor  @Smoke
  Scenario: To verify Doctor is able to send form to new User under Existing Account with Appointment Date
    Then I verify that i navigate to Dashboard1
    When I click on Send Form button
    Then I verify that i am able to click on Send form button
    When I enter in FirstName2,LastName2, Email and ChooseForm
    When I enter PhoneNumber, select AppointmentType and Doctor
    When I enter in Appointment Date and Appointment Time
    And I verify that I am able to click on SendForm button

  @SendForm_053_054_055_056  @Doctor  @Smoke
  Scenario: To verify user is receiving mail under the registered Email for new Profile AppointmentType
    Then I verify that i navigate to Dashboard1
    And I verify that I receive mail for form under registered user for new profile AppointmentType
    And I verify that I receive PatientURL under mail for form under registered user New Profile Appoint
    And I verify that I Practice name is displayed for New Profile Appoint
    
  @SendForm_057  @Doctor  @Smoke
  Scenario: To verify user is able to logout from Doctor dashboard
    Then I verify that i navigate to Dashboard1
    And I Logout from the page11
