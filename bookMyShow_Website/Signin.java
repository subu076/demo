package bookMyShow_Website;
//---------------------------------------- performing only sign in operation in Book My Show--------------------------------------------//
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Signin {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String url="https://in.bookmyshow.com/";
		driver.get(url);
		driver.findElement(By.xpath("//img[@alt=\"CHEN\"]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		By signin=By.xpath("//div[text()=\"Sign in\"]");
		By google=By.xpath("//div[text()=\"Continue with Google\"]");
		driver.findElement(signin).click();
		Thread.sleep(1000);
		driver.findElement(google).click();
		Set<String> demo=driver.getWindowHandles();
		String [] arr=demo.toArray(new String[0]);
		String bookmyshowsignin=arr[0];
		String googlesignin=arr[1];
		Thread.sleep(1000);
		driver.switchTo().window(googlesignin);
		driver.findElement(By.id("identifierId")).sendKeys("unknownsuba@gmail.com");
		driver.findElement(By.xpath("//span[text()=\"Next\"]")).click();
		Thread.sleep(1000);
		WebElement error_msg=driver.findElement(By.xpath("//div[@class=\"Ekjuhf Jj6Lae\"]"));
		System.out.println(error_msg.getText());
	}

}
