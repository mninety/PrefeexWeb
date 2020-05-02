package MenuModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import MethodsRepo.MyMethods;
import StartwithPrefeex.VariableModule;

public class MyMenu {

	public static void CreateMenuTest(WebDriver driver)
	{
		try {
			driver.get(VariableModule.adminURL+"/admin/business");
			MyMethods.Sleep(2000);
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-info/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[1]/a")).click();
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/div/div/div/a[3]")).click();
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-menu/div[1]/div/div/a")).click();
			MyMethods.Sleep(3000);
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-menu-form/form/div[1]/div/p-dropdown/div/label")).click();
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-menu-form/form/div[1]/div/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]/li")).click();
			
			String menuname=VariableModule.RandomStringGen(5);
			driver.findElement(By.name("itemName")).sendKeys(menuname);
			driver.findElement(By.name("primaryPhoto")).sendKeys(VariableModule.driverlog+"/FoodImages/Beef-Hamburgers_7-2.jpg");
			driver.findElement(By.name("price")).sendKeys("200");
			driver.findElement(By.name("itemDescription")).sendKeys("Test Food Item");
			
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-menu-form/form/div[6]/div/button")).click();
			
			 
			Thread.sleep(5000);
			
			String title=driver.getTitle();
			String message=driver.findElement(By.id("toastr-container")).getText();
			
			if(title.equals("Menu"))
			{
				MyMethods.ExcelFileWriteAction("Manage Business -> Create Menu", "Create Menu with data", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+menuname, 1);
				
				EditMenuTest(driver);
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Manage Business -> Create Menu", "Create Menu with data", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+menuname, 1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void EditMenuTest(WebDriver driver) //menuname find issue
	{
		try {
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-menu/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[8]/a")).click();

			String menuname=driver.findElement(By.name("itemName")).getAttribute("value");
			MyMethods.PrintMe("Menu Name: ", menuname);
			driver.findElement(By.name("primaryPhoto")).sendKeys(VariableModule.driverlog+"/FoodImages/Beef-Hamburgers_7-2.jpg");
			
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-menu/p-dialog/div/div[2]/div/app-menu-form/form/div[6]/div/button")).click();
			
			 
			Thread.sleep(3000);
			
			String title=driver.getTitle();
			String message=driver.findElement(By.id("toastr-container")).getText();
			
			if(title.equals("Menu"))
			{
				MyMethods.ExcelFileWriteAction("Manage Business -> Edit Menu", "Edit Menu with data", "Successful", MyMethods.getCurrentDate(), message, "BusinessName: "+menuname, 1);
				
				//Business.BusinessTest(driver, businame);
				

			}
			else
			{
				MyMethods.ExcelFileWriteAction("Manage Business -> Edit Menu", "Edit Menu with data", "Failed", MyMethods.getCurrentDate(), message, "BusinessName: "+menuname, 1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void AddonTest(WebDriver driver)
	{
		
		driver.get(VariableModule.adminURL+"/admin/business");
		MyMethods.Sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-info/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[1]/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/div/div/div/a[3]")).click();
		
		MyMethods.Sleep(2000);
		
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-menu/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[7]/a")).click();
		MyMethods.Sleep(2000);
		
		String title=driver.getTitle();
		
		
		if(title.equals("Addons"))
		{
			MyMethods.ExcelFileWriteAction("Manage Business -> Addons Button", "Addons button funcational?", "Successful", MyMethods.getCurrentDate(), "", "", 1);
			
			//Business.BusinessTest(driver, businame);
			AddonsAddTest(driver);
			AddonStatusTest(driver);
		}
		else
		{
			MyMethods.ExcelFileWriteAction("Manage Business -> Addons Button", "Addons button funcational?", "Failed", MyMethods.getCurrentDate(), "", "", 1);
		}
		
		
	}
	public static void AddonsAddTest(WebDriver driver)
	{
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-business/app-add-ons/div[1]/div/div/a")).click();
		MyMethods.Sleep(3000);
		
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-business/app-add-ons-form/form/div[1]/div/p-dropdown/div/label")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-business/app-add-ons-form/form/div[1]/div/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]/li")).click();
		
		String addonstitlename=VariableModule.RandomStringGen(5);
		driver.findElement(By.name("title")).sendKeys(addonstitlename);
		
		String addonsname=VariableModule.RandomStringGen(5);
		driver.findElement(By.name("name")).sendKeys(addonsname);
		
		driver.findElement(By.name("price")).clear();
		driver.findElement(By.name("price")).sendKeys("200");
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-business/app-add-ons-form/form/div[3]/div[3]/button")).click();
		
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-business/app-add-ons-form/form/div[5]/div/button")).click();
		MyMethods.Sleep(3000);
		String title=driver.getTitle();

			if(title.equals("Addons"))
			{
				MyMethods.ExcelFileWriteAction("Manage Business -> Addons Create", "Addons created?", "Successful", MyMethods.getCurrentDate(), "", "Addon Title: "+addonstitlename+", Addon Name: "+addonsname, 1);
				
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Manage Business -> Addons Create", "Addons created?", "Failed", MyMethods.getCurrentDate(), "", "Addon Title: "+addonstitlename+", Addon Name: "+addonsname, 1);
			}

			AddonsEditTest(driver);
	}

	public static void AddonsEditTest(WebDriver driver)
	{
		try {
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-business/app-add-ons/div[2]/div/p-table/div/div/table/tbody/tr[1]/td[3]/a")).click();
			MyMethods.Sleep(3000);
			
			String addonname1=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-business/app-add-ons-form/form/div[3]/div/ul/li/div/span[1]")).getText();
			//MyMethods.PrintMe("AddonName1: ", addonname1);
			
			String addonsname=VariableModule.RandomStringGen(5);
			driver.findElement(By.name("name")).sendKeys(addonsname);
			
			driver.findElement(By.name("price")).clear();
			driver.findElement(By.name("price")).sendKeys("250");
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-business/app-add-ons-form/form/div[4]/div[3]/button")).click();
			MyMethods.Sleep(2000);
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-business/app-add-ons-form/form/div[3]/div/ul/li[1]/div/button")).click();
			
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-business/app-add-ons-form/form/div[5]/div/button")).click();
			MyMethods.Sleep(3000);
			String title=driver.getTitle();
			String message="";
			if(driver.findElement(By.id("toastr-container")).isDisplayed())
			{
				message=driver.findElement(By.id("toastr-container")).getText();
				
				
				if(title.equals("Addons"))
				{
					MyMethods.ExcelFileWriteAction("Manage Business -> Addons Edit", "Addons Edited?", "Successful", MyMethods.getCurrentDate(), message, "Addon Name: "+addonsname, 1);
					
				}
				else
				{
					MyMethods.ExcelFileWriteAction("Manage Business -> Addons Edit", "Addons Edited?", "Failed", MyMethods.getCurrentDate(), message, "Addon Name: "+addonsname, 1);
				}
			}
			else
			{
				MyMethods.ExcelFileWriteAction("Manage Business -> Addons Edit", "Addons Edit?", "Failed", MyMethods.getCurrentDate(), message, "Addon Name: "+addonsname, 1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static void MenuTest(WebDriver driver)
	{
		
		driver.get(VariableModule.adminURL+"/admin/business");
		MyMethods.Sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-info/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[1]/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/div/div/div/a[3]")).click();
		
		MyMethods.Sleep(2000);
		
		String param=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-menu/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[2]")).getText();
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-menu/div[3]/div/p-table/div/div/table/tbody/tr[1]/td[6]/select")));
		WebElement option = select.getFirstSelectedOption();
		String curstatus=option.getText();
		curstatus = curstatus.replaceAll("\\s", "");
		
		GetMenuStatus(curstatus,driver,select,param);
	}
	public static void GetMenuStatus(String value, WebDriver driver, Select select, String param)
	{
		//BusinessUserEditButtonCheck(value,driver,"",param);

			
		
		  if(value.equals("ACTIVE")) //ACTIVE 
		  { 
			  MenuStatusChange(value, driver,select,param,0); 
		  } 
		  else if(value.equals("DELETED")) //DELETED 
		  {
			  MenuStatusChange(value, driver, select,param,1); 
		  } 
		  else if(value.equals("PENDING")) //PENDING 
		  { 
			  MenuStatusChange(value,driver, select,param,2); 
		  } 
		  else //DEACTIVATED 
		  { 
			  MenuStatusChange(value, driver,select,param,3); 
		  }
		 
			
		

	}

	public static void MenuStatusChange(String value, WebDriver driver, Select select, String param, int skip)
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
						MyMethods.ExcelFileWriteAction("Menu List", "Menu Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "MenuName: "+param, 3);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Menu list", "Menu Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "MenuName: "+param, 3);
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
						MyMethods.ExcelFileWriteAction("Menu List", "Menu Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "MenuName: "+param, 3);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Menu list", "Menu Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "MenuName: "+param, 3);
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
						MyMethods.ExcelFileWriteAction("Menu List", "Menu Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "MenuName: "+param, 3);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Menu list", "Menu Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "MenuName: "+param, 3);
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
					select.selectByVisibleText("DEACTIVATED");
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
					if(oldvalue.equals("DEACTIVATED"))
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Menu List", "Menu Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "MenuName: "+param, 3);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Menu list", "Menu Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "MenuName: "+param, 3);
					}
					
					
					oldvalue=value;
				}
			}
			MyMethods.Sleep(5000);
		}
	}
	
	
	public static void AddonStatusTest(WebDriver driver)
	{
		
		String param=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-business/app-add-ons/div[2]/div/p-table/div/div/table/tbody/tr/td[1]")).getText();
		Select select = new Select(driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-business/app-business-container-dynamic/app-business/app-business/app-add-ons/div[2]/div/p-table/div/div/table/tbody/tr/td[2]/select")));
		WebElement option = select.getFirstSelectedOption();
		String curstatus=option.getText();
		curstatus = curstatus.replaceAll("\\s", "");
		
		GetAddonStatus(curstatus,driver,select,param);
	}
	public static void GetAddonStatus(String value, WebDriver driver, Select select, String param)
	{
		//BusinessUserEditButtonCheck(value,driver,"",param);

			
		
		  if(value.equals("ACTIVE")) //ACTIVE 
		  { 
			  AddonStatusChange(value, driver,select,param,0); 
		  } 
		  else //DELETED 
		  {
			  AddonStatusChange(value, driver, select,param,1); 
		  } 

		 
			
		

	}

	public static void AddonStatusChange(String value, WebDriver driver, Select select, String param, int skip)
	{
		String oldvalue=value;
		String message="";
		for(int i=0;i<2;i++)
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
						MyMethods.ExcelFileWriteAction("Addon List", "Addon Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "AddonName: "+param, 2);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Addon list", "Addon Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "AddonName: "+param, 2);
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
					select.selectByVisibleText("DELETED");
					MyMethods.Sleep(3000); 
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
						MyMethods.ExcelFileWriteAction("Addon List", "Addon Status: "+value+" ,status did not changed yet", "Failed", MyMethods.getCurrentDate(), message, "AddonName: "+param, 2);
					}
					else
					{
						//MyMethods.PrintMe("Status: ",value);
						MyMethods.ExcelFileWriteAction("Addon list", "Addon Status: "+value+" ,status did not changed yet", "Successful", MyMethods.getCurrentDate(), message, "AddonName: "+param, 2);
					}
					
					
					oldvalue=value;
				}
			}

			MyMethods.Sleep(5000);
		}
	}
	
}
