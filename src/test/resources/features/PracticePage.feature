Feature:
  Practice page functionality

  Scenario: Verify that each like is working properly
    Given user is on the home page
    When user clicks on "A/B Test" link
    Then user should be able to see "abtest" in url