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
    def readExcelData(def i,def j)
    {
        String path=new File(".").getCanonicalPath().split("Utils")[0]
        try {
            Workbook book = Workbook.getWorkbook(new File(path + "\\src\\test\\resources\\SnapDeal.xls"));
            Sheet sheet = book.getSheet(0);
            Cell cell = sheet.getCell(i, j)
            String cellValue = cell.getContents()
            return cellValue
        }
        catch (BiffException e)
        {
            println("Exception in readExcelData()"+ e.stackTrace())
        }
        catch (IOException e)
        {
            println("Exception in readExcelData()"+ e.stackTrace())
        }
    }
    def getMenu(){
        String val= readExcelData(0,1)
        //print(getMenu)
        return val
    }
    def getSubMenu(){
        String val= readExcelData(1,1)
        return val
    }
    def getPriceFrom(){
        String val=readExcelData(2,1)
        return val
    }
    def getPriceTo(){
        String val=readExcelData(3,1)
        return val
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

