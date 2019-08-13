Feature: Login to account
	Existing user should be able to login in to the account
		Existing user should be able to login in to the account

Background: 
	Given User navigates to STackflow website
	And User click on the log in button

@Chrome
Scenario: Log in to the acccount with correct credentils
	And User enter a valid username
	|c.chauhan13@yahoo.com|
	And User enter a valid password
	|Qazwsx11|
	When User click on login button
	Then User should redirect to homepage
@Firefox
Scenario: Log in to the acccount with invalid credentils
	And User enter a valid username
	|chetan_chauhan13@yahoo.com|
	And User enter a valid password
	|Qazwsx11|
	When User click on login button
	Then User should redirect to homepage
#Scenario Outline: Log in to the acccount with correct credentils
# Given User navigates to "<URL>"
# And User click on the log in button
# And User enter a "<UserName>" username
# And User enter a "<Password>" password
# When User click on login button
# Then User should redirect to homepage
# 
# Examples:
# | URL | UserName | Password |
# | https://stackoverflow.com/ | chetan_chauhan13@yahoo.com | Qazwsx11 |
# | https://stackoverflow.com/ | chetan_chauhan13@yahoo.com | Qazwsx11 |
 