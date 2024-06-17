
Feature: User login to sauce lab application

@srs
Scenario: User login with valid user name and password
    Given user launch applicaton url
    When user enter user name
    And user enter password
    And user clicks Login button
    
@Regression   
Scenario: user enter only user name
    Given user launch applicaton url
    When user only enter user name
    And user press login button
    Then Home page will not display
    
@Regression    
Scenario: user enter only password
    Given user launch applicaton url
    When user enter only password
    And user press login button
    Then Home page will not display
    
@functional
Scenario Outline: user enter different character in login form
		Given user launch applicaton url
		When user enter exp "<usernamechar>"
		
Examples:
|usernamechar|
|12356898    |
|OSJKSJKSJ   |
|989565656   |


@Excelread
Scenario Outline: User read data from excel sheet
	Given user launch applicaton url
	When user enter "<SheetName>"
	
	
Examples:
|SheetName|
|login|
|login|
|login|
|login|


@ExecelReading
Scenario Outline: User read data from excel sheet
	Given user launch applicaton url
	When user enter pass excelsheet name and user name from "<SheetsName>" and <Rownumber>
	
	Examples:
	|SheetsName|Rownumber|
	|login|0|
	|login|1|
	|login|2|
	|login|3|

		 