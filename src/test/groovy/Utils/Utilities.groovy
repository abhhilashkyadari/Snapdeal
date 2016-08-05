package Utils

import jxl.Cell
import jxl.Sheet
import jxl.Workbook

/**
 * Created by abhilashk on 8/5/2016.
 */
class Utilities {
    def readExcelData(def i,def j)
    {
        String path=new File(".").getCanonicalPath().split("Utils")[0]
        //String path = new File(".").getCanonicalPath()
        Workbook book = Workbook.getWorkbook(new File(path+"\\src\\test\\resources\\SnapDeal.xls"));
        Sheet sheet = book.getSheet(0);
        Cell cell =sheet.getCell(i,j)
        String cellValue=cell.getContents()
        return cellValue
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
}
