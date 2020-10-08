Feature: Covering Form Disable fromAdmin Page Scenarios

  @FD_000 @new8 @Doctor 
  Scenario: To verify user is able to send Form to patient
    And I verify that Doctor Login1 Page1 Opens
    When I enter Login Credentials
    Then I verify that i am able to Login to Doctor page
    When I enter submit the form to existing user
    And I verify that i am able to send Form to Patient

  @FD_001 @new8 @Doctor 
  Scenario: To verify user is able Disable form from Admin Panel
   # And I verify that Doctor Login1 Page1 Opens
   # When I enter Login Credentials
    And I verify that Doctor Dashboard page open
    And I open second Tab on browser
    When I switch to second Tab and enter Admin URL
    And I verify that i navigated to Admin Login Page
    When I enter Username,Password and click on SignUpbutton
    Then I verify that I navigated to Search page of Admin
    When I enter "seed doctor office LLC" in search field and click on Search button
    And I verify that i naviagted to CustomerInfo page
    When I click on Form Button
    And I verify that i navigated to Form page
    When I enter "1 field form" in Search field of Form page and I click on Form Edit button
    Then I verify that Edit Form Popup opens
    And I Toggle disable button and click onsave button
    Then I verify that Form is disabled successfully
    And I close the current Browser Tab

  @FD_002 @new8 @Doctor
  Scenario: To verify Disabled form is not present under Choose Form List
    # And I verify that Doctor Login1 Page1 Opens
    # When I enter Login Credentials
    And I verify that Doctor Dashboard page open
    When I click on Send form button on Dashboard
    And I verify that I navigate to InviteAPatient screen
    Then I verify that "1 field form" is not present in Choose a Form dropdown

  @FD_003 @new8 @Doctor
  Scenario: To verify Patient is able to fill and submit the form(disabled),send before and receive the confirmation mail for successful form submit
    #And I verify that Doctor Login1 Page1 Opens
    #When I enter Login Credentials
    And I verify that Doctor Dashboard page open
    And I open second Tab on browser
    When I switch to second Tab and enter Patient URL
    And I verify that i navigated to Patient Login Page
    When I enter Username,Password and click on Loginbutton
    Then I verify that I navigated to DashboardPage of Patient
    And I click on "1 field form" from the form list
    And I verify that form gets opened
    When I fill the form and click on Submit
    Then I verify that I Received confirmation mail for successful form submit
    And I close the current Browser Tab

  #@FD_004
  #Scenario: To verify Submitted form is displayed under Doctor patient List
  # And I verify that Doctor Login1 Page1 Opens
  # When I enter Login Credentials
  #And I verify that Doctor Dashboard page open
  #And I click on Patient Tab
  #When I search for "test" patient
  #And I click on patient name from the list
  #Then I verify that Submited form from the patient gets displayed under Form tab
  @FD_005 @new8 @Doctor
  Scenario: To verify User is successfully able to Enable the form under Admin PS Module
    And I verify that Doctor Dashboard page open
    And I open second Tab on browser
    When I switch to second Tab and enter Admin URL
    # And I verify that i navigated to Admin Login Page
    # When I enter Username,Password and click on SignUpbutton
    Then I verify that I navigated to Search page of Admin
    When I enter "seed doctor office LLC" in search field and click on Search button
    And I verify that i naviagted to CustomerInfo page
    When I click on Form Button
    And I verify that i navigated to Form page
    When I enter "1 field form" in Search field of Form page and I click on Form Edit button
    Then I verify that Edit Form Popup opens
    And I Toggle Enable button and click onsave button
    Then I verify that Form is Enabled successfully
    And I close the current Browser Tab

  @FD_006 @new8 @Doctor
  Scenario: To verify Enabled form is  present under Choose Form List
    # And I verify that Doctor Login1 Page1 Opens
    #When I enter Login Credentials
    And I verify that Doctor Dashboard page open
    When I click on Send form button on Dashboard
    And I verify that I navigate to InviteAPatient screen
    Then I verify that "1 field form" is present in Choose a Form dropdown

  @FD_007 @new8 @Doctor
  Scenario: To verify user is able to copy WebLink for the form and Able to navigate to Login page of Patient portal using the same
    And I verify that Doctor Dashboard page open
    And I open second Tab on browser
    When I switch to second Tab and enter Admin URL
    # And I verify that i navigated to Admin Login Page
    # When I enter Username,Password and click on SignUpbutton
    Then I verify that I navigated to Search page of Admin
    When I enter "seed doctor office LLC" in search field and click on Search button
    And I verify that i naviagted to CustomerInfo page
    When I click on Form Button
    And I verify that i navigated to Form page
    When I enter "1 field form" in Search field of Form page and I click on WebsiteLink button
    And I verify that Link code gets displayed and copied to clipboard
    And I open next Tab and paste the copied link and press enter
    # And I verify that i navigated to Patient Login Page
    Then I verify that I navigated to DashboardPage of Patient
    Then I close all the tabs

  @FD_008 @new8 @Doctor
  Scenario: To verify Search functionality for Patient is working using Email
    # And I verify that Doctor Login1 Page1 Opens
    # When I enter Login Credentials
    And I verify that Doctor Dashboard page open
    And I click on Patient Tab
    When I search for "Patient.studiotest@gmail.com" patient
    Then I verify that patient List gets updated as per searching

  @FD_009 @new8 @Doctor
  Scenario: To verify Search functionality for Patient is working using PhoneNumber
    # And I verify that Doctor Login1 Page1 Opens
    #  When I enter Login Credentials
    And I verify that Doctor Dashboard page open
    And I click on Patient Tab
    When I search for "512 335 6866" patient
    Then I verify that patient List gets updated as per searching

  @FD_010 @new8 @Doctor
  Scenario: To verify Search functionality for Patient is working using Patient FullName
    # And I verify that Doctor Login1 Page1 Opens
    #  When I enter Login Credentials
    And I verify that Doctor Dashboard page open
    And I click on Patient Tab
    When I search for "new test" patient
    Then I verify that patient List gets updated as per searching
    
    @FD_011 @new8 @Doctor
    Scenario: To Logout from the application
    And I verify that Doctor Dashboard page open
    And I logout from the doctor dashboard portal
