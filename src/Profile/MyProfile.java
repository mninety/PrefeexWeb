package Profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import MethodsRepo.MyMethods;
import StartwithPrefeex.VariableModule;

public class MyProfile {

	public static void UserProfile(WebDriver driver)
	{
		try {
			String message="";
			driver.get(VariableModule.adminURL+"/admin/profile");
			MyMethods.Sleep(3000);

			PasswordChanged(driver, "1234", "1234");
			
			String username=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-profile/form/div[2]/div[1]/input")).getAttribute("value");
			String param=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-profile/form/div[4]/div[1]/input")).getAttribute("value");

			String email= driver.findElement(By.name("email")).getAttribute("readonly");

			if(email.equals("true"))
			{
				MyMethods.ExcelFileWriteAction("User Profile", "User Name: "+username+" ,Email readonly?", "Successful", MyMethods.getCurrentDate(), message, "", 4);
			}
			else
			{
				MyMethods.ExcelFileWriteAction("User Profile", "User Name: "+username+" ,Email readonly?", "Failed", MyMethods.getCurrentDate(), message, "", 4);
			}
			

			PhoneTest(driver,username);
			driver.findElement(By.name("phone")).clear();
			driver.findElement(By.name("phone")).sendKeys("01912026219");
			
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-profile/form/div[4]/div[1]/input")).sendKeys("1");
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-profile/form/div[6]/div/button")).click();
			MyMethods.Sleep(5000);
			
			if(driver.findElement(By.id("toastr-container")).isDisplayed())
			{
				message=driver.findElement(By.id("toastr-container")).getText();
				
				if(message.equals("User Updated successfully"))
				{
					//MyMethods.PrintMe("Status: ",value);
					MyMethods.ExcelFileWriteAction("User Profile", "User Name: "+username+" ,Profile updated?", "Successful", MyMethods.getCurrentDate(), message, "New Password: "+param+"1", 4);
				}
				else
				{
					//MyMethods.PrintMe("Status: ",value);
					MyMethods.ExcelFileWriteAction("User Profile", "User Name: "+username+" ,Profile updated?", "Failed", MyMethods.getCurrentDate(), message, "New Password: "+param+"1", 4);
				}
				
			}
			else
			{
				message="";
				
				MyMethods.ExcelFileWriteAction("User Profile", "User Name: "+username+" ,Password Changed?", "Failed", MyMethods.getCurrentDate(), message, "New Password: "+param+"1", 4);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void PasswordChanged(WebDriver driver, String oldpass, String newpass)
	{
		try {
			
			String message="";
			String param=driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-profile/form/div[2]/div[1]/input")).getAttribute("value");
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-profile/form/div[1]/div[3]/span/strong")).click();
			driver.findElement(By.id("currentPassword")).sendKeys(oldpass);
			driver.findElement(By.name("newPassword")).sendKeys(newpass);
			driver.findElement(By.name("confirmNewPassword")).sendKeys(newpass);
			driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-profile/p-dialog/div/div[2]/div/app-change-password/form/div/div/div[4]/div/button")).click();
			
			MyMethods.Sleep(3000);
			if(driver.findElement(By.id("toastr-container")).isDisplayed())
			{
				message=driver.findElement(By.id("toastr-container")).getText();
				
				if(message.equals("Password updated successfully"))
				{
					//MyMethods.PrintMe("Status: ",value);
					MyMethods.ExcelFileWriteAction("User Profile", "User Name: "+param+" ,Password Changed?", "Successful", MyMethods.getCurrentDate(), message, "New Password: "+newpass, 4);
				}
				else
				{
					//MyMethods.PrintMe("Status: ",value);
					MyMethods.ExcelFileWriteAction("User Profile", "User Name: "+param+" ,Password Changed?", "Failed", MyMethods.getCurrentDate(), message, "New Password: "+newpass, 4);
				}
				
			}
			else
			{
				message="";
				
				MyMethods.ExcelFileWriteAction("User Profile", "User Name: "+param+" ,Password Changed?", "Failed", MyMethods.getCurrentDate(), message, "New Password: "+newpass, 4);
				
			}
			MyMethods.Sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void PhoneTest(WebDriver driver, String username)
	{
		driver.findElement(By.name("phone")).clear();
		driver.findElement(By.name("phone")).sendKeys("01844572110");

		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-profile/form/div[4]/div[1]/input")).sendKeys("1");
		driver.findElement(By.xpath("/html/body/app-root/app-admin/div/div[5]/div/app-profile/form/div[6]/div/button")).click();
		MyMethods.Sleep(2000);
		
		String message1=driver.findElement(By.id("toastr-container")).getText();
		if(message1.equals("phone must be unique"))
		{
			MyMethods.ExcelFileWriteAction("User Profile", "User Name: "+username+" ,Duplicate phone Allowed?", "Successful", MyMethods.getCurrentDate(), message1, "Phone: 01844572110", 4);
		
			
		}
		else
		{
			MyMethods.ExcelFileWriteAction("User Profile", "User Name: "+username+" ,Duplicate phone Allowed?", "Failed", MyMethods.getCurrentDate(), message1, "Phone: 01844572110", 4);
		}
		
		
	}

}
