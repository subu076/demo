package bookMyShow_Website;
//---------------------------------------performing only sport webpage in Book My Show ----------------------------//
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Sports {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String url="https://in.bookmyshow.com/";
		By name=By.xpath("//*[@id=\"super-container\"]/div[2]/div[3]/div[2]/div//div/div[1]/div[2]/a/div/div[3]/div[1]/div");
		By lang=By.xpath("//*[@id=\"super-container\"]/div[2]/div[3]/div[2]/div//div/div[1]/div[2]/a/div/div[3]/div[3]/div");
		By weekend=By.xpath("//div[@class=\"sc-7o7nez-0 ehthfR\" and text()=\"This Weekend\"]");
		driver.get(url);
		driver.findElement(By.xpath("//img[@alt=\"CHEN\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Sports\"]")).click();
		Thread.sleep(1000);
		driver.findElement(weekend).click();
		
	}

}
