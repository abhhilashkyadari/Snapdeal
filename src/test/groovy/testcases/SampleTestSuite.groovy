package testcases

import geb.spock.GebReportingSpec
import snapdealPage.HomePage
import snapdealPage.MobilePhonesPage

/**
 * Created by abhilashk on 8/3/2016.
 */
class SampleTestSuite extends GebReportingSpec {

    def setup() {
        browser.driver.manage().window().maximize()
    }

    def selectMobileByPriceRange() {
        given: "Navigate to Base url"
        to HomePage
        when: "Hover on specified Menu"
        gotoMenu("Mobiles & Tablets")
        and: "Select submenu"
        gotoSubMenu("Mobile Phones")
        and: "Select a price range for mobiles"
        to MobilePhonesPage
        selectPriceRange("Rs 5000-10000")
        then:""
    }

    def cleanup()
    {
        browser.driver.close()
    }
}
