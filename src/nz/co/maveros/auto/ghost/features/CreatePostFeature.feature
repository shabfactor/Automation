Feature: User should be able to create new draft post when logged in

  Scenario: User creates post through navigation menu
    Given valid user logged in
    When user click new post link on navigation menu
    And type title and content inside editor
    #And click save draft button
    #Then a new draft post is created

  #Scenario: User creates post through new post button
   # Given valid user logged in
    #When user click new post button
    #And type title and content inside editor
    #And click save draft button
    #Then a new draft post is created
