# Monster Works demo automation test

**Disclaimer:** This repository is temporary.

## Technologies
- [Java 11](https://www.oracle.com/java/technologies/javase-downloads.html)
- [TestNG](https://testng.org/doc/)
- [Selenide](https://selenide.org/)
- [Maven](https://maven.apache.org/)

## Usage 

To run tests without problems is recommended using Maven. For Maven installation you can follow this [guide](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

**Running All Tests**

To run all tests navigate inside project folder and run
```
mvn clean test
```
Test results are saved in _target/allure-results_

## Reports
For reporting is used [Allure Framework](https://docs.qameta.io/allure/). There are two ways how to generate reports

**Temporary Reports**

For temporary results run following command which will start local server with report.
```
mvn allure:serve
```
 
**Permanent Reports**

Reports can be also generated inside _/allure-reports_ folder with
```
mvn allure:generate
```

## Encountered Issues
- Some jobs has different title and id on job search results page and _Saved Jobs_ page.
- [Monster Works Demo](https://www.monsterworksdemo.com/) does not load properly sometimes.