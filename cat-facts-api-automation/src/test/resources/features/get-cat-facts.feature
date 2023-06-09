Feature: Get the details stored for the fact with the specified ID - GET /facts/{id}

  @regressionTest
  Scenario Outline: To get the details stored for a fact with a specified ID
    Given the base url is set as "https://cat-fact.herokuapp.com"
    When a "GET" request is made to the path "/facts/58e007480aac31001185ecef" to list all facts
    Then user should get the response code 200
    And the get a cat fact response values for "<key1>" "<key2>" "<key3>" matches with the value in csv "<csvFileName>"
    Examples:
      | key1 | key2            | key3           | csvFileName       |
      | _id  | user.name.first | user.name.last | csv/cat-facts.csv |


#  Scenario: Verify that 400 bad request response is received for invalid url
#    Given the base url is set as "https://demoqa.com"
#    When a "GET" request is made to the path "/BookStore/v1/Books1234?ISBN=9781449331818" to list all facts
#    Then user should get the response code 400
#
#  Scenario: Verify that 500 internal server response is received
#    Given the base url is set as "https://demoqa.com"
#    When a "GET" request is made to the path "/BookStore/v1/Books1234?ISBN=9781449331818" to list all facts
#    Then user should get the response code 500