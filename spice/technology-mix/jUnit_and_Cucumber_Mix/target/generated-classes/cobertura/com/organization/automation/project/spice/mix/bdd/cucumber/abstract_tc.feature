@abstract_tc
Feature: Developer create automation framework
  As a Test Automation Framework developer
  I want to use Cucumber core API
  So that I develop a tiny test automation framework

  Scenario: Abstract TC works
    Given abstract test case with id "1"
    When abstract test case run
    Then result should be "PASS"

  Scenario Outline: Abstract TC with examples works
    Given abstract test case with id <id>
    And name <tc_name>
    When abstract test case run
    Then result of exemplified TC should be <result>

  Examples:
    | id  | tc_name       |result |
    |  1  | The first TC  |PASS   |
    |  2  | The second TC |PASS   |
    |  3  | The third TC  |PASS   |
