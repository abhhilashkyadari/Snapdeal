/**
 * Created by abhilashk on 8/3/2016.
 */
package snapdealPage
import geb.Page
import geb.error.RequiredPageContentNotPresent
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import snapdealModule.SubMenuModule

class SubMenuPage extends Page{
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
        sync(subMenuPageObjects.viewAll)
        subMenuPageObjects.viewAll.click()
    }

    /*
    This method is used for entering price range
     */
    def selectPriceRange(def from, def to)
    {
        sync(subMenuPageObjects.priceFrom)
        subMenuPageObjects.priceFrom.firstElement().clear()
        subMenuPageObjects.priceFrom.value(from)
        sync(subMenuPageObjects.priceUpTo)
        subMenuPageObjects.priceUpTo.firstElement().clear()
        subMenuPageObjects.priceUpTo.value(to)
        sync(subMenuPageObjects.search)
        subMenuPageObjects.search.click()
        sleep(1000)
    }

    /*
    This method is used for selecting top rated product from the list of available products
     */
    def selectTopRatedProduct()
    {
        List<WebElement> products=subMenuPageObjects.productsList
        float compare=0.0
        int key
        for(int i=0;i<products.size();i++){
            String str=products.get(i).findElement(By.cssSelector(".filled-stars")).getAttribute("style").split(":")[1].trim().replace("%","").replace(";","")
            float val= Float.parseFloat(str)
            //double val=Double.parseDouble(str)
            if (i==0)
            {
                compare=val
                key=i
            }
            if(i!=0)
            {
                if(val>compare)
                {
                    compare=val
                    key=i
                }
                //print(key+ "   "+val)
            }
        }
        println(key)
        products.get(key).findElement(By.cssSelector(".product-title")).click()

    }

    /*
    This method is used for selecting customer rating
     */
    def customerRatingFilter()
    {
        sync(subMenuPageObjects.expandCustomerRatingSection)
        subMenuPageObjects.expandCustomerRatingSection.click()
        sync(subMenuPageObjects.customertRatingRadioButton)
        subMenuPageObjects.customertRatingRadioButton.click()
        sleep(1000)
    }

    /*
    This method is for getting top rated product name and its rating
     */

    def getProductNameAndCheckRating()
    {
        println(subMenuPageObjects.productTitle.text())
        subMenuPageObjects.ratingLink.click()
        //sync(subMenuPageObjects.ratingValue)
        sleep(1000)
        float actualRating=Float.parseFloat(subMenuPageObjects.ratingValue.text())
        if(actualRating==5.0)
        {
            println("Product is top rated i.e.," + actualRating)
        }
    }
}
