package com.maven.org.MavenProject;

import org.testng.Assert;
import org.testng.annotations.Test;


public class AssertConcepts {
	
	@Test
	private void check() {
		String actual = "Karthik";
		String expected= "Selva";
		
		//Assert.assertEquals(actual, expected);
		//Assert.assertNotEquals(expected, actual);
		//Assert.assertSame(actual, expected);
		//Assert.assertNull(actual);
		//Assert.assertNotNull(actual);
		Assert.assertTrue(actual == expected);
	}

}
