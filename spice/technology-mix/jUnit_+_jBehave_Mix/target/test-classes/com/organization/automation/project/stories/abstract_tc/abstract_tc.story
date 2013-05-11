Abstract TC Story

Meta:
@tag component:abstract_tc

Narrative:
In order to develop a tiny test automation framework
As a framework developer
I want to use jBehave core API

Scenario: Abstract TC works
Given abstract test case with id #1
When abstract test case run
Then result should be [PASS]

Scenario: Abstract TC with examples works
Given abstract test case with id #<id> and name '<tc_name>'
When abstract test case run
Then result of exemplified TC should be [<result>]

Examples:
| id  | tc_name       |result |
|  1  | The first TC  |PASS   |
|  2  | The second TC |PASS   |
|  3  | The third TC  |PASS   |
