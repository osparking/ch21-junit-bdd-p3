#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: 승객 탑승 정책
  항공사는 승객 등급별로 항공편 종류에 따라 탑승 및 취소 정책을 가지고 있다

  @tag1
  Scenario: 경제적 항공편, 일반 승객
    Given 경제적 항공편이 한대 있다
    When 일반등급 승객이 한명 도착했다
    Then 일반등급 승객을 경제적 항공편에 탑승 및 취소할 수 있다
