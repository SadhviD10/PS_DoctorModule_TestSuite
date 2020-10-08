Feature: Covering Doctor ForgotPassword Page Scenarios

  @D_Forgot_001_002  @Doctor @Smoke
  Scenario: To verify User redirect back to Login when user click on Back To Login button
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I press back_To_Login button
    And I verify that I navigated to Login Page of Doctor

  @D_Forgot_003_004_027  @Doctor @Smoke
  Scenario: To verify Email field is displayed Forgot password page
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    And I verify that Email_Field is present
    And I verify that SendPassword button is disable

  @D_Forgot_005  @Doctor 
  Scenario: To verify Send Password button remain disable if user enter invalid Email
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I Enter "Dummy@gmail" in Email Field
    And I verify that SendPassword button is disable

  @D_Forgot_006  @Doctor @Smoke
  Scenario: To verify Send password button becomes enable if enter valid Email
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I Enter "Dummy@gmail.com" in Email Field
    And I verify that SendPassword button is Enabled

  @D_Forgot_007  @Doctor @Smoke
  Scenario: To verify Send Password button is clickable or not
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I Enter "Dummy@gmail.com" in Email Field
    And I verify that SendPassword button is Enabled
    Then I verify that Send Password button is clickable for First Time

  @D_Forgot_008  @Doctor 
  Scenario: To verify with non-registered Email user should get valid message of "User Not Registered" or not
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I Enter "Dummy543@gmail.com" in Email Field
    And I verify that SendPassword button is Enabled
    When I click on Send Password button
    Then I verify that Valid message for Non-Registered user gets displayed

  @D_Forgot_009  @Doctor @Smoke
  Scenario: To verify User redirect to Reset Password screen when click on Send Password button if Entered valid registered Email for Doctor
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I Enter "Test.doctordummy@gmail.com" in Email Field
    And I verify that SendPassword button is Enabled
    When I click on Send Password button
    Then I verify that user redirect to Reset Password screen

  @D_Forgot_010_011  @Doctor @Smoke
  Scenario: To verify User receives Email when click on Send Password button if Entered valid registered Email for Doctor
    And I verify that Doctor receives Email for reset password
    Then I verify that Mail body contains reset code

  @D_Forgot_013  @Doctor @Smoke
  Scenario: To verify Reset Password screen contains below fields 1. Email, 2. Reset Code, 3. New Password
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I Enter "dummy12@gmail.com" in Email Field
    And I verify that SendPassword button is Enabled
    When I click on Send Password button
    Then I verify that user redirect to Reset Password screen
    And I verify that Email,ResetCode,NewPassword are present

  @D_Forgot_014  @Doctor
  Scenario: To verify User should not be able to Edit Email under Email field of Reset Password screen
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I Enter "dummy12@gmail.com" in Email Field
    And I verify that SendPassword button is Enabled
    When I click on Send Password button
    Then I verify that user redirect to Reset Password screen
    And I verify that i am not able to Edit Edit under Email field

  @D_Forgot_016  @Doctor
  Scenario: To verify Reset password should remain disable if user fail to enter in New Password
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I Enter "dummy12@gmail.com" in Email Field
    And I verify that SendPassword button is Enabled
    When I click on Send Password button
    Then I verify that user redirect to Reset Password screen
    When I enter "123456" in Reset Code Field
    Then I verify that Reset Password button is Disable

  @D_Forgot_017  @Doctor
  Scenario: To verify Reset password should remain disable if user fail to enter in Reset Code
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I Enter "dummy12@gmail.com" in Email Field
    And I verify that SendPassword button is Enabled
    When I click on Send Password button
    Then I verify that user redirect to Reset Password screen
    When I enter "123456" in New Password Field
    Then I verify that Reset Password button is Disable

  @D_Forgot_018  @Doctor @Smoke
  Scenario: To verify Reset Password button becomes enable if entered in both Reset code field and New Password field
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I Enter "Test.DummyPatient@gmail.com" in Email Field
    And I verify that SendPassword button is Enabled
    When I click on Send Password button
    Then I verify that user redirect to Reset Password screen
    When I enter "123456" in Reset Code Field
    When I enter "123456" in New Password Field
    And I verify that Reset Password button is Enabled

  @D_Forgot_019  @Doctor 
  Scenario: To verify User should get error message if user enter incorrect Reset code and click on Reset password
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I Enter "Test.DummyPatient@gmail.com" in Email Field
    And I verify that SendPassword button is Enabled
    When I click on Send Password button
    Then I verify that user redirect to Reset Password screen
    When I enter "123456" in Reset Code Field
    When I enter "123456" in New Password Field
    And I click on Reset button
    Then I verif that i get error message for invalid reset code

  @D_Forgot_020  @Doctor
  Scenario: To verify Reset code field should accept only numeric digits
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I Enter "Test.DummyPatient@gmail.com" in Email Field
    And I verify that SendPassword button is Enabled
    When I click on Send Password button
    Then I verify that user redirect to Reset Password screen
    And I verify that reset code field doesnot accepts Alphanumeric

  @D_Forgot_021  @Doctor 
  Scenario: To verify Whether user gets Email for reset code more than once a day
    And I verify that I navigated to Login Page of Doctor
    Then I verify that I get mail more than once

  @D_Forgot_022  @Doctor @Smoke
  Scenario: To verify user should get Confirmation message after successfully reseting password
    And I verify that I navigated to Login Page of Doctor
    When I click On Forgot_Password
    Then I verify That I navigated to Forgot_password Screen
    When I Enter "Test.doctordummy@gmail.com" in Email Field
    And I verify that SendPassword button is Enabled
    When I click on Send Password button
    Then I verify that user redirect to Reset Password screen
    When I enter "Test@123" in New Password Field
    When I enter in Reset Code Field
    And I click on Reset button
    Then I verify that I navigated to Dashboard
    And I Logout from the page

  @D_Forgot_023  @Doctor
  Scenario: To verify User is now not able to login with previous password
    And I verify that I navigated to Login Page of Doctor
    When I Enter "Test.doctordummy@gmail.com" in email
    When I Enter "Test@1234" in Password
    And I click on Login button1
    Then I verify that i am not able to login with previous credentials

  @D_Forgot_024  @Doctor @Smoke
  Scenario: To verify user is able to Login with Recently Changed Password
    And I verify that I navigated to Login Page of Doctor
    When I Enter "Test.doctordummy@gmail.com" in email
    When I Enter "Test@123" in Password
    And I click on Login button1
    Then I verify that I navigated to Dashboard
    And I Logout from the page
