Feature: Admin page functionality
  @US15Priyasri
  Scenario: Admin user is able to add any License under Qualifications
   When admin user enters valid admin username and password
    And admin user clicks on the login button
   Then admin user is successfully logged in
 When admin user clicks on the Admin button
    And admin user clicks on the Qualifications list
    And  admin user selected the License option  form the list
    And admin user should be able to verify they are on the "Licenses" List Page
    When  admin user clicks on the add button
    And admin user added the license in the Name feild "Commercial Driver License"
    And admin user clicks on the save button
    Then admin user added the  license and verify they added successfully