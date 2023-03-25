#cat facts api automation

This framework is written using Cucumber BDD, Rest Assured in Java

Test Strategy:

BDD framework aimed at creating easy to implement feature files in **Gherkin** language for testing APIs
Feature file can be extended to test and validate different scenarios for API status codes like 201,500,400 etc as per the requirement
**Tags** are added to facilitate execution of specific tests (regression test, smoke test etc)
**Scenario outline** is used to perform data driven testing
Certain steps can be **reused** across different feature files to test different API methods like GET, POST, DELETE, PATCH etc
Currently cucumber reporting is used.
Logger is added
**utilities** package: CSVManager class is added to manage the CSV file against which the comparison of GET and List requests are made

**support** package: Support classes can be added in support package to add more feature support for the framework
**RequestResponseWorld** class - GET and SET the api request, response, url, path objects and attributes

**OpenCSV** library is used to perform CSV operations

**lombok** library is used to generate getters and setters automatically
Currently Json response is saved in a list of hashmap and compared against the CSV Record stored in another list of hashmap
More validations and logging can be added to display the error messages if the comparison fails



Framework has the capability to be extended for :
Adding reporting using extent reports or allure reports
More detailed logging for error messages
Parallel execution of feature files


To run all feature files from command line or Jenkins Pipeline
**mvn clean test**

To run a feature file with a specific **tag**(example: @smokeTest), run
**mvn clean test -Dcucumber.options="--tags @smokeTest"**

Cucumber Test report can be found under "target/test-report/cucumber-reports.html"

Tests:

get-cat-facts.feature - Get the details stored for the fact with the specified ID - **GET /facts/{id}**
list-cat-facts.feature - List all the facts stored in the database- **GET {/facts}**

