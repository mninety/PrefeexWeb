package LoginModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MethodsRepo.MyMethods;
import StartwithPrefeex.VariableModule;

public class MyLogin {
	
	public static void LoginTest(WebDriver driver)
	{

		try {
			driver.get(VariableModule.adminURL);
			WebDriverWait wait = new WebDriverWait(driver, 30);// 30 sec 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
			for(int i=0;i<3;i++)
			{
				String param="";
				String paramsend="";
				driver.findElement(By.name("email")).clear();
				if(i==0)
				{
					paramsend=VariableModule.adminuser+"1";
					driver.findElement(By.name("email")).sendKeys(paramsend);
					param=param+"email: "+paramsend+", ";
				}
				else
				{
					paramsend=VariableModule.adminuser;
					driver.findElement(By.name("email")).sendKeys(paramsend);
					param=param+"email: "+paramsend+", ";
				}
				
				driver.findElement(By.id("password")).clear();
				if(i==1)
				{
					paramsend=VariableModule.adminpass+"1";
					driver.findElement(By.id("password")).sendKeys(paramsend);
					param=param+"password: "+paramsend;
				}
				else
				{
					paramsend=VariableModule.adminpass;
					driver.findElement(By.id("password")).sendKeys(paramsend);
					param=param+"password: "+paramsend;
				}
				
				driver.findElement(By.xpath("/html/body/app-root/app-user/app-sign-in/main/div/div/div[3]/div/div[2]/form/div[3]/div/button")).click();
				
				MyMethods.Sleep(4000);
				
				String message=driver.findElement(By.id("toastr-container")).getText();
				
				if(i==0)
				{
				       if(driver.getTitle().indexOf("Dashboard") != -1){
				    	   MyMethods.ExcelFileWriteAction("Login", "Invalid User Access", "Failed", MyMethods.getCurrentDate(), message, param, 3);
				       }
				       else
				       {
				    	   MyMethods.ExcelFileWriteAction("Login", "Invalid User Access", "Successful", MyMethods.getCurrentDate(), message, param, 3);
				       }
				}
				else if(i==1)
				{
				       if(driver.getTitle().indexOf("Dashboard") != -1){
				    	   MyMethods.ExcelFileWriteAction("Login", "Invalid Password", "Failed", MyMethods.getCurrentDate(), message, param, 3);
				       }
				       else
				       {
				    	   MyMethods.ExcelFileWriteAction("Login", "Invalid Password", "Successful", MyMethods.getCurrentDate(), message, param, 3);
				       }
				}
				
				else
				{
						MyMethods.Sleep(5000);
				       if(driver.getTitle().equals("Dashboard")){
				    	   MyMethods.ExcelFileWriteAction("Login", "Valid Access", "Successful", MyMethods.getCurrentDate(), message, param, 3);
				       }
				       else
				       {
				    	   MyMethods.ExcelFileWriteAction("Login", "Valid Access", "Failed", MyMethods.getCurrentDate(), message, param, 3);
				       }
				       //MyMethods.Sleep(5000);
				}

				MyMethods.Sleep(3000);
			}
			
			//driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[1]/ul/li[10]")).click();
			//MyMethods.Sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}

	public static void LoginTestwithInput(WebDriver driver)
	{

		driver.get(VariableModule.adminURL);
		WebDriverWait wait = new WebDriverWait(driver, 30);// 30 sec 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		MyMethods.Sleep(5000);
		
		String input=MyMethods.ExcelFileReadAction("InputFilesLogin.xlsx");
		input=input.substring(1, input.length()-1);
		//System.out.println("Input Data: "+input);
		String[] inputArray = input.split("%");

		//System.out.println("Array Length: "+inputArray.length);
		
		for(int i=0;i<inputArray.length;i++)
		{
			
			String param="";
			String paramsend="";
			String[] inputArray1 = inputArray[i].split(";");
			
				driver.findElement(By.name("email")).clear();
				paramsend=inputArray1[0];
				driver.findElement(By.name("email")).sendKeys(paramsend);
				param=param+"email: "+paramsend+", ";

			
				driver.findElement(By.id("password")).clear();
				paramsend=inputArray1[1];
				driver.findElement(By.id("password")).sendKeys(paramsend);
				param=param+"password: "+paramsend;
			
			driver.findElement(By.xpath("/html/body/app-root/app-user/app-sign-in/main/div/div/div[3]/div/div[2]/form/div[3]/div/button")).click();
			
			try {
			    Thread.sleep(5000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			String message=driver.findElement(By.id("toastr-container")).getText();
			
			       if(driver.getTitle().indexOf("Dashboard") != -1){
			    	   MyMethods.ExcelFileWriteAction("Login", "", "User can logged in with this access", MyMethods.getCurrentDate(), message, param, inputArray.length);
			    	   //driver.findElement(By.xpath("/html/body/app-root/app-admin/div/nav/div/ul[2]/li[2]")).click();
			    	   driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[1]/ul/li[10]/a/div/div[1]/span")).click();
			    	   MyMethods.Sleep(3000);
			       }
			       else
			       {
			    	   MyMethods.ExcelFileWriteAction("Login", "", "User can't logged in with this access", MyMethods.getCurrentDate(), message, param, inputArray.length);
			       }


			
		}


		
	}

	public static void DirectLogin(WebDriver driver)
	{
		try {
			driver.get(VariableModule.adminURL);// /user/sign-in
			WebDriverWait wait = new WebDriverWait(driver, 30);// 30 sec 
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
			Thread.sleep(2000);
			
			driver.findElement(By.name("email")).sendKeys(VariableModule.adminuser);
			driver.findElement(By.id("password")).sendKeys(VariableModule.adminpass);
			driver.findElement(By.xpath("/html/body/app-root/app-user/app-sign-in/main/div/div/div[3]/div/div[2]/form/div[3]/div/button")).click();
			
			try {
			    Thread.sleep(2000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
