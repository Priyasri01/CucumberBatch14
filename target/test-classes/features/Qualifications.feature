 Feature: Qualifications page functionality

 Background:
    When user enters vali admin usernam and pass
    And user clicks on the login button
    Then user is successfully logged in
    When user clicks on Pim tab from the directory menu
    And user clicks on Employee list option from the PIM menu
    And user clicks on any employee "42050A"
    Then user should be taken to the personal details page
    When user clicks on Qualifications from the side menu
    Then user should be able to verify they are on Qualification page

     @Qual102
     Scenario: Adding employee skills
       When user clicks on the Add button under the skills Category
       And user  checks is the skill dropdown field is displayed or not and selected the skill option from the drop down list "Problem solving"
       And user checks is the year of experience text-box field is displayed or not  and enters the years of experience on the experience field "2"
       When user checks is the comments textbox field is displayed or not and  enter the feedback on the comments box
       And user enter the save button
       Then user added employee skills successfully "Problem solving" and "2"

       @Qual103
       Scenario: Adding employee license
         When user clicks on the Add buttton under Add license Category
         And user selected the license type "Logical Operators" from the License type
         And user enters the license number "NYJames007"
         When user selected  license issues data and  expiry data from the calendar
         And user clicks on the save button
         Then user added the employee License successfully "Logical Operators" , "2019-09-20" and "2024-09-27"


