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
@tag
Feature: Practice Cucumber BDD
  I want to explore different features of Cucumber

  @tag1
  Scenario Outline: Open practice website
    Given I want explore Cucumber features
    When I open the automation practice <website>
    Then I validate practice website title is <title>
    
    Examples:
    |									website						 		|									title	 							|
		| "http://www.automationpractice.com/"	| 							My Store 							|
		| "https://www.phptravels.com/demo/"		|	Demo Script Test drive - PHPTRAVELS |