/**
 * Created by abhilashk on 8/3/2016.
 */
package snapdealPage
import geb.Page
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
        waitFor (10){
            element.isDisplayed()
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
    }

    /*
    This method is used for selecting top rated product from the list of available products
     */
    def selectTopRatedProduct()
    {
        List<WebElement> products=subMenuPageObjects.productsList
        float compare
        int key
        for(int i=0;i<products.size();i++){

            //products.get(i)
            //String str=rates.get(i).findElement(org.openqa.selenium.By.cssSelector(".filled-stars")).getAttribute("style").split(":")[1].trim().replace("%;","")
            String str=products.get(i).findElement(By.cssSelector(".filled-stars")).getAttribute("style").split(":")[1].trim().replace("%","").replace(";","")
            //float val= Float.parseFloat(str)
            double val=Double.parseDouble(str)
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
            }
        }
        products.get(key).findElement(By.cssSelector(".product-title")).click()

    }

    /*
    This method is used for selecting customer rating
     */
    def customerRatingFilter()
    {
        sleep(2000)
        sync(subMenuPageObjects.expandCustomerRatingSection)
        subMenuPageObjects.expandCustomerRatingSection.click()
        sync(subMenuPageObjects.customertRatingRadioButton)
        subMenuPageObjects.customertRatingRadioButton.click()
    }

    /*
    This method is for getting top rated product name and its rating
     */

    def getProductNameAndCheckRating()
    {
        println(subMenuPageObjects.productTitle.text())
        subMenuPageObjects.ratingLink.click()
        float actualRating=Float.parseFloat(subMenuPageObjects.ratingValue.text())
        if(actualRating==5.0)
        {
            println("Product is top rated i.e.," + actualRating)
        }
    }
}
