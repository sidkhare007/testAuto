@ui
Feature: Homepage smoke

  Scenario: Open homepage and verify title
    Given I open the home page
    Then the page title should contain "Example"
