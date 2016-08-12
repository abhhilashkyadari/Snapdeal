package Utils

import geb.error.RequiredPageContentNotPresent
import jxl.Cell
import jxl.Sheet
import jxl.Workbook
import jxl.read.biff.BiffException

/**
 * Created by abhilashk on 8/5/2016.
 */
public class Utilities {
    String[] getValuesFromExcel() throws BiffException, IOException
    {
        String path=new File(".").getCanonicalPath().split("Utils")[0]

        Workbook book = Workbook.getWorkbook(new File(path + "\\src\\test\\resources\\SnapDeal.xls"))

        String menuLink=null
        String subMenuLink=null
        String priceFrom=null
        String priceTo=null
        Sheet sheet = book.getSheet(0)
        int rowcount = sheet.getRows()
        int colcount = sheet.getColumns()
        for (int i=0;i<rowcount; i++){
            for(int j=0; j<colcount;j++)
            {
                String cell = sheet.getCell(j, i).getContents()
                if(cell.equals("Menulink"))
                {
                    menuLink = sheet.getCell(j, i+1).getContents()
                }

                if(cell.equals("SubMenuLink"))
                {
                    subMenuLink = sheet.getCell(j, i+1).getContents()
                }

                if(cell.equals("PriceFrom"))
                {
                    priceFrom = sheet.getCell(j, i+1).getContents()
                }

                if(cell.equals("PriceTo"))
                {
                    priceTo = sheet.getCell(j, i+1).getContents()
                }
            }
        }
        String[] values=  [menuLink,subMenuLink,priceFrom,priceTo]
        return values;
    }

    def getMenu(){
        String[] val= getValuesFromExcel()
        //print(getMenu)
        return val[0]
    }
    def getSubMenu(){
        String[] val= getValuesFromExcel()
        //print(getMenu)
        return val[1]
    }
    def getPriceFrom(){
        String[] val= getValuesFromExcel()
        //print(getMenu)
        return val[2]
    }
    def getPriceTo(){
        String[] val= getValuesFromExcel()
        //print(getMenu)
        return val[3]
    }

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

    def safeClick(element)
    {
            try{
                element.click()
            }
            catch (Exception e)
            {
                println("Exception is safeClick()" + e.stackTrace())
            }
    }

}

