package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{ 
		try
		{
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage ar = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details");
		
		ar.setFirstName(randomString().toUpperCase());                  
		ar.setLastName(randomString().toUpperCase());
		ar.setEmail(randomString()+"@gmail.com");       // randomly generate email address (dynamic data)
		ar.setPhone(randomNumber());
		
		String password = randomAlphaNumeric();
		
		ar.setPassword(password);
		ar.setConfirmPassword(password);
		
		ar.setPrivacyPolicy();
		ar.clickContinue();
		
		logger.info("Validating expecting message");
		
		String cfmsg = ar.getConfirmationMsg();
		if(cfmsg.equals("Your Account Has Been Created!"))
		{
		Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		}
		
		catch (Exception e)
		{

			Assert.fail();
		}
		
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		
	}
	
}
