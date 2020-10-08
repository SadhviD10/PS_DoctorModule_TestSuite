Feature: Covering Doctor Staff Admin Scenarios

  @StaffAdmin_001  @run7  @Doctor1
  Scenario: To verify Office-Admin can view  Number of Patient List when searched
  And I verify that I navigated to Login Page of Doctor2
  When I enter "office-admin@patientstudio.com" in Email2 field
  When I enter "1 Super Safe Password!" in Password2 field
  And I click on Login button111
  Then I verify that i navigate to Dashboard12
  When I search "Dummy" in Patient List
  And I verify that only "Dummy" patient list is displayed
 
  @StaffAdmin_002 @run7  @Doctor1
  Scenario: To verify Office-Admin can view  Number of Forms  assigned to a particular Patient
  And I verify that I navigated to Login Page of Doctor2
  When I enter "office-admin@patientstudio.com" in Email2 field
  When I enter "1 Super Safe Password!" in Password2 field
  And I click on Login button111
  Then I verify that i navigate to Dashboard12
  When I search "news" in Patient List
  And I verify that only "news" patient list is displayed
  And I click on the selected patient Form and verify FormList Page opens
  