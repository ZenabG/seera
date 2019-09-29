Below are the software versions I have used:
1) Java version 1.8.0_161
2) Chrome browser version 77.0.3865.90
3) ChromeDriver 76.0.3809.126
4) Firefox browser version 60.0.2
5) Also, please check pom.xml for frameworks used and their versions


Explanation of project structure:

->It is a maven project with 2 parts in src - main and test

1) main consists of 3 packages - Locators, Page methods and resources
     a) Locators consists of page object classes separate for Tajawal and Almosafer
     b) Page methods consists of one class for each page - HomePage, FlightListingPage, FlightDetailsPage
     c) resources consists of BaseClass, Constants and Utilities
     d) BaseClass consists of all the methods needed for driver set up, extent report set up and in the end killing the driver instance.
     e) Constants consists of data for contact details page and passing values for passenger etc.
     f) Utilities consists of all the java functions used in test like generating random number, generating random dates, splitting string etc.

2) test consists of 3 classes - homePageLogic, Scenario1, Scenario2
    a) homePageLogic consists of common steps performed on home page for both scenario1 and scenario2.
    b) scenario1 is the first test from code challenge link
    c) scenario2 is the second test from code challenge link 

3) There are 3 testng xmls - chromesuite, firefoxsuite and allsuites
    a) chromesuite contains scenario1 and scenario2 tests run with tajawal and almosafer websites. There is a enabled attribute for selecting which test to execute 
    b) firefoxsuite contains scenario1 and scenario2 tests run with tajawal and almosafer websites. There is a enabled attribute for selecting which test to execute
    c) allsuites contains logic for executing both the above suites together

4) After the test script execution is done, it will generate extent report in folder test-extent. I haven't added screenshots at each step but only in case test fails.

5) screenshots folder has all screenshots. Screenshot is generated only if the test fails.


Important points:
-> The test will fail if the search criteria does not bring any search result for flight listing. It is not handled, I just saw that possibility while checking the tests one last time today morning. But it can be handled. In case the search result is empty please re run the test.
-> data is generated using random functions as was the requirement
-> some data fields are populated using Constants file, as there was not much data I did not use excel but that can also be used
-> Frameworks used are selenium, TestNG
-> Import the project in any ide supporting java and run as testng test or suite.

Please feel free to email me in case any more info needed at zenabkale@gmail.com. Thanks.