@Sanity
Feature: Myntra website test

@smoketest
Scenario Outline: Myntra t-shirts Search  
Given Open myntra website 
Then Search <product> in search bar
Then click search
And sort by low to high price
Then verify product prices are arranged in ascending order


Examples:
|product|
|tshirt|






