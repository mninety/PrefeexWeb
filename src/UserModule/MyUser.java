package UserModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import MethodsRepo.MyMethods;
import SalesModule.CreateBusiness;
import StartwithPrefeex.VariableModule;

public class MyUser {

	public static void CreateUserTest(WebDriver driver)
	{
		
		try {
			String status="";
			for(int i=0;i<6;i++)
			{
				driver.get(VariableModule.adminURL+"/admin/manage-user/user-create");
				MyMethods.Sleep(2000);
				String useremail=VariableModule.RandomStringGen(5);
				driver.findElement(By.name("email")).sendKeys(useremail+"@test.com");
				driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-manage-user-form/form/div/div/div[1]/div[2]/p-dropdown/div/label")).click();
				if(i==0) //ADMIN
				{
					status="ADMIN";
					driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-manage-user-form/form/div/div/div[1]/div[2]/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]/li")).click();
				}
				else if(i==1)//CUSTOMER_SUPPORT
				{
					status="CUSTOMER_SUPPORT";
					driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-manage-user-form/form/div/div/div[1]/div[2]/p-dropdown/div/div[3]/div/ul/p-dropdownitem[2]/li")).click();
				}
				else if(i==2)//MANAGER
				{
					status="MANAGER";
					driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-manage-user-form/form/div/div/div[1]/div[2]/p-dropdown/div/div[3]/div/ul/p-dropdownitem[3]/li")).click();
				}
				else if(i==3)//MARCKETING
				{
					status="MARCKETING";
					driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-manage-user-form/form/div/div/div[1]/div[2]/p-dropdown/div/div[3]/div/ul/p-dropdownitem[4]/li")).click();
				}
				else if(i==4)//SALES
				{
					status="SALES";
					driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-manage-user-form/form/div/div/div[1]/div[2]/p-dropdown/div/div[3]/div/ul/p-dropdownitem[5]/li")).click();
				}
				else //SALES_MANAGER
				{
					status="SALES_MANAGER";
					driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-manage-user-form/form/div/div/div[1]/div[2]/p-dropdown/div/div[3]/div/ul/p-dropdownitem[6]/li")).click();
				}
				
				driver.findElement(By.name("password")).sendKeys("1234");
				driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-manage-user-form/form/div/div/div[3]/div/button")).click();
				
				MyMethods.Sleep(3000);
				String title=driver.getTitle();
				String message="";
				if(driver.findElement(By.id("toastr-container")).isDisplayed())
				{
					message=driver.findElement(By.id("toastr-container")).getText();
					
					
					if(title.equals("Internal User"))
					{
						MyMethods.ExcelFileWriteAction("Manage User -> Create User", "User Created? for: "+status, "Successful", MyMethods.getCurrentDate(), message, "User Email: "+useremail+"@test.com", 6);
						
					}
					else
					{
						MyMethods.ExcelFileWriteAction("Manage User -> Create User", "User Created? for: "+status, "Failed", MyMethods.getCurrentDate(), message, "User Email: "+useremail+"@test.com", 6);
					}
				}
				else
				{
					MyMethods.ExcelFileWriteAction("Manage User -> Create User", "User Created? for: "+status, "Failed", MyMethods.getCurrentDate(), message, "User Email: "+useremail+"@test.com", 6);
				}
				
			}
			
			//EditUserTest(driver);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void EditUserTest(WebDriver driver)
	{
		driver.get(VariableModule.adminURL+"/admin/manage-user/user");
		MyMethods.Sleep(2000);
		String email=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-manage-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[1]")).getText();
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-manage-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[4]/button")).click();
		MyMethods.Sleep(2000);
		
		String fname=VariableModule.RandomStringGen(5);
		driver.findElement(By.name("firstName")).sendKeys(fname);
		
		String lname=VariableModule.RandomStringGen(5);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		
		driver.findElement(By.name("phone")).clear();
		driver.findElement(By.name("phone")).sendKeys(VariableModule.RandomNumberGen(5));
		driver.findElement(By.name("country")).sendKeys("Bangladesh");
		
		DoBTest(driver,email);
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-internal-user-profile/form/div[5]/div/p-calendar/span/input")).clear();
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-internal-user-profile/form/div[5]/div/p-calendar/span/input")).sendKeys("1990/03/27");
		
		
		
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-internal-user-profile/form/div[6]/div/button")).click();
		
		String title=driver.getTitle();
		String message="";
		if(driver.findElement(By.id("toastr-container")).isDisplayed())
		{
			message=driver.findElement(By.id("toastr-container")).getText();
			
			
			if(title.equals("Internal User Profile"))
			{
				MyMethods.ExcelFileWriteAction("Manage User -> Edit User", "User Edited?", "Successful", MyMethods.getCurrentDate(), message, "User Email: "+email, 2);
				
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Manage User -> Edit User", "User Edited?", "Failed", MyMethods.getCurrentDate(), message, "User Email: "+email, 2);
			}
		}
		else
		{
			MyMethods.ExcelFileWriteAction("Manage User -> Edit User", "User Edited?", "Failed", MyMethods.getCurrentDate(), message, "User Email: "+email, 2);
		}
		
	}
	
	public static void DoBTest(WebDriver driver, String email)
	{
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-internal-user-profile/form/div[5]/div/p-calendar/span/input")).clear();
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-internal-user-profile/form/div[5]/div/p-calendar/span/input")).sendKeys("2025/03/27");

		
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-internal-user-profile/form/div[6]/div/button")).click();
		MyMethods.Sleep(2000);
		
		String message1=driver.findElement(By.id("toastr-container")).getText();
		if(message1.equals("Invalid Date of birth"))
		{
			MyMethods.ExcelFileWriteAction("Manage User -> User Edit", "User Email: "+email+" ,Future Date Allowed?", "Successful", MyMethods.getCurrentDate(), message1, "DoB: 2025/03/27", 2);
		
			
		}
		else
		{
			MyMethods.ExcelFileWriteAction("Manage User -> User Edit", "User Email: "+email+" ,Future Date Allowed?", "Failed", MyMethods.getCurrentDate(), message1, "DoB: 2025/03/27", 2);
		}
		
		
	}

	public static void UserStatusTest(WebDriver driver)
	{
		
		
		driver.get(VariableModule.adminURL+"/admin/manage-user/user");
		//WebDriverWait wait = new WebDriverWait(driver, 30);// 30 sec 
		MyMethods.Sleep(2000);
		String email=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-manage-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[1]")).getText();
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-manage-users/app-manage-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[3]/select")));
		WebElement option = select.getFirstSelectedOption();
		String curstatus=option.getText();
		curstatus = curstatus.replaceAll("\\s", "");
		
		GetUserStatus(curstatus,driver,select,email);
		
	}
	
	public static void GetUserStatus(String value, WebDriver driver, Select select, String param)
	{

			
		
		  if(value.equals("ACTIVE")) //ACTIVE 
		  { 
			  UserStatusChange(value, driver,select,param,0); 
		  } 
		  else if(value.equals("DELETED")) //DELETED 
		  {
			  UserStatusChange(value, driver, select,param,1); 
		  } 
		  else if(value.equals("INACTIVE")) //INACTIVE 
		  { 
			  UserStatusChange(value,driver, select,param,2); 
		  } 
		  else //SUSPENDED 
		  { 
			  UserStatusChange(value, driver,select,param,3); 
		  }
		 
			
		

	}

	public static void UserStatusChange(String value, WebDriver driver, Select select, String param, int skip)
	{
		String oldvalue=value;
		String message="";
		for(int i=0;i<4;i++)
		{
			if(i==0)
			{
				if(i==skip)
				{
					continue;
				}
				else
				{
					select.selectByVisibleText("ACTIVE");
					MyMethods.Sleep(2000); 

					if(driver.findElement(By.id("toastr-container")).isDisplayed())
					{
						message=driver.findElement(By.id("toastr-container")).getText();
					}
					else
					{
						message="";
					}
					
					value=select.getFirstSelectedOption().getText().replaceAll("\\s", "");
					if(oldvalue.equals("ACTIVE"))
					{
						//MyMethods.PrintMe("Status: ",value);
						//System.out.println("Status: "+value);
						MyMethods.ExcelFileWriteAction("User list", "User Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "User Email: "+param, 3);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("User list", "User Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "User Email: "+param, 3);
					}
					
					oldvalue=value;
				}

			}
			else if(i==1)
			{
				if(i==skip)
				{
					continue;
				}
				else
				{
					select.selectByVisibleText("DELETED");
					MyMethods.Sleep(2000); 
					if(driver.findElement(By.id("toastr-container")).isDisplayed())
					{
						message=driver.findElement(By.id("toastr-container")).getText();
					}
					else
					{
						message="";
					}
					
					
					value=select.getFirstSelectedOption().getText().replaceAll("\\s", "");
					if(oldvalue.equals("DELETED"))
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("User list", "User Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "User Email: "+param, 3);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("User list", "User Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "User Email: "+param, 3);
					}
					
					oldvalue=value;
				}
			}
			else if(i==2)
			{
				if(i==skip)
				{
					continue;
				}
				else
				{
					select.selectByVisibleText("INACTIVE");
					MyMethods.Sleep(2000); 
					if(driver.findElement(By.id("toastr-container")).isDisplayed())
					{
						message=driver.findElement(By.id("toastr-container")).getText();
					}
					else
					{
						message="";
					}
					
					
					value=select.getFirstSelectedOption().getText().replaceAll("\\s", "");
					if(oldvalue.equals("INACTIVE"))
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("User list", "User Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "User Email: "+param, 3);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("User list", "User Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "User Email: "+param, 3);
					}
					
					oldvalue=value;
				}
			}
			else
			{
				if(i==skip)
				{
					continue;
				}
				else
				{
					select.selectByVisibleText("SUSPENDED");
					MyMethods.Sleep(2000); 
					if(driver.findElement(By.id("toastr-container")).isDisplayed())
					{
						message=driver.findElement(By.id("toastr-container")).getText();
					}
					else
					{
						message="";
					}
					
					
					value=select.getFirstSelectedOption().getText().replaceAll("\\s", "");
					if(oldvalue.equals("SUSPENDED"))
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("User list", "User Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "User Email: "+param, 3);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("User list", "User Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "User Email: "+param, 3);
					}
					
					oldvalue=value;
				}
			}
			MyMethods.Sleep(5000);
		}
	}
	
	

}
