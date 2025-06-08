<!-- ABOUT THE PROJECT -->
## About The Project
This project provides a robust and scalable automation framework for both API and UI testing, built with Java, Maven, TestNG, RestAssured, Selenium WebDriver, and Allure for reporting.
## About The Project

## Key Features:
* API Testing: Powered by RestAssured for comprehensive API validation (GET, POST, PUT, PATCH, DELETE).
* Parallel Execution: Configurable via testng.xml for running tests concurrently.
* Robust Configuration: Externalized settings in config.properties for easy environment management.
* Readable Reporting: Integrated with Allure Report for detailed and interactive test results.
* Scalable Structure: Organized packages and helper classes promote code reusability and maintainability.

 ## Prerequisites
Before you can run the tests, ensure you have the following installed:

* Java Development Kit (JDK) 11 or higher: Download and install from Oracle JDK or OpenJDK.
* Apache Maven 3.6.0 or higher: Download and install from Maven Official Site.
* Git (Optional, but recommended for version control): Download and install from Git Official Site.
* Allure Commandline (Optional, for local report viewing): Download and install from Allure GitHub Releases. Add to your system's PATH.

## Getting Started
Follow these steps to set up and run the framework locally.
##  Clone the Repository
Clone the repository
   ```sh
   git clone https://github.com/Mxoleli/api-restassured.git
   ```
   ## Install Dependencies
  ```shell
   mvn clean install
   ```
   ## 🚀 How to Run Tests
   ```shell
   mvn clean test
   ```
   ##  Allure Reporting
   ```shell
   mvn allure:report
   ```
  ##  View the Report
   ```shell
   mvn allure:serve
   ```
