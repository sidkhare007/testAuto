Feature: Users API

  Scenario: Get single user
    When I GET "/api/users/2"
    Then the response status should be 200
    And the JSON path "data.id" should be 2
