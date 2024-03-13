Feature: Search and add product to the cart

@PlaceOrder
Scenario Outline: Search experience for product and adding them to cart
Given User is on GreenKart landing page
When User search with shortname <VegName> and extracted actual name of product
Then User add <Count> more items of product and add them to cart
And Open the cart and proceed to checkout
Then Validate the product name in cart page matches with landing page
And Verify user has ability to enter promo code and place order
Examples:
|VegName|Count|
|Tom		|3		|
