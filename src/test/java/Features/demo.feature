#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


#Feature: Visit career guide page in career.guru99.com



#Scenario: Visit career.guru99.com
#Given I am on career.guru99.com
#When I click on career guide menu
#Then I should see career guide page

@Smoke
Feature: login functionality
 Scenario Outline: check login page of sauce demo website using valid username and valid password
 Given user navigate to the sauce demo website
 And user select username element and enter username "<username>"
 And user select password element and enter password "<password>"
 When User click the login button
 Then user should move to home page
 
 Examples:
 | username 							| password |
 | standard_user    			| secret_sauce  |
 | locked_out_user  			| secret_sauce  |
 | problem_user    				| secret_sauce |
 | performance_glitch_user    | secret_sauce |
 

