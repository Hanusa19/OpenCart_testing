package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{

	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("***** Starting TC002_LoginTest *****");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("Logging to Accounts Page");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		logger.info("Checking if account page exists");
		
		MyAccountPage ap = new MyAccountPage(driver);
		boolean targetPage = ap.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC002_LoginTest *****");
			
	}
		
}
