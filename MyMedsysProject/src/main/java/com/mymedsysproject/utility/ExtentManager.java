/**
 * 
 */
package com.mymedsysproject.utility;

import com.mymedsysproject.base.BaseClass;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mymedsysproject.actiondriver.Action;


/**
 * 
 * Author: Ayodeji Date: 2023
 */

     public class ExtentManager {
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void setExtent() throws IOException {
		// Define the path for the HTML report file with a timestamp
		String reportFilePath = null;
		try {
			reportFilePath = System.getProperty("user.dir") + "/test-output/ExtentReport/MyReport_"
					+ Action.getCurrentTime() + ".html";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Initialize the HTML reporter
		htmlReporter = new ExtentSparkReporter(reportFilePath);

		// Load configuration from an XML file
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		// Initialize the ExtentReports instance
		extent = new ExtentReports();

		// Attach the HTML reporter to the ExtentReports instance
		extent.attachReporter(htmlReporter);

		// Set system information
		extent.setSystemInfo("Project", "AutoMedsysProject");
		extent.setSystemInfo("Tester", "Ayodeji");
		extent.setSystemInfo("OPERATING SYSTEM", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public static void endReport() {
		// Flush the extent report to generate the report
		extent.flush();
	}
}
