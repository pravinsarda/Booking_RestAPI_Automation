# Booking_RestAPI_Automation
This is Rest assured API Automation test framework for Restful-booker APIs

#### Requirement
- Documentation of [Restful-booker](https://restful-booker.herokuapp.com/apidoc/index.html )
- refer "Booking TCs" excel sheet in the project

#### Required software:

- JAVA as the programming language for writing test code
- RestAssured library to test REST APIs
- TestNg as the framework
- java-faker to generate fake data
- Maven as the build tool
- IntelliJ as the preferred IDE for writing java code.
- Extent library as the testing report strategy
- lombok-intellij-plugin -> this plugin in IntelliJ recognize all of generated getters, setters.


#### Getting Started

#### Setup your machine:

- Install JDK 11
- Install [IntelliJ](https://download.jetbrains.com/idea/ideaIC-2020.3.4.exe?_gl=1*1spo3x*_ga*MTkzMDEyNDY5LjE2ODI3NjM3NjE.*_ga_9J976DJZ68*MTY4Mjc2Mzc2MS4xLjEuMTY4Mjc2Mzc2My4wLjAuMA..&_ga=2.44128036.1833959567.1682763761-193012469.1682763761) (Community edition is fine) (version 2020.3.4)
- Install Maven

### Cloning & Importing the Project

- Clone the project from git clone https://github.com/pravinsarda/Booking_RestAPI_Automation.git
- Import the project (\Booking_RestAPI) in IntelliJ File -> New -> Project from Existing Sources -> Browse Project Location -> pom.xml
- Now click on auto import -> Ok wait until the IntelliJ downloads all the dependencies
- Execute test -> java -> com.tc.testScripts -> BookingTestScript.java

### Booking_RestAPI_Automation Structure

- Please refer "Booking_RestAPI_Automation Flow Chart" image from the project.

--> Src
	--> main
		--> java
			--> com.tc
				 --> base
				 --> constants
				 --> enum
				 --> extentReports
				 --> listeners
				 --> pages
				 --> requestBody
				 --> utils
    --> test
        --> java
			--> com.tc.testScripts
				 --> BookingTestScript
-->target
	-->BookingTestReport.html
	
### Packages	
#### base Package:
1. Class BaseService : This class represents used basic component of API such as start session, create all required things to use for API calls. (Request specifications)
 buildService()  - This method setting up Prerequisite for API Call.
 setHeader() - used for Auth Token Setup.
 setBody() - set body to request specification builder
 executeAPI() - high level call of respective request type (Post, get, put, delete) and return the response.


#### constants Package:
1. class API_Endpoints - stored all URLs
2. class FilePaths - used for the file paths here for report file generation path
3. class StatusCode - keep all request status code which need to verify

#### enum Package:
enum Class HTTPMethod - contain GET, PUT, DELETE as group of HTTP Request constants.  

#### extentReports Package:
1. class ExtentManager
 initExtentReports() - initialization/ format of extent html report 
 flushReport() - delete existing report before create new one
 getCurrentTest() - return current extentTest class object
 createTestCase() - test case details window name "Test Case Steps" 
 testSuccess() - Test Case Executed Successfully
 testSkip() - Test Case Skipped
 testFail() - Test Case Failed
  
2. class ExtentLogger
logRequestBody() - generate report of request body
logResponseBody() -  generate report of response body
logMessage() - to write log message in the report

#### listeners Package :
 TestNG listener methods to add into extent report. 
 
#### pages Package:
1. Class CommonService - extends BaseService class to use basic component of API methods
	getAccessToken() - use to generate authentication token into cookies
	
2. Class PageService - extends CommonService class to get authentication token and able to use use basic component of API methods which define into grand parent class of BaseService. 
createBooking() - actual create booking request(POST) pass with data(payload) and return the response  
getBookingId() - reuqest get booking id (GET) as return in the response
updateBookingDetails() - update booking details (PUT) with pasing updated data(payload) using authentication.
deleteBookingId() - do the delete booking using id, need first to be authentication.
setTokenInCookies() - to pass authentication token to setHeader(cookies) method

#### requestBody Package: 
This used to work as POJO classes.
1. Class CreatBookingRequest - used to set & get all data related booking except booking dates
2. Class Bookingdates - set and get booking dates as checkin and checkout.

#### utils Package:
1. Class TestData - created random data from faker class to use as test data.

#### testScripts Package:
class BookingTestScript  - Initial point to call each test case i.e. createBookingTest(), getBookingIdTest().

### Enhancement
1. Use properties file to set and get API URLs
2. Get Testdata from Excel sheet 

