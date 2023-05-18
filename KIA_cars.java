package MavenPackage;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class KIA_cars 
{
	WebDriver driver;
	@BeforeMethod
	public void before()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://bhaskarab7.github.io/KiaCars/Kia_Home.html");
	}
	
  @Test(priority=1)
  public void home() 
  {
	  String home_title=driver.getTitle();
		driver.findElement(By.xpath("//*[text()='Home']")).click();
		if(driver.getTitle().equals(home_title))
		{
			System.out.println("Not Navigated to home Page");
		}
		else
		{
			System.out.println("Navigated to home Page");
		}
		
  }
	
	@Test(priority=2)
	public void dropdown()
	{
		driver.findElement(By.linkText("Models")).click();
		List<WebElement> drpdwn =driver.findElements(By.xpath("//*[@class='dropdown-item']"));
		System.out.println("Dropdown contains");
		for(WebElement i : drpdwn)
		{
			System.out.println(i.getText());
		}
	}
		
		@Test(priority=3)
		public void dropdownselect() throws InterruptedException
		{
			String ev_title = "Kia EV6 Electric Car Price 2023 | Colors, Images and Features | Book Now";
			driver.findElement(By.linkText("Models")).click();
			List<WebElement> drp =driver.findElements(By.xpath("//*[@class='dropdown-item']"));
			
			for(WebElement j : drp)
			{
				if((j.getText()).contains("Kia EV6"))
				{
					j.click();
					Thread.sleep(2000);
					driver.navigate().back();
					
					if(driver.getTitle().contains(ev_title))
					{
						System.out.println("Navigated to Kia EV6");
					}
					else
					{
						System.out.println("Not Navigated to Kia EV6");
					}
						
				}
			}
		}
		
		
		@Test(priority=4)
		public void FAQ()
		{
			String home_title=driver.getTitle();
			driver.findElement(By.linkText("FAQs")).click();
			if(driver.getTitle().equals(home_title))
			{
				System.out.println("Not Navigated to FAQs Page");
			}
			else
			{
				System.out.println("Navigated to FAQs Page");
			}
			
		}
		
		
		@Test(priority=5)
		public void Highlight()
		{
			String home_title=driver.getTitle();
			driver.findElement(By.linkText("Highlights")).click();
			if(driver.getTitle().equals(home_title))
			{
				System.out.println("Not Navigated to Highlights Page");
			}
			else
			{
				System.out.println("Navigated to Highlights Page");
			}
			
		}
		
		
		@Test(priority=6)
		public void search() throws InterruptedException
		{
			driver.findElement(By.xpath("//*[@class=\"form-control me-2\"]")).sendKeys("Kia");
			Thread.sleep(2000);
			System.out.println("No Suggestions found");
				
		}
		
		
		@Test(priority=7)
		public void search_btn()
		{
			String home_title=driver.getTitle();
			driver.findElement(By.xpath("//*[@class=\"form-control me-2\"]")).sendKeys("Kia EV6");
			driver.findElement(By.xpath("//*[text()=\"Search\"]")).click();
			if(driver.getTitle().equals(home_title))
			{
				System.out.println("Not Navigated to Searched car Page");
			}
			else
			{
				System.out.println("Navigated to Searched car Page");
			}
				
		}
		
		
		@Test(priority=7)
		public void slider() throws InterruptedException
		{
			for(int i=0;i<8;i++)
			{
				driver.findElement(By.xpath("//*[@class='carousel-control-next-icon']")).click();
				Thread.sleep(1000);
			}
			
			System.out.println("Next icon arrow is not aligned");
			
			
		}		
			
  @AfterMethod
  public void after() throws InterruptedException
  {
	  Thread.sleep(3000);
	  driver.close();
  }
}