@TipTop
Feature: Login to SauceDemo Application
  
  @vaibhav
  Scenario: User successfully logged in to SauceDemo site
    Given User launches Browser
    And User enters "URL";
    Then Verify that the text input element with xpath ".//input[@name='my-disabled']" is disabled in the form
    Then Verify that the text input with value "Readonly input" is in readonly state by using 2 xpaths
    Then Verify that the dropdown field to select color is having 8 elements using 2 xpaths
    Then Verify that the submit button is disabled when no data is entered in Name field
    Then Verify that the submit button enabled when both Name and Password field is entered
    Then Verify that on submit of 'Submit' button the page shows 'Received' text
    Then Verify that on submit of form all the data passed to the URL
    

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
