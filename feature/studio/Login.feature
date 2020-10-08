Feature: Covering Doctor Login Page Scenarios

  @D_Login_001_002_003_004_005_006_007_008_009  @Doctor @Smoke
  Scenario: To verify User Redirect to Login page of Doctor when enter DoctorURL
    And I verify that I navigated to Login Page
    Then I verify that Email Field is present
    Then I verify that Password Field is present
    Then I verify That I am able to enter in Email field
    Then I verify That I am able to enter in Password field
    Then I verify that Forgot Password Link Is Present
    Then I verify That Login button is disabled

  @D_Login_010  @Doctor @Smoke
  Scenario: To verify Validation error message appears below the Email field if entered invalid Email
    And I verify that I navigated to Login Page
    When I enter "admin@gmail" in Email fields
    Then I verify that I get validation error message below Email field

  @D_Login_011  @Doctor @Smoke
  Scenario: To verify Login button is disable if entered Valid Email and Invalid password
    And I verify that I navigated to Login Page
    When I enter "admin@gmail.com" in Email fields
    When I enter "123456" in Password fields
    Then I verify That Login button is disabled

  @D_Login_012  @Doctor @Smoke
  Scenario: To verify Login Button is enable if user enter valid Email and valid password
    And I verify that I navigated to Login Page
    When I enter "admin@gmail.com" in Email fields
    When I enter "Test@123" in Password fields
    Then I verify that Login button is Enabled

  @D_Login_013  @Doctor 
  Scenario: To verify User is unable to login with valid Email and Invalid password
    And I verify that I navigated to Login Page
    When I enter "office-admin@patientstudio.com" in Email fields
    When I enter "Test@123" in Password fields
    And I click on Login button
    Then I verify that with invalid credentials I am unable to Login

  @D_Login_014  @Doctor 
  Scenario: To verify User is Unable to login with Invalid Email and valid Password
    And I verify that I navigated to Login Page
    When I enter "office-admin@patient" in Email fields
    When I enter "1 Super Safe Password!" in Password fields
    And I click on Login button
    Then I verify that with invalid credentials I am unable to Login

  @D_Login_015  @Doctor
  Scenario: To verify error message is present or not if user switch to forgot password screen from Login Screen
    And I verify that I navigated to Login Page
    When I enter "office-admin@patientstudio.com" in Email fields
    When I enter "Test@123" in Password fields
    And I click on Login button
    Then I verify that Error msg appears
    When I Click on Forgot password link
    When I Click on BackToLogin button
    Then I verify that Error msg dissapears

  @D_Login_016  @Doctor @Smoke
  Scenario: To verify User is able to login with valid Email and Password
    And I verify that I navigated to Login Page
    When I enter "office-admin@patientstudio.com" in Email fields
    When I enter "1 Super Safe Password!" in Password fields
    And I click on Login button
    Then I verify that i navigate to Dashboard
    And I Logout from the page1
