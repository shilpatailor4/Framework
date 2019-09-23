package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;

public class DummyTestB extends BaseTest {
	
	@Test
	public void testB() throws InterruptedException, IOException
	{
		System.out.println(System.getProperty("user.dir"));
		
		openBrowser("Chrome");
		
		navigate("appurl");
		username("email_xpath");
		emailNext("button_xpath");
		password("password_xpath");
		passwordNext("button1_xpath");
		compose("compose_xpath");
		to("to_name");
		cc("cc_xpath");
		cc_email("ccemail_name");
		subject("subject_name");
		body("body_xpath");
		sendbtn("send_xpath");
		sendpage("sendpage_xpath");
		//sentmail("sentmailclick_xpath");
		attachDoc("addFile_xpath");
	
		
	}

	

}
