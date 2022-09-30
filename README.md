
# Movie Information Validation

Imdb and Wikipedia are the sources to get the details of the movie:Pushpa: The Rise.

# Tools and technologies used:

Language: Java 8
Testing framework: Testng
Automation tool: Selenium webdriver
Build tool: maven
Reporting: Avent stack

# Features of the framework
1. XML-based test configuration.
2. Screenshot would be taken if any scenario failed and saved under /screenshots folder.
3. Html report gets generated after each test run and can be found /Reports/AutomationReport.html
4. Tests can run through command line with maven commands.
                                                            
### package: drivers 
 It has exe of chromedriver. This is required while creating the webdriver session.

### package: Reports
It has the report which will be generated after running the test.


### package: screenshots
It will have the screenshots after the test case will fail.

### package: Page Events
It includes the methods which are required by test to perform actions. 

### package: Page Objects
It has web elements corresponding to the specific page which is used by corressponding logic classes.
 
### package: Utils
 It has the methods to fetch the elements and to capture the screenshots on failure.

### package: test.java
 Features/tests to be executed are defined in this class. Other test configurations are also defined here.

### pom.XML
It contains information about the project and configuration details used by Maven to build the project.

# Setting up the project
Install the maven and clone the build then:

$ cd TestVagrantAutomation

$ mvn clean install