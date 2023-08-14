## Create automated scripts to test ecommerce mobile app place order as a guest feature

### write automation script to automate the below scenarios

**Scenario: 01** Customer add products in his shopping cart

> **_Given:_** Mike on home page after opening nopCart mobile app  
> **_When:_** Mike click "electronics" from our categories list from home page  
> **_And:_** Mike click to "Nokia Lumia 1020" product details page  
> **_Then:_** Mike select size "Large" from product details page  
> **_And:_** Mike click plus button to increase Qty by "2"  
> **_Then:_** Mike click add to cart button to add the product in his cart

**Scenario: 02** Customer successfully place order as a guest user

> **_Given:_** Mike go to shopping cart by clicking top cart icon  
> **_When:_** Mike click checkout button from shopping cart page  
> **_And:_** Mike select checkout as guest from shopping cart page  
> **_Then:_** Mike input all the details in checkout billing details page and click continue  
> **_And:_** Mike select "Next Day Air" as shipping method and click continue  
> **_And:_** Mike select "Check/Money Order" as payment method and click continue  
> **_And:_** Mike click next button on payment information page  
> **_Then:_** Mike click confirm button to place the order  
> **_And:_** Verify order place successfully with popup message "Your order has been successfully processed!"

### Additional functionalities, that may be covered:

1. The more, the better. Only if it makes sense. Use your imagination and write some additional tests if you feel you
   can cover other important functionalities.
2. Please include any third party test reporting tools(Ex. Extent Report, Allure report) in your automation project.
3. Please use Excel/csv file as external test data provider and your automation script have the ability to read and
   write data from excel/csv for above scenario(Ex. Billing/shipping address and all the quoted value in scenario step
   can be read from excel as test data)

### Using automation framework is a must:

You can feel free to choose the framework with page object modal design pattern, that suits you best, along with the
Java or other programming language as you preferred.

### Record a video of tests execution:

Record a video to show how your tests are interacting with the mobile app(In Emulator). Attach the video as part of your
solution.

