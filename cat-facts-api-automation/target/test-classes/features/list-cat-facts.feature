Feature: List all the facts stored in the database- GET {/facts}

  @smokeTest
  Scenario Outline: To get the list of all the cat facts stored in the database
    Given the base url is set as "https://demoqa.com"
    When a "GET" request is made to the path "/BookStore/v1/Books" to list all facts
    Then user should get the response code 200
    And the "<listName>" array containing "<key1>","<key2>","<key3>" matches with the values in csv "<csvFile>"
    Examples:
      | listName | key1 | key2  | key3     | csvFile       |
      | books    | isbn | title | subTitle | csv/books.csv |
