package com.maven.org.MavenProject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample {
	
	@Test(retryAnalyzer = MyRetryAnalyser.class)
	private void test() {
		
		Assert.assertEquals("Karthik", "selva");
	}

}
