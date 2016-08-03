package snapdealPage

import geb.Page
import snapdealModule.MobilePhonesModule

/**
 * Created by abhilashk on 8/3/2016.
 */
class MobilePhonesPage extends Page{
    static url="products/mobiles-mobile-phones"
    static at={$("h1").text() == "Mobile Phones"}
    static content ={
        mobilePhonesPage {module MobilePhonesModule}
    }

    def selectPriceRange(def range)
    {
        mobilePhonesPage.priceRage(range).click()
    }

}
