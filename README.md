# Automation


#1)Install Java 17 and set Environment Path Variable
#2)Install Maven and set Environment Path Variable
#3)Install Allure Reports and set Environment Path Variable
#4)Install Chrome,Firefox and Edge Browsers
#5)Compile the Project using below command
mvn clean install -DskipTests
#6)Execute the Project using below command from root directory.
mvn clean test
#7)Generate Allure Reports using below command
allure serve

NOTE:If you want to run Tests parellely,you need to change parellel=tests in testng.xml and make Before annotation change to BeforeTest
If you want to run Classes parellely,you need to change parellel=classes in testng.xml and make BeforeTest annotation change to BeforeClass.
If you want to run Methods parellely,you need to change parellel=methods in testng.xml and make BeforeTest annotation change to BeforeMethod.
NOTE: Same needs to be done with After annotations as well.


You are good to go.