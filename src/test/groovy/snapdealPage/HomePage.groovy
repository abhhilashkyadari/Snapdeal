package snapdealPage

import geb.Page
import snapdealModule.HomePageModule

/**
 * Created by abhilashk on 8/3/2016.
 */
class HomePage extends Page{
    static at = {title=="Online Shopping in India at Snapdeal - Buy Books, Mobiles, Laptops, Apparel, Watches, Footwear, Recharge, Bill Payments & More"}
    //static at = {$("title").text().startsWith("Online Shopping in India at Snapdeal")}

    static content={
        homePageObjects {module HomePageModule}
    }
    /*
    this function verifes whether user is navigated to Home page or not
     */
    def gotoMenu(def menu)
    {
        interact {
            moveToElement(homePageObjects.menuLink(menu))
        }
    }

    def gotoSubMenu(def submenu)
    {
        homePageObjects.submenuLink(submenu).click()
    }

}
