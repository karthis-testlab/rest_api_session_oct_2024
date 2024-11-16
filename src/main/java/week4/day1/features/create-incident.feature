Feature: Create the new record in the incident table using service now api

  Background: 
    Given User set the the baseuri and baseurl of the servicenow api
    And the user set the basic authentication for the servicenow api

  @smoke @regression
  Scenario: Validate user able to create new record with out request body
    When sent the post request without body to the servicenow server
    Then the user successfully create one incident new record into the table

  @regression
  Scenario Outline: Validate user able to create new record with request body
    When send the post request with the descreprtion <description_name> in the request payload
    And send the post request with the short descreprtion <shot_description_name> in the request payload
    Then the user successfully create one incident new record into the table

    Examples: 
      | description_name | shot_description_name |
      | Description 1    | Short Description 1   |
      | Description 2    | Short Description 2   |
