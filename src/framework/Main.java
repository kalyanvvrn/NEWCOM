package framework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main {
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) throws IOException,
			InterruptedException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InvocationTargetException {
		String startTm = null;
		String endTm = null;
		try {

			WebElement webelement = null;
			int counter = 0;
			String oldValue = null;

			File ff = new File("DriverSheet.ods");
			String path = ff.getAbsolutePath();

			// String Path = "DriverSheet.ods";
			Sheet sheet = SpreadSheet.createFromFile(new File(path))
					.getSheet(0);
			int driverrowcount = sheet.getRowCount();

			// *******These variables for evaluating xPath expressions*******

			MutableCell viewPortValue = null;
			MutableCell executeValue = null;
			MutableCell driverValue = null;
			MutableCell functionalityValue = null;
			MutableCell testCasenoValue = null;
			MutableCell testCaseDescriptionValue = null;
			MutableCell testCaseExecuteValue = null;
			MutableCell actionValue = null;
			MutableCell objectIdentifierValue = null;
			MutableCell testDataValue = null;
			MutableCell objectSheetNameValue = null;
			MutableCell objectIdentifierTypeValue = null;
			MutableCell reportvalue = null;
			MutableCell applicationValue = null;

			// ******* These variables are for passing parameters*********
			java.util.Date startTime = null;
			String Status = null;
			String viewPort = null;
			String DriverToInvoke = null;
			String functionality = null;
			String driverExecute = null;
			String testCaseno = null;
			String testCaseDescription = null;
			String testCaseExecute = null;
			String ObjectIdentifier = null;
			String testData = null;
			String action = null;
			WebDriver driver = null;
			String ObjectSheetName = null;
			String ObjectIdentifierType = null;
			String report = null;
			String application = null;

			for (int i = 1; i < driverrowcount; i++) {
				System.out
						.println("Started reading the Driversheet sheet......");
				viewPortValue = sheet.getCellAt(0, i);
				driverValue = sheet.getCellAt(1, i);
				applicationValue = sheet.getCellAt(2, i);
				functionalityValue = sheet.getCellAt(3, i);
				reportvalue = sheet.getCellAt(4, i);
				executeValue = sheet.getCellAt(5, i);

				viewPort = viewPortValue.getTextValue();
				DriverToInvoke = driverValue.getTextValue();
				functionality = functionalityValue.getTextValue();
				driverExecute = executeValue.getTextValue();
				report = reportvalue.getTextValue();
				application = applicationValue.getTextValue();

				String Sheetname = viewPort + "Sheet";

				Report_Header r = new Report_Header();
				r.report_Header(viewPort, application);
				if (driverExecute.equals("YES")) {

					System.out.println("Trying to open " + DriverToInvoke);
					driver = Selecting_Device.selectdevice(DriverToInvoke);
					System.out.println(DriverToInvoke + " Opened");
					if (!viewPort.toUpperCase().equals("APPIUM")) {
						driver.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
					}

					File testCaseFile = new File(functionality);
					functionality = testCaseFile.getAbsolutePath();

					Sheet functionalitysheet = SpreadSheet.createFromFile(
							new File(functionality)).getSheet(Sheetname);

					int TestCaseRowCount = functionalitysheet.getRowCount();

					for (int j = 1; j < TestCaseRowCount; j++) {

						testCasenoValue = functionalitysheet.getCellAt(0, j);
						testCaseDescriptionValue = functionalitysheet
								.getCellAt(1, j);
						actionValue = functionalitysheet.getCellAt(2, j);
						objectIdentifierTypeValue = functionalitysheet
								.getCellAt(3, j);
						objectIdentifierValue = functionalitysheet.getCellAt(4,
								j);
						testDataValue = functionalitysheet.getCellAt(5, j);
						objectSheetNameValue = functionalitysheet.getCellAt(6,
								j);
						testCaseExecuteValue = functionalitysheet.getCellAt(7,
								j);
						testCaseno = testCasenoValue.getTextValue();
						ObjectSheetName = objectSheetNameValue.getTextValue();
						testCaseDescription = testCaseDescriptionValue
								.getTextValue();
						ObjectIdentifierType = objectIdentifierTypeValue
								.getTextValue();
						testCaseExecute = testCaseExecuteValue.getTextValue();
						action = actionValue.getTextValue();
						ObjectIdentifier = objectIdentifierValue.getTextValue();
						testData = testDataValue.getTextValue();
						DateFormat dd = new SimpleDateFormat(
								"MM/dd/yyyy HH:mm:ss");

						if (testCaseExecute.equals("YES")) {

							if (ObjectIdentifier.length() != 0) {
								System.out
										.println("Came to the find element section");
								webelement = FindElement.find_Element(
										ObjectIdentifierType, ObjectIdentifier,
										driver, viewPort, testCaseno,
										testCaseDescription, application,
										startTm, endTm);

							}

							if (action.equals("UiTest")) {

								// UiTest.uiTest(functionality, webelement,
								// driver, wait, ObjectSheetName, testCaseno,
								// testCaseDescription, j, report, viewPort,
								// application, startTm);

								UiTest.uiTest(functionality, webelement,
										driver, ObjectSheetName, testCaseno,
										testCaseDescription, j, report,
										viewPort, application, startTm, endTm);
							}

							else if (action.equals("StartTime")) {

								startTime = (java.util.Date) StartTime
										.startTime();

								startTm = dd.format(startTime);

								java.util.Date verynewdate = new java.util.Date();
								startTm = dd.format(verynewdate);
								Status = "Pass";
								Results.results(testCaseno,
										testCaseDescription, Status, viewPort,
										application, startTm, endTm);

							} else if (action.equals("EndTime")) {

								java.util.Date endTime = (java.util.Date) EndTime
										.endTime();
								endTm = dd.format(endTime);

								Status = "Pass";
								Results.results(testCaseno,
										testCaseDescription, Status, viewPort,
										application, startTm, endTm);
								endTm = null;

							}

							else if (action.equals("OldValueCapture")) {
								OldValueCapture o = new OldValueCapture();

								oldValue = o.oldValueCapture(webelement,
										driver, startTm);
							} else {

								String Classname = "framework.";
								Class newclass = Class.forName(Classname
										.concat(action));
								Object object = newclass.newInstance();
								Class[] par = new Class[16];
								// This is to mention all the parameter types
								// using the array par

								par[0] = String.class;
								par[1] = String.class;
								par[2] = String.class;
								par[3] = String.class;
								par[4] = String.class;
								par[5] = String.class;
								par[6] = WebElement.class;
								par[7] = String.class;
								par[8] = String.class;
								par[9] = WebDriver.class;
                                par[10] = String.class;
								par[11] = Integer.TYPE;
								par[12] = String.class;
								par[13] = String.class;
								par[14] = String.class;
								par[15] = String.class;

								// This is to convert the first character to
								// the small letter to
								// follow the naming conventions
								action = ConvertingToSmallLetter
										.convertingToSmallLetter(action);

								Method method = newclass.getMethod(action, par);

								method.invoke(object, viewPort, functionality,
										driverExecute, testCaseno,
										testCaseDescription, testCaseExecute,
										webelement, testData, action, driver,
										oldValue, j, report, application,
										startTm, endTm);

							}
						}
					}
					// This is to close the web driver to proceed for the
					// another
					// execution
					System.out.println("Closing the browser");
					driver.close();

				}
			}

		} catch (Exception e) {
			// This is to throw a error when there is a problem with the excel
			System.out.println(e.getMessage());
		}

	}

}