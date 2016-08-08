package snapdealPage

import Utils.Utilities
import geb.Page
import snapdealModule.HomePageModule

/**
 * Created by abhilashk on 8/3/2016.
 */
class HomePage extends Page{
    Utilities util = new Utilities()
    static at = {title=="Online Shopping in India at Snapdeal - Buy Books, Mobiles, Laptops, Apparel, Watches, Footwear, Recharge, Bill Payments & More"}
    //static at = {$("title").text().startsWith("Online Shopping in India at Snapdeal")}

    static content={
        homePageObjects {module HomePageModule}
    }
    /*
    this function verifes whether user is navigated to Home page or not
     */
    def gotoMenu()
    {
        String menu=util.getMenu()
        print(menu)
        interact {
            moveToElement(homePageObjects.menuLink(menu))
        }
    }

    def gotoSubMenu()
    {
        String submenu=util.getSubMenu()
        util.safeClick(homePageObjects.submenuLink(submenu))
        //homePageObjects.submenuLink(submenu).click()
    }
}
