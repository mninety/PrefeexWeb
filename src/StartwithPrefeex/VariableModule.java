package StartwithPrefeex;
import org.apache.log4j.Logger;
import java.awt.TrayIcon;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.security.auth.spi.LoginModule;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.server.browserlaunchers.DrivenSeleniumLauncher;
import LoginModule.MyLogin;
import MenuModule.MyMenu;
import Profile.MyProfile;
import SalesModule.Business;
import SalesModule.CreateBusiness;



public class VariableModule {
	//ActionModule actiondo = new ActionModule();
	static Logger logVariableModule = Logger.getLogger(VariableModule.class.getName());
	
	//log.info("Error in: " + this.getClass.getName() + "at line #"+ this.getClass.getActualLine());
	

	
	//public Static String file_name="E:/Automation/Logs/Output.txt";
	public static String driverlog="D:/Configuration/PrefeexWeb"; // linux=/usr/local/iTelTestAutomation // Windows=D:/Configuration/PrefeexWeb
	public static String sleepTime=readVariable("sleepTime",1); //in minute
	public static String driverselection = readVariable("driverselection",1); //1=firefox, 2=chrome, 3=unitdriver
	
	public static String adminURL = readVariable("adminURL",1);
	public static String businessURL = readVariable("businessURL",1);
    public static String adminuser = readVariable("adminuser",1);
    public static String adminpass = readVariable("adminpass",1);
    
    public static String testingMode = readVariable("testingMode", 1);

    

    public static WebDriver DriverSelection(String flag)
    {
    	WebDriver driver = null;
    	if(flag.equals("1"))
    	{
			/*
			 * System.setProperty("webdriver.firefox.marionette",driverlog+
			 * "/geckodriver_new.exe"); DesiredCapabilities capabilities =
			 * DesiredCapabilities.firefox(); capabilities.setCapability("marionette",true);
			 * //DesiredCapabilities capability = DesiredCapabilities.firefox(); driver =
			 * new FirefoxDriver();
			 */
    		 
    	        System.setProperty("webdriver.gecko.driver", driverlog+"/geckodriver_new.exe");
    	        DesiredCapabilities cap = DesiredCapabilities.firefox();
    	        cap.setCapability("marionette", true);
    	        driver = new FirefoxDriver(cap);
    	}
    	else if(flag.equals("2"))
    	{
    		System.setProperty("webdriver.chrome.driver",driverlog+"/chromedriver_new.exe");
    		//DesiredCapabilities capability = DesiredCapabilities.firefox();
    		 //driver = new ChromeDriver();
    		 
    			//Create prefs map to store all preferences 
    			Map<String, Object> prefs = new HashMap<String, Object>();

    			//Put this into prefs map to switch off browser notification
    			prefs.put("profile.default_content_setting_values.notifications", 2);

    			//Create chrome options to set this prefs
    			ChromeOptions options = new ChromeOptions();
    			options.setExperimentalOption("prefs", prefs);

    			//Now initialize chrome driver with chrome options which will switch off this browser notification on the chrome browser
    			driver = new ChromeDriver(options);
    	}
    	else
    	{
    		 driver=new HtmlUnitDriver();
    	}
    	return driver;
    }
    
    public static WebDriver driver= DriverSelection(driverselection);
    
    
    
    public static void StartModule()
    {

    	try {
    		if(testingMode.equals("1"))
    		{
    				//MyLogin.LoginTest(driver);
				
    				MyLogin.DirectLogin(driver); 
    			/*
    				CreateBusiness.AddBusiness(driver);
    				CreateBusiness.EditBusiness(driver);
				  
    				Business.BusinessTest(driver, "KFC2"); 
    				Business.UserButtonPermissionTest(driver);
    				Business.UserStatusTest(driver);
    				Business.UserEditButtonPermissionTest(driver);
    				
    				MyProfile.UserProfile(driver);
    			*/
    				MyMenu.CreateMenuTest(driver);
    				MyMenu.MenuTest(driver);
    				MyMenu.AddonTest(driver);
    				
    			System.out.println("Test execution completed!!!");
				
    			driver.quit();
    		}
    		else
    		{
    			MyLogin.LoginTestwithInput(driver);
    			
    			driver.quit();
    		}



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    }

    
	public static String readVariable(String var, int configflag)
	{
		int flag=0;
		int gotvar=0;
		Character ch = new Character('a');
		StringBuilder Test = new StringBuilder("");
		StringBuilder tempvar = new StringBuilder("");
		String path = null;
		int data;
		try {
			if(configflag==1)
			{
				path=VariableModule.driverlog+"/PrefeexWeb.txt";
			}
			else
			{
				//path=VariableModule.driverlog+"/WebDriver/Config/API-Config.txt";

			}
			Reader fileReader = new FileReader(path);
			data = fileReader.read();
			while(data != -1) {
				ch=(char)data;
				//System.out.println("String: "+ch+flag+gotvar);
				if(flag==0 && ch!='=') {
					Test.append(ch);
				}
				else if(flag==1 && gotvar==1) {
					if(ch!='=' && ch!=';') {
						tempvar.append(ch);
						
					}
				}
				if(ch=='\n') {
					flag=0;
					Test = new StringBuilder("");
				}
				else if(ch=='='){
					flag=1;
					String Test1=Test.toString();
					//System.out.println("Flag:"+Test1);
					//System.out.println("Actual:"+var);
					if(Test1.equals(var))
					{
						//System.out.println("Match Equal"+Test);
						gotvar=1;
					}
				}
				else if(ch==';' && gotvar==1) {
					//System.out.println("Variable Found:"+tempvar);
					break;
				}

				data = fileReader.read();
			  //System.out.println((char)data);
			}
			//String tempvar1=tempvar.toString();
			
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempvar.toString();
	}
	
	public static WebDriver HtmlUnitDriver()
	{
		WebDriver drive;
		drive = new HtmlUnitDriver();
		return drive;
	}


	public static String RandomStringGen(int len)
	{
		
		final String AB = "abcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();

		
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   
		   return sb.toString();
		
	}
	
	public static String RandomNumberGen(int len)
	{
		
		final String AB = "0123456789";
		SecureRandom rnd = new SecureRandom();

		
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   
		   return sb.toString();
		
	}
	
}
