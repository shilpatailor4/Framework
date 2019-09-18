package testcases;

import org.testng.annotations.Test;

import base.BaseTest;

public class DummyTestB extends BaseTest {
	
	@Test
	public void testB()
	{
		System.out.println(System.getProperty("user.dir"));
		
		openBrowser("Mozila");
		
		navigate("appurl");
		
		
	}

}
