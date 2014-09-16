package framework;

import java.io.File;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UiTest {
	@SuppressWarnings({ "rawtypes", "unused" })
	public static void uiTest(String functionality, WebElement webelement,
			WebDriver driver,  String ObjectSheetName,
			String testCaseno, String testCaseDescription, int j,
			String report, String viewPort, String application, String startTm,
			String endTm) {

		String Status = null;
        String endTime = null;
        try {
			System.out.println(testCaseDescription);
            if(!viewPort.toUpperCase().equals("APPIUM"))
            {
			String Windowid = driver.getWindowHandle();
			driver.switchTo().window(Windowid);
            }

			// System.out.println(ObjectSheetName);
			Sheet objectSheet = SpreadSheet.createFromFile(
					new File(functionality)).getSheet(ObjectSheetName);

			int ObjectSheetRowcount = objectSheet.getRowCount();
			breakloop: for (int i = 1; i <= ObjectSheetRowcount; i++) {

				MutableCell ObjectIdValue = objectSheet.getCellAt(0, i);
				MutableCell ObjNameValue = objectSheet.getCellAt(1, i);
				MutableCell ObjXpathValue = objectSheet.getCellAt(2, i);
				MutableCell DesktopApplicabilityValue = objectSheet.getCellAt(3, i);
				MutableCell DesktopXcoordinateValue = objectSheet.getCellAt(4,i);
				MutableCell DesktopYCoordinateValue = objectSheet.getCellAt(5,i);
				MutableCell DesktopWidthValue = objectSheet.getCellAt(6, i);
				MutableCell DesktopHeightValue = objectSheet.getCellAt(7, i);
				MutableCell TabletApplicabilityValue = objectSheet.getCellAt(8,i);
				MutableCell TabletXCoordinateValue = objectSheet.getCellAt(9, i);
				MutableCell TabletYCoordinateValue = objectSheet.getCellAt(10,i);
				MutableCell TabletWidthValue = objectSheet.getCellAt(11, i);
				MutableCell TabletHeightValue = objectSheet.getCellAt(12, i);
				MutableCell MobileApplicabilityValue = objectSheet.getCellAt(13, i);
				MutableCell MobileXCoordinateValue = objectSheet.getCellAt(14,i);
				MutableCell MobileYCoordinateValue = objectSheet.getCellAt(15,i);
				MutableCell MobileWidthValue = objectSheet.getCellAt(16, i);
				MutableCell MobileHeightValue = objectSheet.getCellAt(17, i);

				String ObjectId = ObjectIdValue.getTextValue();
				String ObjName = ObjNameValue.getTextValue();
				String ObjXpath = ObjXpathValue.getTextValue();
                // Thread.sleep(5000);
                String DesktopApplicability = DesktopApplicabilityValue.getTextValue();
				if (DesktopApplicability.equals("YES")) {
					String DesktopXcoordinate = DesktopXcoordinateValue.getTextValue();
					String DesktopYCoordinate = DesktopYCoordinateValue.getTextValue();
					String DesktopWidth = DesktopWidthValue.getTextValue();
					String DesktopHeight = DesktopHeightValue.getTextValue();

					if (webelement.isDisplayed()) {
						System.out.println(testCaseDescription+"--PASS");
						Status = "Pass";
						
						Results.results(testCaseno, testCaseDescription, Status,
								viewPort, application, startTm, endTm);
						//System.out.println("camre here");
                     } else {
						System.out.println(testCaseDescription+"--FAIL");
						Status = "Fail";
						
						Results.results(testCaseno, testCaseDescription, Status,
								viewPort, application, startTm, endTm);
					}

				} else if (DesktopApplicability.equals("NO")) {
					// This need to be filled after getting the solution
				}
					
				String TabletApplicability = TabletApplicabilityValue
						.getTextValue();
				if (TabletApplicability.equals("YES")) {
					String TabletXCoordinate = TabletXCoordinateValue.getTextValue();
					String TabletYCoordinate = TabletYCoordinateValue.getTextValue();
					String TabletWidth = TabletWidthValue.getTextValue();
					String TabletHeight = TabletHeightValue.getTextValue();
				}

				String MobileApplicability = MobileApplicabilityValue
						.getTextValue();
                if (MobileApplicability.equals("YES")) {
					String MobileXCoordinate = MobileXCoordinateValue.getTextValue();
					String MobileYCoordinate = MobileYCoordinateValue.getTextValue();
					String MobileWidth = MobileWidthValue.getTextValue();
					String MobileHeight = MobileHeightValue.getTextValue();
				}
				break breakloop;
             }
		} catch (Exception e) {
			// This is to execute when the object does not exist on the screen
			System.out.println(testCaseDescription+"--FAIL OBJ DOES NOT EXISTS ON THE SCREEN");
			
        }
	}

}
