package testcases

import geb.spock.GebReportingSpec
import snapdealPage.HomePage
import snapdealPage.SubMenuPage

/**
 * Created by abhilashk on 8/3/2016.
 */
class SnapdealSuite extends GebReportingSpec {

    def setup() {
        browser.driver.manage().window().maximize()
    }

    def selectTopRatedForGivenProductType() {
        given: "Navigate to Base url"
        to HomePage
        when: "Hover on specified Menu"
        //gotoMenu("Computers, Office & Gaming")
          gotoMenu()
        and: "Select submenu"
       // gotoSubMenu("Laptops")
        gotoSubMenu()
        and: "Select ViewAll option"
        at SubMenuPage
        selectViewAllOption()
        and: "Enter Price Range"
        selectPriceRange()
        and: "Filter by Customer Rating"
        customerRatingFilter()
        and: "Select Top Rated product"
        selectTopRatedProduct()
        and:"Get Top rated ProductName"
        getProductName()
        then:"Validate the top rated product with 5 star"
        validateWithFiveStarRating()
        //validateWithFiveStarRating()=="5.0"
    }
}
