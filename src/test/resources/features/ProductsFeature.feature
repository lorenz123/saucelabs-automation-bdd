@product
Feature: Products Feature

  Scenario: Verify that products are displayed with full details
    Given User is already logged in successfully
    When User browses to the Products page
    Then User should be able to view the products with full details