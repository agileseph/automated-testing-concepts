$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com\\organization\\automation\\project\\spice\\mix\\bdd\\cucumber\\abstract_tc.feature");
formatter.feature({
  "id": "developer-create-automation-framework",
  "tags": [
    {
      "name": "@abstract_tc",
      "line": 1
    }
  ],
  "description": "As a Test Automation Framework developer\nI want to use Cucumber core API\nSo that I develop a tiny test automation framework",
  "name": "Developer create automation framework",
  "keyword": "Feature",
  "line": 2
});
formatter.scenario({
  "id": "developer-create-automation-framework;abstract-tc-works",
  "description": "",
  "name": "Abstract TC works",
  "keyword": "Scenario",
  "line": 7,
  "type": "scenario"
});
formatter.step({
  "name": "abstract test case with id \"1\"",
  "keyword": "Given ",
  "line": 8
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 28
    }
  ],
  "location": "AbstractTCSteps.initializeTestCase(String)"
});
formatter.result({
  "duration": 445367777,
  "status": "passed"
});
formatter.step({
  "name": "abstract test case run",
  "keyword": "When ",
  "line": 9
});
formatter.match({
  "location": "AbstractTCSteps.whenAbstractTestCaseRun()"
});
formatter.result({
  "duration": 60902,
  "status": "passed"
});
formatter.step({
  "name": "result should be \"PASS\"",
  "keyword": "Then ",
  "line": 10
});
formatter.match({
  "arguments": [
    {
      "val": "PASS",
      "offset": 18
    }
  ],
  "location": "AbstractTCSteps.checkTC(String)"
});
formatter.result({
  "duration": 161194,
  "status": "passed"
});
formatter.scenario({
  "id": "developer-create-automation-framework;abstract-tc-with-examples-works;;2",
  "tags": [
    {
      "name": "@abstract_tc",
      "line": 1
    }
  ],
  "description": "",
  "name": "Abstract TC with examples works",
  "keyword": "Scenario Outline",
  "line": 20,
  "type": "scenario"
});
formatter.step({
  "name": "abstract test case with id 1",
  "keyword": "Given ",
  "line": 13,
  "matchedColumns": [
    0
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 27
    }
  ],
  "location": "AbstractTCSteps.inputTC(int)"
});
formatter.result({
  "duration": 2048585,
  "status": "passed"
});
formatter.step({
  "name": "name The first TC",
  "keyword": "And ",
  "line": 14,
  "matchedColumns": [
    1
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "The first TC",
      "offset": 5
    }
  ],
  "location": "AbstractTCSteps.andName(String)"
});
formatter.result({
  "duration": 143593,
  "status": "passed"
});
formatter.step({
  "name": "abstract test case run",
  "keyword": "When ",
  "line": 15
});
formatter.match({
  "location": "AbstractTCSteps.whenAbstractTestCaseRun()"
});
formatter.result({
  "duration": 38273,
  "status": "passed"
});
formatter.step({
  "name": "result of exemplified TC should be PASS",
  "keyword": "Then ",
  "line": 16,
  "matchedColumns": [
    2
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "PASS",
      "offset": 35
    }
  ],
  "location": "AbstractTCSteps.checkExamplifiedTC(String)"
});
formatter.result({
  "duration": 133257,
  "status": "passed"
});
formatter.scenario({
  "id": "developer-create-automation-framework;abstract-tc-with-examples-works;;3",
  "tags": [
    {
      "name": "@abstract_tc",
      "line": 1
    }
  ],
  "description": "",
  "name": "Abstract TC with examples works",
  "keyword": "Scenario Outline",
  "line": 21,
  "type": "scenario"
});
formatter.step({
  "name": "abstract test case with id 2",
  "keyword": "Given ",
  "line": 13,
  "matchedColumns": [
    0
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 27
    }
  ],
  "location": "AbstractTCSteps.inputTC(int)"
});
formatter.result({
  "duration": 239696,
  "status": "passed"
});
formatter.step({
  "name": "name The second TC",
  "keyword": "And ",
  "line": 14,
  "matchedColumns": [
    1
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "The second TC",
      "offset": 5
    }
  ],
  "location": "AbstractTCSteps.andName(String)"
});
formatter.result({
  "duration": 138286,
  "status": "passed"
});
formatter.step({
  "name": "abstract test case run",
  "keyword": "When ",
  "line": 15
});
formatter.match({
  "location": "AbstractTCSteps.whenAbstractTestCaseRun()"
});
formatter.result({
  "duration": 39111,
  "status": "passed"
});
formatter.step({
  "name": "result of exemplified TC should be PASS",
  "keyword": "Then ",
  "line": 16,
  "matchedColumns": [
    2
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "PASS",
      "offset": 35
    }
  ],
  "location": "AbstractTCSteps.checkExamplifiedTC(String)"
});
formatter.result({
  "duration": 110908,
  "status": "passed"
});
formatter.scenario({
  "id": "developer-create-automation-framework;abstract-tc-with-examples-works;;4",
  "tags": [
    {
      "name": "@abstract_tc",
      "line": 1
    }
  ],
  "description": "",
  "name": "Abstract TC with examples works",
  "keyword": "Scenario Outline",
  "line": 22,
  "type": "scenario"
});
formatter.step({
  "name": "abstract test case with id 3",
  "keyword": "Given ",
  "line": 13,
  "matchedColumns": [
    0
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 27
    }
  ],
  "location": "AbstractTCSteps.inputTC(int)"
});
formatter.result({
  "duration": 195556,
  "status": "passed"
});
formatter.step({
  "name": "name The third TC",
  "keyword": "And ",
  "line": 14,
  "matchedColumns": [
    1
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "The third TC",
      "offset": 5
    }
  ],
  "location": "AbstractTCSteps.andName(String)"
});
formatter.result({
  "duration": 116216,
  "status": "passed"
});
formatter.step({
  "name": "abstract test case run",
  "keyword": "When ",
  "line": 15
});
formatter.match({
  "location": "AbstractTCSteps.whenAbstractTestCaseRun()"
});
formatter.result({
  "duration": 32686,
  "status": "passed"
});
formatter.step({
  "name": "result of exemplified TC should be PASS",
  "keyword": "Then ",
  "line": 16,
  "matchedColumns": [
    2
  ]
});
formatter.match({
  "arguments": [
    {
      "val": "PASS",
      "offset": 35
    }
  ],
  "location": "AbstractTCSteps.checkExamplifiedTC(String)"
});
formatter.result({
  "duration": 100851,
  "status": "passed"
});
});