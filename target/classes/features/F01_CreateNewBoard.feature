@group1
Feature: Simple Books API Testing


  Scenario:  Authenticated User Could Submit order on available books
    #Step1 : i'm authenticated user
    Given    I am an authenticated user
    #Step2 : Select available book and get id
    When     select available book and get id
    #Step3 : submit valid order on selected book
    Then     Submit valid order on selected book
