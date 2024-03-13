Feature: Search and place the order for products

@OfferPage
Scenario Outline: Search experience for product search in both Home and Offers page

Given User is on GreenKart landing page
When User search with shortname <VegName> and extracted actual name of product
Then User search for same shortname in offers page
And Validate product name in offers page matches with landing page
Examples:
|VegName|
|Tom		|
|Beet		|