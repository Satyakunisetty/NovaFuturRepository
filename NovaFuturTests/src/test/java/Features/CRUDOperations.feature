@ComputerOperations
Feature: Create a computer name using the sample application

  Background: 
    Given user successfully navigates to the application URL

  @AddComputergreenpathscenarios
  Scenario Outline: Create a computer name with out any errors
    When user click on AddANewComputer button
    Then user passes "<Computername>","<Introduced>","<Discontinued>" and "<comapny>" values
    And user clicks on Create this computer button
    And user validates "<DisplayMessage>" on home page

    Examples: 
      | Computername | Introduced            | Discontinued            | comapny       | DisplayMessage                           |
      | Test1        |                       |                         | IBM           | Done ! Computer Test1 has been created   |
      | Test2        |  2001-05-20           |                         |               | Done ! Computer Test2 has been created   |
      | Test3        |                       | 2020-03-31              |               | Done ! Computer Test3 has been created   |
      | Test123      |                       |                         | IBM           | Done ! Computer Test123 has been created |
      | Test345      | 2010-07-21            | 2019-09-29              | RCA           | Done ! Computer Test345 has been created |
      | Test456      | 2010-07-21            | 2019-09-29              |               | Done ! Computer Test456 has been created |
      | Test567      | 2010-07-21            |                         | Canon         | Done ! Computer Test567 has been created |
      | Test678      |                       | 2019-09-29              | Nokia         | Done ! Computer Test678 has been created |

  @AddComputerredpathscenarios
  Scenario Outline: Validate all error messages while creating a computer name
    When user click on AddANewComputer button
    Then user passes "<scenario>" and "<Coulmnname>" to prepare data values
    And user clicks on Create this computer button
    And user validates "<ErrorMessage>" displayed on the screen based on "<scenario>" and "<Coulmnname>"

    Examples: 
      | scenario           | Coulmnname   | ErrorMessage                                                                                                                                           |
      | Empty              | ComputerName | Failed to refine type : Predicate isEmpty() did not fail.                                                                                              |
      | InvalidYearFormat  | Introduced   | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed at index 0                                                |
      | InvalidMonthFormat | Introduced   | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed at index 5                                                |
      | InvalidDayFormat   | Introduced   | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed at index 8                                                |
      | InvalidMonthValue  | Introduced   | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed: Invalid value for MonthOfYear (valid values 1 - 12): $   |
      | InvalidDayValue    | Introduced   | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed: Invalid value for DayOfMonth (valid values 1 - 28/31): $ |
      | InvalidYearFormat  | Discontinued | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed at index 0                                                |
      | InvalidMonthFormat | Discontinued | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed at index 5                                                |
      | InvalidDayFormat   | Discontinued | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed at index 8                                                |
      | InvalidMonthValue  | Discontinued | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed: Invalid value for MonthOfYear (valid values 1 - 12): $   |
      | InvalidDayValue    | Discontinued | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed: Invalid value for DayOfMonth (valid values 1 - 28/31): $ |

  @UpdateComputergreenpathscenarios
  Scenario Outline: Update a computer name with out any errors
    When user search with a "<Computername>"
    And validate search results based on computername
    And user click on filtered search results based on "<Computername>"
    Then user passes "<ComputernameNew>","<Introduced>","<Discontinued>" and "<comapny>" values
    And user clicks on save this computer button
    And user validates "<DisplayMessage>" on home page

    Examples: 
      | Computername | ComputernameNew | Introduced | Discontinued | comapny | DisplayMessage                               |
      | Altair 8800  | Altair 8801     |            |              |         | Done ! Computer Altair 8801 has been updated |
      | Altair 8800  | Altair 8800     | 2010-01-19 |              |         | Done ! Computer Altair 8800 has been updated |
      | Altair 8800  | Altair 8800     |            | 2025-09-16   |         | Done ! Computer Altair 8800 has been updated |
      | Altair 8800  | Altair 8800     |            |              | IBM     | Done ! Computer Altair 8800 has been updated |

  @UpdateComputerredpathscenarios
  Scenario Outline: Update a computer name with out any errors
    When user search with a "<Computername>"
    And validate search results based on computername
    And user click on filtered search results based on "<Computername>"
    Then user passes "<scenario>" and "<Coulmnname>" to prepare data values
    And user clicks on save this computer button
    And user validates "<ErrorMessage>" displayed on the screen based on "<scenario>" and "<Coulmnname>"

    Examples: 
      | Computername | scenario           | Coulmnname   | ErrorMessage                                                                                                                                           |
      | Altair 8800  | Empty              | ComputerName | Failed to refine type : Predicate isEmpty() did not fail.                                                                                              |
      | Altair 8800  | InvalidYearFormat  | Introduced   | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed at index 0                                                |
      | Altair 8800  | InvalidMonthFormat | Introduced   | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed at index 5                                                |
      | Altair 8800  | InvalidDayFormat   | Introduced   | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed at index 8                                                |
      | Altair 8800  | InvalidMonthValue  | Introduced   | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed: Invalid value for MonthOfYear (valid values 1 - 12): $   |
      | Altair 8800  | InvalidDayValue    | Introduced   | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed: Invalid value for DayOfMonth (valid values 1 - 28/31): $ |
      | Altair 8800  | InvalidYearFormat  | Discontinued | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed at index 0                                                |
      | Altair 8800  | InvalidMonthFormat | Discontinued | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed at index 5                                                |
      | Altair 8800  | InvalidDayFormat   | Discontinued | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed at index 8                                                |
      | Altair 8800  | InvalidMonthValue  | Discontinued | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed: Invalid value for MonthOfYear (valid values 1 - 12): $   |
      | Altair 8800  | InvalidDayValue    | Discontinued | Failed to decode date : java.time.format.DateTimeParseException: Text '' could not be parsed: Invalid value for DayOfMonth (valid values 1 - 28/31): $ |

  @DeleteComputergreenpathscenarios
  Scenario Outline: Delete a computer name with out any errors
    When user search with a "<Computername>"
    And validate search results based on computername
    And user click on filtered search results based on "<Computername>"
    And user clicks on Delete this computer button
    And user validates "<DisplayMessage>" on home page

    Examples: 
      | Computername      | DisplayMessage                                     |
      | Altair 8800       | Done ! Computer Altair 8800 has been deleted       |
      | Acer Extensa 5220 | Done ! Computer Acer Extensa 5220 has been deleted |
      | Acer Iconia       | Done ! Computer Acer Iconia has been deleted       |

  @ReadComputergreenpathscenarios
  Scenario Outline: Delete a computer name with out any errors
    When user search with a "<Computername>"
    And validate search results based on computername
    Then user validates the "<ComputerValues>" assigned for the computer

    Examples: 
      | Computername      | ComputerValues                                                        |
      | Altair 8800       | Altair 8800,19 Dec 1974,-,Micro Instrumentation and Telemetry Systems |
      | Acer Extensa 5220 | Acer Extensa 5220,-,-,-                                               |
