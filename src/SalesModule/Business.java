package SalesModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import LoginModule.MyLogin;
import MethodsRepo.MyMethods;
import StartwithPrefeex.VariableModule;

public class Business {

	static String curuserurl="";
	static String curuserediturl="";
	public static void BusinessTest(WebDriver driver, String businame)
	{
		//MyLogin.DirectLogin(driver);
		
		driver.get(VariableModule.adminURL+"/admin/sales/create-business");
		WebDriverWait wait = new WebDriverWait(driver, 30);// 30 sec 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String param=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[1]")).getText();
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[7]/select")));
		WebElement option = select.getFirstSelectedOption();
		String curstatus=option.getText();
		curstatus = curstatus.replaceAll("\\s", "");
		//System.out.println("Status: "+curstatus);

		GetBusinessStatus(curstatus,driver,select,param);
		
		
	}
	
	public static void UserButtonCheck(String value, WebDriver driver, String message, String param)
	{
		if(value.equals("APPROVED")) //Approved
		{
			if(!driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[8]/button")).getText().equals(""))
			{
				MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,Users button should be visible", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
			}
			else
			{
				
				MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,Users button should be visible", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
			}
		}
		else if(value.equals("PENDING")) //Pending
		{
			if(!driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[8]")).getText().equals(""))
			{
				MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,Users button should not be visible", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,Users button should not be visible", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
			}
		}
		else if(value.equals("SUSPENDED")) //Suspended
		{
			if(!driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[8]")).getText().equals(""))
			{
				MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,Users button should not be visible", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,Users button should not be visible", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
			}
		}
		else //Deleted
		{
			if(!driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[8]")).getText().equals(""))
			{
				MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,Users button should not be visible", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,Users button should not be visible", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
			}
		}
	}

	public static void BusinessUserEditButtonCheck(String value, WebDriver driver, String message, String param)
	{
		if(value.equals("ACTIVE")) //ACTIVE
		{
			if(!driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[6]/a")).getText().equals(""))
			{
				MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,Users edit button should be visible", "Successful", MyMethods.getCurrentDate(), message, "Business UserName: "+param, 7);
			}
			else
			{
				
				MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,Users edit button should be visible", "Failed", MyMethods.getCurrentDate(), message, "Business UserName: "+param, 7);
			}
		}
		else if(value.equals("DELETED")) //DELETED
		{
			if(!driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[6]")).getText().equals(""))
			{
				MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,Users edit button should not be visible", "Failed", MyMethods.getCurrentDate(), message, "Business UserName: "+param, 7);
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,Users edit button should not be visible", "Successful", MyMethods.getCurrentDate(), message, "Business UserName: "+param, 7);
			}
		}
		else if(value.equals("INACTIVE")) //INACTIVE
		{
			if(!driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[6]")).getText().equals(""))
			{
				MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,Users edit button should not be visible", "Failed", MyMethods.getCurrentDate(), message, "Business UserName: "+param, 7);
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,Users edit button should not be visible", "Successful", MyMethods.getCurrentDate(), message, "Business UserName: "+param, 7);
			}
		}
		else //SUSPENDED
		{
			if(!driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[6]")).getText().equals(""))
			{
				MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,Users edit button should not be visible", "Failed", MyMethods.getCurrentDate(), message, "Business UserName: "+param, 7);
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,Users edit button should not be visible", "Successful", MyMethods.getCurrentDate(), message, "Business UserName: "+param, 7);
			}
		}
	}

	public static void BusinessStatusChange(String value, WebDriver driver, Select select, String param, int skip)
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
					select.selectByVisibleText("PENDING");
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
					if(oldvalue.equals("PENDING"))
					{
						//MyMethods.PrintMe("Status: ",value);
						//System.out.println("Status: "+value);
						MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					
					UserButtonCheck(value,driver,message,param);
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
						MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					
					UserButtonCheck(value,driver,message,param);
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
					select.selectByVisibleText("APPROVED");
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
					if(oldvalue.equals("APPROVED"))
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					
					UserButtonCheck(value,driver,message,param);
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
						MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business list", "Business Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					
					UserButtonCheck(value,driver,message,param);
					oldvalue=value;
				}
			}
			MyMethods.Sleep(5000);
		}
	}
	
	public static void BusinessUserStatusChange(String value, WebDriver driver, Select select, String param, int skip)
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
						MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					
					BusinessUserEditButtonCheck(value,driver,message,param);
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
						MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					
					BusinessUserEditButtonCheck(value,driver,message,param);
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
						MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					
					BusinessUserEditButtonCheck(value,driver,message,param);
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
						MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business User list", "Business User Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+param, 7);
					}
					
					BusinessUserEditButtonCheck(value,driver,message,param);
					oldvalue=value;
				}
			}
			MyMethods.Sleep(5000);
		}
	}
	
	public static void GetBusinessStatus(String value, WebDriver driver, Select select, String param)
	{
		UserButtonCheck(value,driver,"",param);

			
		
		  if(value.equals("APPROVED")) //Approved 
		  { 
			  BusinessStatusChange(value, driver,select,param,2); 
		  } 
		  else if(value.equals("PENDING")) //Pending 
		  {
			  BusinessStatusChange(value, driver, select,param,0); 
		  } 
		  else if(value.equals("SUSPENDED")) //Suspended 
		  { 
			  BusinessStatusChange(value,driver, select,param,1); 
		  } 
		  else //Deleted 
		  { 
			  BusinessStatusChange(value, driver,select,param,3); 
		  }
		 
			
		

	}

	public static void GetBusinessUserStatus(String value, WebDriver driver, Select select, String param)
	{
		BusinessUserEditButtonCheck(value,driver,"",param);

			
		
		  if(value.equals("ACTIVE")) //ACTIVE 
		  { 
			  BusinessUserStatusChange(value, driver,select,param,0); 
		  } 
		  else if(value.equals("DELETED")) //DELETED 
		  {
			  BusinessUserStatusChange(value, driver, select,param,1); 
		  } 
		  else if(value.equals("INACTIVE")) //INACTIVE 
		  { 
			  BusinessUserStatusChange(value,driver, select,param,2); 
		  } 
		  else //SUSPENDED 
		  { 
			  BusinessUserStatusChange(value, driver,select,param,3); 
		  }
		 
			
		

	}

	public static void UserButtonTest(WebDriver driver)
	{
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
			
			curuserurl=driver.getCurrentUrl();
			MyMethods.PrintMe("Current URL: ", curuserurl);
			
			if(driver.getTitle().equals("Business Users"))
			{
				MyMethods.ExcelFileWriteAction("Business Users Button", "Business Status: APPROVED, Users Button: Functional?", "Successful", MyMethods.getCurrentDate(), "", "BusinessName: "+param, 4);
				CreateBusiness.AddBusinessUser(driver);
				
				
				
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Business Users Button", "Business Status: APPROVED, Users Button: Functional?", "Failed", MyMethods.getCurrentDate(), "", "BusinessName: "+param, 4);
			}

		}
		else
		{
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[8]/button")).click();
			MyMethods.Sleep(2000);
			
			curuserurl=driver.getCurrentUrl();
			MyMethods.PrintMe("Current URL: ", curuserurl);
			
			if(driver.getTitle().equals("Business Users"))
			{
				MyMethods.ExcelFileWriteAction("Business Users Button", "Business Status: APPROVED, Users Button: Functional?", "Successful", MyMethods.getCurrentDate(), "", "BusinessName: "+param, 4);
				CreateBusiness.AddBusinessUser(driver);
				
				
				
				
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Business Users Button", "Business Status: APPROVED, Users Button: Functional?", "Failed", MyMethods.getCurrentDate(), "", "BusinessName: "+param, 4);
			}
		}
		
	}
	
	public static void UserEditButtonTest(WebDriver driver)
	{
		driver.get(VariableModule.adminURL+"/admin/sales/create-business");
		//WebDriverWait wait = new WebDriverWait(driver, 30);// 30 sec 
		MyMethods.Sleep(5000);
		
		
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


		}
		else
		{
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[8]/button")).click();
			MyMethods.Sleep(2000);
			
			 
		}
		
		String param=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[3]")).getText();
		Select select1 = new Select(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[5]/select")));
		WebElement option1 = select1.getFirstSelectedOption();
		String curstatus1=option1.getText();
		curstatus1 = curstatus1.replaceAll("\\s", "");
		
		if(!curstatus1.equals("ACTIVE"))
		{
			select1.selectByVisibleText("ACTIVE");
			MyMethods.Sleep(2000);
			
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[6]/a")).click();
			MyMethods.Sleep(2000);
			
			curuserediturl=driver.getCurrentUrl();
			MyMethods.PrintMe("Current Edit URL: ", curuserediturl);
			
			if(driver.getTitle().equals("Edit Business User"))
			{
				MyMethods.ExcelFileWriteAction("Business User Edit Button", "Business Status: ACTIVE, User Edit Button: Functional?", "Successful", MyMethods.getCurrentDate(), "", "Business UserName: "+param, 4);

				
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Business User Edit Button", "Business User Status: ACTIVE, User Edit Button: Functional?", "Failed", MyMethods.getCurrentDate(), "", "Business UserName: "+param, 4);
			}

		}
		else
		{
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[6]/a")).click();
			MyMethods.Sleep(2000);
			
			curuserediturl=driver.getCurrentUrl();
			MyMethods.PrintMe("Current Edit URL: ", curuserediturl);
			
			if(driver.getTitle().equals("Edit Business User"))
			{
				MyMethods.ExcelFileWriteAction("Business User Edit Button", "Business User Status: ACTIVE, User Edit Button: Functional?", "Successful", MyMethods.getCurrentDate(), "", "Business UserName: "+param, 4);

			}
			else
			{
				MyMethods.ExcelFileWriteAction("Business User Edit Button", "Business User Status: ACTIVE, User Edit Button: Functional?", "Failed", MyMethods.getCurrentDate(), "", "Business UserName: "+param, 4);
			}
		}
		
	}
	
	
	public static void UserButtonPermissionTest(WebDriver driver)
	{
		String message="";
		
		UserButtonTest(driver);
		
		driver.get(VariableModule.adminURL+"/admin/sales/create-business");
		MyMethods.Sleep(3000);
		
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[7]/select")));
		for(int i=0;i<3;i++)
		{
			if(i==0)
			{

					select.selectByVisibleText("PENDING");
					MyMethods.Sleep(2000); 
					driver.get(curuserurl);
					MyMethods.Sleep(2000); 
					
					if(driver.getTitle().equals("Business Users"))
					{

						MyMethods.ExcelFileWriteAction("Business Users Button", "Business Stauts: PENDING, Business users button accessible?", "Failed", MyMethods.getCurrentDate(), message, "", 4);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business Users Button", "Business Stauts: PENDING, Business users button accessible?", "Successful", MyMethods.getCurrentDate(), message, "", 4);
					}
					driver.get(VariableModule.adminURL+"/admin/sales/create-business");
					MyMethods.Sleep(2000);
			}
			else if(i==1)
			{
					Select select1 = new Select(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[7]/select")));
					select1.selectByVisibleText("SUSPENDED");
					MyMethods.Sleep(2000); 
					driver.get(curuserurl);
					MyMethods.Sleep(2000); 
					
					if(driver.getTitle().equals("Business Users"))
					{

						MyMethods.ExcelFileWriteAction("Business Users Button", "Business Stauts: SUSPENDED, Business users button accessible?", "Failed", MyMethods.getCurrentDate(), message, "", 4);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business Users Button", "Business Stauts: SUSPENDED, Business users button accessible?", "Successful", MyMethods.getCurrentDate(), message, "", 4);
					}
					driver.get(VariableModule.adminURL+"/admin/sales/create-business");
					MyMethods.Sleep(2000);
			}

			else
			{
					Select select2 = new Select(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[7]/select")));
					select2.selectByVisibleText("DELETED");
					MyMethods.Sleep(2000); 
					driver.get(curuserurl);
					MyMethods.Sleep(2000); 
					
					if(driver.getTitle().equals("Business Users"))
					{

						MyMethods.ExcelFileWriteAction("Business Users Button", "Business Stauts: DELETED, Business users button accessible?", "Failed", MyMethods.getCurrentDate(), message, "", 4);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business Users Button", "Business Stauts: DELETED, Business users button accessible?", "Successful", MyMethods.getCurrentDate(), message, "", 4);
					}
					
					MyMethods.Sleep(2000);
			}
			//MyMethods.Sleep(5000);
		}
	}
	
	public static void UserEditButtonPermissionTest(WebDriver driver)
	{
		String message="";
		
		UserEditButtonTest(driver);
		
		driver.get(VariableModule.adminURL+"/admin/sales/create-business");
		MyMethods.Sleep(3000);
		
		for(int i=0;i<3;i++)
		{
			
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


		}
		else
		{
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[8]/button")).click();
			MyMethods.Sleep(2000);
			
			 
		}
		
		

			if(i==0)
			{
					Select select1 = new Select(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[5]/select")));
					select1.selectByVisibleText("INACTIVE");
					MyMethods.Sleep(2000); 
					driver.get(curuserediturl);
					MyMethods.Sleep(2000); 
					
					if(driver.getTitle().equals("Edit Business User"))
					{

						MyMethods.ExcelFileWriteAction("Business User Edit Button", "Business User Stauts: INACTIVE, Business user edit button accessible?", "Failed", MyMethods.getCurrentDate(), message, "", 4);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business User Edit Button", "Business User Stauts: INACTIVE, Business user edit button accessible?", "Successful", MyMethods.getCurrentDate(), message, "", 4);
					}
					driver.get(VariableModule.adminURL+"/admin/sales/create-business");
					MyMethods.Sleep(2000);
			}
			else if(i==1)
			{
					Select select2 = new Select(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[5]/select")));
					select2.selectByVisibleText("DELETED");
					MyMethods.Sleep(2000); 
					driver.get(curuserediturl);
					MyMethods.Sleep(2000); 
					
					if(driver.getTitle().equals("Edit Business User"))
					{

						MyMethods.ExcelFileWriteAction("Business User Edit Button", "Business User Stauts: DELETED, Business user edit button accessible?", "Failed", MyMethods.getCurrentDate(), message, "", 4);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business User Edit Button", "Business User Stauts: DELETED, Business user edit button accessible?", "Successful", MyMethods.getCurrentDate(), message, "", 4);
					}
					driver.get(VariableModule.adminURL+"/admin/sales/create-business");
					MyMethods.Sleep(2000);
			}

			else
			{
					Select select3 = new Select(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[5]/select")));
					select3.selectByVisibleText("SUSPENDED");
					MyMethods.Sleep(2000); 
					driver.get(curuserediturl);
					MyMethods.Sleep(2000); 
					
					if(driver.getTitle().equals("Edit Business User"))
					{

						
						MyMethods.ExcelFileWriteAction("Business User Edit Button", "Business User Stauts: SUSPENDED, Business user edit button accessible?", "Failed", MyMethods.getCurrentDate(), message, "", 4);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Business User Edit Button", "Business User Stauts: SUSPENDED, Business user edit button accessible?", "Successful", MyMethods.getCurrentDate(), message, "", 4);
					}
					
					MyMethods.Sleep(2000);
			}
			//MyMethods.Sleep(5000);
		}
	}

	public static void UserStatusTest(WebDriver driver)
	{
		CreateBusiness.AddBusinessUserTest(driver);
		
		driver.get(VariableModule.adminURL+"/admin/sales/create-business");
		//WebDriverWait wait = new WebDriverWait(driver, 30);// 30 sec 
		MyMethods.Sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[8]/button")).click();
		MyMethods.Sleep(3000);
		
		String param=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[3]")).getText();
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-users/app-business-user-container/app-business-user/div[4]/div/p-table/div/div/table/tbody/tr[1]/td[5]/select")));
		WebElement option = select.getFirstSelectedOption();
		String curstatus=option.getText();
		curstatus = curstatus.replaceAll("\\s", "");
		
		GetBusinessUserStatus(curstatus,driver,select,param);
		
	}
	
	public static void PaggitionTest(WebDriver driver)
	{
		
		String page=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[2]/div[2]/p-paginator/div/span")).getText();
		//System.out.println("Total Page: "+page);
		int[] noofpage;
		String strsum="";
		for(int i=0;i<page.length();i++){
		char c=page. charAt(i);
		String str=Character.toString(c);
		strsum=strsum+str+",";

		}
		
		strsum=strsum.substring(0, strsum.length()-1);
		//System.out.println("StrSUM: "+strsum);
		
		String[] teststr=strsum.split(",");
		int lenght=Integer.valueOf(strsum.length());
		
		boolean test=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[2]/div[2]/p-paginator/div/a[1]")).isEnabled();
		if(test)
		{
			System.out.println("This is First Page!!!");
			if(lenght>1) //Single Next/Previous
			{
				if(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[2]/div[2]/p-paginator/div/a[3]")).isEnabled())
				{
					driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[2]/div[2]/p-paginator/div/a[3]")).click();
					MyMethods.Sleep(2000);
					
					if(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[2]/div[2]/p-paginator/div/a[2]")).isEnabled())
					{
						MyMethods.ExcelFileWriteAction("Paggination", "Single Next", "Successful", MyMethods.getCurrentDate(), "","", 1);
						driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[2]/div[2]/p-paginator/div/a[2]")).click();
						driver.navigate().refresh();
						MyMethods.Sleep(2000);
						
						if(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[2]/div[2]/p-paginator/div/span/a[2]")).isEnabled())
						{
							MyMethods.ExcelFileWriteAction("Paggination", "Single Previous", "Failed", MyMethods.getCurrentDate(), "","", 1);
						}
						else
						{
							MyMethods.ExcelFileWriteAction("Paggination", "Single Previous", "Successful", MyMethods.getCurrentDate(), "","", 1);
						}
					}
					else
					{
						MyMethods.ExcelFileWriteAction("Paggination", "Single Next", "Failed", MyMethods.getCurrentDate(), "","", 1);
					}
						
					
				}
				else
				{
					MyMethods.ExcelFileWriteAction("Paggination", "Single Next", "Failed", MyMethods.getCurrentDate(), "","", 1);
				}
			}
			else
			{
				if(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-sales/app-create-business/div[2]/div[2]/p-paginator/div/a[3]")).isEnabled())
				{
					MyMethods.ExcelFileWriteAction("Paggination", "Single Next", "Failed", MyMethods.getCurrentDate(), "","", 1);
				}
				else
				{
					MyMethods.ExcelFileWriteAction("Paggination", "Single Next", "Successful", MyMethods.getCurrentDate(), "","", 1);
				}
			}
		}
		

		
	}

}
