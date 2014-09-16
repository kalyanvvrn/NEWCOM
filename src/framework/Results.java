package framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.time.DurationFormatUtils;

public class Results {
	@SuppressWarnings("unused")
	public static void results(String testCaseno, String testCaseDescription,
			String Status, String viewPort, String application, String startTm,
			String endTm) throws IOException, ParseException {
		
		
		SimpleDateFormat ddd = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
        String totalDifference = " ";
        
        if(!(startTm==null))
        {
        	//System.out.println(startTm);
        	//System.out.println("came to starttime section");
        	java.util.Date startTime = (java.util.Date) ddd.parse(startTm);
         totalDifference = " ";
         if(!(endTm==null))
         {
        	 
        	// System.out.println(endTm);
        	// System.out.println("this is start time");
         	//System.out.println(startTime);
 			java.util.Date endTime = (java.util.Date) ddd.parse(endTm);
 			Long timeDiff = endTime.getTime() - startTime.getTime();
 			Long hours = timeDiff / (60 * 60 * 1000);
 			Long minutes = timeDiff / (60 * 1000);
 			Long seconds = timeDiff / (1000);
 			Long milliSeconds = seconds * 1000;
             totalDifference = DurationFormatUtils.formatDuration(milliSeconds,
 					"HH:mm:ss");
         }
        
        }
        
        String osname = System.getProperty("os.name");
		String output = null;
		String newPath = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		File ff = new File("DriverSheet.ods");
		String path = ff.getAbsolutePath();
		// String newPath=path.substring(0,path.lastIndexOf("/")).concat("/");
		if (osname.toUpperCase().contains("MAC")) {
			newPath = path.substring(0, path.lastIndexOf("/")).concat("/");
			
		} else {
			newPath = path.substring(0, path.lastIndexOf("\\")).concat("\\");
		}
		
		String Files = newPath.concat(viewPort).concat(application)
				.concat(".html");
		String align = "center";
		String color = "lightgreen";
		String headercolor = "grey";

		File f = new File(Files);
		fw = new FileWriter(f, true);
		bw = new BufferedWriter(fw);
		//System.out.println("came to reports1");
		bw.write("<table border=1 style=width:1000px>");
		bw.write("<tr>");
		System.out.println("came to reports section");
		if (Status.equals("Pass")) {
			bw.write("<td style=width:333px BGCOLOR=" + color + ">"
					+ testCaseno + "</td>");
			bw.write("<td style=width:333px BGCOLOR=" + color + ">"
					+ testCaseDescription + "</td>");
			//System.out.println(testCaseDescription);
			bw.write("<td style=width:333px BGCOLOR=" + color + ">" + "PASS"
					+ "</td>");
            
            	
			bw.write("<td style=width:333px BGCOLOR=" + color + ">"
					+ totalDifference + "</td>");
            	
            

		}
		if (Status.equals("Fail")) {
			bw.write("<td style=width:333px BGCOLOR=#FF0000 >" + testCaseno
					+ "</td>");
			bw.write("<td style=width:333px BGCOLOR=#FF0000 >"
					+ testCaseDescription + "</td>");
			bw.write("<td style=width:333px BGCOLOR=#FF0000 >" + "FAIL"
					+ "</td>");
			
			bw.write("<td style=width:333px BGCOLOR=" + color + ">"
					+ totalDifference + "</td>");
	            
		}
		bw.write("</tr>");
		bw.write("</table>");
		bw.close();
	}
}
