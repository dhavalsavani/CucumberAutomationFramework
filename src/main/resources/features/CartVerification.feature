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
Feature: Add to Cart verification
  I want to verify items added to the cart

 @tag2
  Scenario: Verify Add to cart feature
    Given I want explore Cucumber features
    When I open the automation practice "http://www.automationpractice.com/"
    And I Go to Dresses menu
    And I add my favourite dresses to cart
    	|Printed Dress				|
    	|Printed Chiffon Dress|
    Then I should see dresses added into the cart