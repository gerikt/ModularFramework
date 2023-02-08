package test;

import commentLibs.implementation.CommonDriver;

public class DemoCommonDriver {

	public static void main(String[] args) {

		try {
			String url="https://demo.guru99.com/test/newtours/index.php";
			CommonDriver cmnDriver = new CommonDriver("edge");
			cmnDriver.openBrowserandNavigateTo(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
