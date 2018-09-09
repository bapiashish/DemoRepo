package com.qa.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tcdc_TripSeeeding {
	



		public static WebDriver driver;
		public static String URL="http://asmet289.rail.nsw.gov.au:8082/tcdc/metrics";
		
		@BeforeTest
		  public void beforeTest() {
			System.setProperty("webdriver.chrome.driver","D:/chromedriver_win32/chromedriver.exe");//D:/chromedriver_win32
			driver=new ChromeDriver(); 
	  	     driver.manage().window().maximize();
	  	     
		}
		@Test
		  public void tcdcprodTest() throws Exception {
			
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div/ul/li[6]/a")).click();//main menu
				Thread.sleep(1000);
				List<WebElement> menulist=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));

				for(int i=0;i<menulist.size();i++){
					//System.out.println("size is::"+menulist.size());
					WebElement element=menulist.get(i); 
					String innerhtml=element.getAttribute("innerHTML");
					//System.out.println("Values:: " +innerhtml);
					if (innerhtml.contentEquals("Trips Seeding Status")){
						element.click();
						driver.findElement(By.name("username")).sendKeys("jreddy1");//bstone
						driver.findElement(By.name("password")).sendKeys("***");//Password123
						driver.findElement(By.xpath("/html/body/div[2]/div/form/p[5]/input")).click();
						Thread.sleep(2000);
						//driver.get("http://asmet289.rail.nsw.gov.au:8082/tcdc/nodalgeography/trips_seeding_status");
						driver.get("http://asmet289.rail.nsw.gov.au:8082/tcdc/nodalgeography/reseedForm");
					   driver.findElement(By.xpath("/html/body/div[2]/form/input")).click();//Red button--manual reseed
					    /*String value=driver.getPageSource();
						if (value.contains("Nodal geography and static trips re-seeding is requested (will commence if no other seeding is currently running in parallel). Please check status in logs"))
								{Assert.assertTrue(true);}
						else{
							Assert.assertTrue(false);}*/
						break;
					}
				//driver.findElement(By.xpath("/html/body/div[2]/form/input")).click();//--manual reseeed red color buton
	}}}



