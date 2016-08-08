/**
 * Created by abhilashk on 8/3/2016.
 */
package snapdealPage

import Utils.Utilities
import geb.Page
import geb.error.RequiredPageContentNotPresent
import jxl.Cell
import jxl.Sheet
import jxl.Workbook
import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import snapdealModule.SubMenuModule

class SubMenuPage extends Page{
    Utilities util = new Utilities()
    static at={$("a.color-white")[0]}
    static content ={
        subMenuPageObjects {module SubMenuModule}
    }

    /*
    This method waits for particular to be displayed in a specified time
     */
    def sync(def element)
    {
        try {
            waitFor(10) {
                element.isDisplayed()
            }
        }catch (RequiredPageContentNotPresent e)
        {
            print("Object is not present or not loaded in given time " +element)
        }
    }

    /*
    This method selects all options available for the selected submenu
     */
    def selectViewAllOption()
    {
//        sync(subMenuPageObjects.viewAll)
//        subMenuPageObjects.viewAll.click()
        util.safeClick(subMenuPageObjects.viewAll)
    }

    /*
    This method is used for entering price range
     */
    def selectPriceRange()
    {
        String from=util.getPriceFrom()
        String to=util.getPriceTo()
        sync(subMenuPageObjects.priceFrom)
        subMenuPageObjects.priceFrom.firstElement().clear()
        subMenuPageObjects.priceFrom.value(from)
        sync(subMenuPageObjects.priceUpTo)
        subMenuPageObjects.priceUpTo.firstElement().clear()
        subMenuPageObjects.priceUpTo.value(to)
        //sync(subMenuPageObjects.search)
        //subMenuPageObjects.search.click()
        util.safeClick(subMenuPageObjects.search)
        sleep(1000)
    }

    /*
    This method is used for selecting top rated product from the list of available products
     */
    def selectTopRatedProduct()
    {
        List<WebElement> products=subMenuPageObjects.productsList
        float previous
        int key
        if (products.size()==0)
        {
            util.safeClick(products.get(key).findElement(By.cssSelector(".product-title")))
            //products.get(key).findElement(By.cssSelector(".product-title")).click()
        }
        else {
            try {
                for (int i = 0; i < products.size(); i++) {

                    String str = products.get(i).findElement(By.cssSelector(".filled-stars")).getAttribute("style").split(":")[1].trim().replace("%", "").replace(";", "")
                    float val = Float.parseFloat(str)
                    //double val=Double.parseDouble(str)
                    if (i == 0) {
                        previous = val
                        key = i
                    }

                    if (i > 0) {
                        if (previous < val) {
                            key = i
                            previous = val
                        }
                    }
                }
                util.safeClick(products.get(key).findElement(By.cssSelector(".product-title")))
                //products.get(key).findElement(By.cssSelector(".product-title")).click()
            }
            catch (Exception e)
            {
                print("Exception in finding highest rated value i.e., provided invalid pattern in split() ")
            }
        }
    }


    /*
    This method is used for selecting customer rating
     */
    def customerRatingFilter()
    {
//        sync(subMenuPageObjects.expandCustomerRatingSection)
//        subMenuPageObjects.expandCustomerRatingSection.click()
        util.safeClick(subMenuPageObjects.expandCustomerRatingSection)
//        sync(subMenuPageObjects.customertRatingRadioButton)
//        subMenuPageObjects.customertRatingRadioButton.click()
        util.safeClick(subMenuPageObjects.customertRatingRadioButton)
        sleep(1000)

    }

    /*
    This method is for getting top rated product name and its rating
     */

    def getProductName() {
        println(subMenuPageObjects.productTitle.text())
        util.safeClick(subMenuPageObjects.ratingLink)
        //subMenuPageObjects.ratingLink.click()
        sleep(1000)
    }

    def validateWithFiveStarRating()
    {
        String actualRating=subMenuPageObjects.ratingValue.text()
        print(actualRating)
        if(actualRating=="5.0")
        {
            return true
        }
        else {
            return false
        }
    }
}
