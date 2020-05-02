package SalesModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

import LoginModule.MyLogin;
import MethodsRepo.MyMethods;
import StartwithPrefeex.VariableModule;

public class CreateBusiness {

	
	public static void AddBusiness(WebDriver driver)
	{
		//MyLogin.DirectLogin(driver);
		
		try {
			driver.get(VariableModule.adminURL+"/admin/sales/create-business-form");
			WebDriverWait wait = new WebDriverWait(driver, 30);// 30 sec 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
			String businame=VariableModule.RandomStringGen(5);
			driver.findElement(By.name("name")).sendKeys(businame);
			
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business-form/form/div/div/div[1]/div[2]/p-dropdown/div/label")).click();
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business-form/form/div/div/div[1]/div[2]/p-dropdown/div/div[3]/div/ul/p-dropdownitem/li/span")).click();
			
			
			
			
			driver.findElement(By.name("location")).sendKeys("Uttara");
			driver.findElement(By.name("address")).sendKeys("Uttara,Dhaka");
			driver.findElement(By.name("details")).sendKeys("Test");
			driver.findElement(By.name("latitude")).sendKeys("23");
			driver.findElement(By.name("longitude")).sendKeys("33");
			
			
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business-form/form/div/div/div[7]/div/button")).click();
			
			 
			Thread.sleep(5000);
			
			String title=driver.getTitle();
			String message=driver.findElement(By.id("toastr-container")).getText();
			//System.out.println("Message: "+message);
			
			if(title.equals("Create Business"))
			{
				MyMethods.ExcelFileWriteAction("Sales -> Create Business", "Create business with data", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+businame, 1);
				
				//Business.BusinessTest(driver, businame);
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Sales -> Create Business", "Create business with data", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+businame, 1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void EditBusiness(WebDriver driver)
	{
		//MyLogin.DirectLogin(driver);
		
		try {
			String message="";
			
			driver.get(VariableModule.adminURL+"/admin/sales/create-business-form/1");
			WebDriverWait wait = new WebDriverWait(driver, 30);// 30 sec 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
			
			String businame = driver.findElement(By.name("location")).getAttribute("value");
			driver.findElement(By.name("location")).clear();
			driver.findElement(By.name("location")).sendKeys(businame+"1");
			

			
			
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business-form/form/div/div/div[7]/div/button")).click();
			
			 
			Thread.sleep(5000);
			
			if(driver.findElement(By.id("toastr-container")).isDisplayed())
			{
				message=driver.findElement(By.id("toastr-container")).getText();
			}
			String title=driver.getTitle();
			//System.out.println("title: "+title);
			if(title.equals("Create Business"))
			{
				MyMethods.ExcelFileWriteAction("Sales -> Edit Business", "Business is edited", "Successful", MyMethods.getCurrentDate(), message, "", 1);
				
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Sales -> Edit Business", "", "Failed", MyMethods.getCurrentDate(), message, "", 1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void AddBusinessUser(WebDriver driver)
	{
		//MyLogin.DirectLogin(driver);
		
		try {
			String email="";
			for(int i=0;i<1;i++) //For this time being duplicate email test skip
			{
				//driver.get(VariableModule.adminURL+"/admin/sales/business-user/1");
				WebDriverWait wait = new WebDriverWait(driver, 30);// 30 sec 
				driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[1]/div/div/a/span")).click();

				Thread.sleep(2000);
				if(i==0)
				{
					email=VariableModule.RandomStringGen(5);
				}

				driver.findElement(By.name("firstName")).sendKeys("First Name");
				
				
				driver.findElement(By.name("lastName")).sendKeys("Last Name");
				driver.findElement(By.name("email")).sendKeys(email+"@test.com");
				driver.findElement(By.name("phone")).sendKeys(VariableModule.RandomNumberGen(5));
				
				
				driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-create-business-user/form/div[3]/div/button")).click();
				
				 Thread.sleep(3000);
				
				 String message=driver.findElement(By.id("toastr-container")).getText();
				 
				if(i==0)
				{
					
					String title=driver.getTitle();
					//System.out.println("title: "+title);
					if(title.equals("Create Business User View"))
					{
						MyMethods.ExcelFileWriteAction("Sales -> Create Business User", "Create business user with data", "Successful", MyMethods.getCurrentDate(), message, "User Email: "+email+"@test.com", 1);
						
						//Business.BusinessTest(driver, businame);
					}
					else
					{
						MyMethods.ExcelFileWriteAction("Sales -> Create Business User", "Create business user with data", "Failed", MyMethods.getCurrentDate(), message, "User Email: "+email+"@test.com", 1);
					}
				}
				else
				{
					String title=driver.getTitle();
					//System.out.println("title: "+title);
					if(title.equals("Create Business User"))
					{
						MyMethods.ExcelFileWriteAction("Sales -> Create Business User", "Create business user with existing email", "Successful", MyMethods.getCurrentDate(), message, "User Email: "+email+"@test.com", 1);
						
						//Business.BusinessTest(driver, businame);
					}
					else
					{
						MyMethods.ExcelFileWriteAction("Sales -> Create Business User", "Create business user with  existing email", "Failed", MyMethods.getCurrentDate(), message, "User Email: "+email+"@test.com", 1);
					}
				}
				/*
				 * Select fruits = new Select(driver.findElement(By.id("fruits")));
				 * fruits.selectByVisibleText("Banana"); fruits.selectByIndex(1);
				 */
			}
			
			EditBusinessUser(driver);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void AddBusinessUserTest(WebDriver driver)
	{
		//MyLogin.DirectLogin(driver);
		
		try {
			driver.get(VariableModule.adminURL+"/admin/sales/create-business");
			//WebDriverWait wait = new WebDriverWait(driver, 30);// 30 sec 
			MyMethods.Sleep(3000);
			
			String param=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[1]")).getText();
			Select select = new Select(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[7]/select")));
			WebElement option = select.getFirstSelectedOption();
			String curstatus=option.getText();
			curstatus = curstatus.replaceAll("\\s", "");
			
			if(!curstatus.equals("APPROVED"))
			{
				select.selectByVisibleText("APPROVED");
				MyMethods.Sleep(2000);
				
				driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[8]/button")).click();
				MyMethods.Sleep(2000);
				driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[1]/div/div/a/span")).click();
				MyMethods.Sleep(2000);

				String email=VariableModule.RandomStringGen(5);
				driver.findElement(By.name("firstName")).sendKeys("First Name");
				
				driver.findElement(By.name("lastName")).sendKeys("Last Name");
				driver.findElement(By.name("email")).sendKeys(email+"@test.com");
				driver.findElement(By.name("phone")).sendKeys(VariableModule.RandomNumberGen(5));
				
				
				driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-create-business-user/form/div[3]/div/button")).click();
				
				 Thread.sleep(3000);

			}
			else
			{
				driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[8]/button")).click();
				MyMethods.Sleep(2000);
				driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[1]/div/div/a/span")).click();
				MyMethods.Sleep(2000);
				
				String email=VariableModule.RandomStringGen(5);
				driver.findElement(By.name("firstName")).sendKeys("First Name");
				
				driver.findElement(By.name("lastName")).sendKeys("Last Name");
				driver.findElement(By.name("email")).sendKeys(email+"@test.com");
				driver.findElement(By.name("phone")).sendKeys(VariableModule.RandomNumberGen(5));
				
				
				driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-create-business-user/form/div[3]/div/button")).click();
				
				 Thread.sleep(3000);
				 
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void EditBusinessUser(WebDriver driver)
	{
		//MyLogin.DirectLogin(driver);
		
		try {
				driver.get(VariableModule.adminURL+"/admin/sales/create-business");
				WebDriverWait wait = new WebDriverWait(driver, 30);// 30 sec 
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[8]/button")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[6]/a")).click();
				Thread.sleep(3000);

			
			  String lastname = driver.findElement(By.name("lastName")).getAttribute("value");
			  driver.findElement(By.name("lastName")).clear();
			  driver.findElement(By.name("lastName")).sendKeys(lastname+"1");
			 

				
				
				driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-create-business-user/form/div[3]/div/button")).click();
				
				 Thread.sleep(3000);

				 String message=driver.findElement(By.id("toastr-container")).getText();
					String title=driver.getTitle();
					//System.out.println("title: "+title);
					if(title.equals("Business Users"))
					{
						MyMethods.ExcelFileWriteAction("Sales -> Edit Business User", "Edit business user with data", "Successful", MyMethods.getCurrentDate(), message, "Last Name: "+lastname+"1", 1);
						
						//Business.BusinessTest(driver, businame);
					}
					else
					{
						MyMethods.ExcelFileWriteAction("Sales -> Edit Business User", "Edit business user with data", "Failed", MyMethods.getCurrentDate(), message, "Last Name: "+lastname+"1", 1);
					}

				/*
				 * Select fruits = new Select(driver.findElement(By.id("fruits")));
				 * fruits.selectByVisibleText("Banana"); fruits.selectByIndex(1);
				 */
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
