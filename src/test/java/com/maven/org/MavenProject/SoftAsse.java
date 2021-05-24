package com.maven.org.MavenProject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsse {
	
	@Test
	private void Assert() {
		
		String actual = "karthik";
		String expected = "selva";
		
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(actual, expected);
		//sa.assertNotEquals(actual, expected);
		//sa.assertNull(actual);
		//sa.assertNotNull(actual);
		//sa.assertTrue(actual == expected);
		sa.assertAll();
		
		
		

	}

}
