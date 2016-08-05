package testcases

import geb.spock.GebReportingSpec
import snapdealPage.HomePage
import snapdealPage.SubMenuPage

/**
 * Created by abhilashk on 8/3/2016.
 */
class SampleTestSuite extends GebReportingSpec {

    def setup() {
        browser.driver.manage().window().maximize()
    }

    def selectTopRated() {
        given: "Navigate to Base url"
        to HomePage
        when: "Hover on specified Menu"
        gotoMenu("Computers, Office & Gaming")
        and: "Select submenu"
        gotoSubMenu("Laptops")
        and: "Select ViewAll option"
        at SubMenuPage
        selectViewAllOption()
        and: "Enter Price Range"
        selectPriceRange(25000, 40000)
        and: "Filter by Customer Rating"
        customerRatingFilter()
        selectTopRatedProduct()
        getProductNameAndCheckRating()
        then:"Get top rated productname and check its rating with 5 star"
    }
}
