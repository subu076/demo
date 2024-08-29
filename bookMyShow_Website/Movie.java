package bookMyShow_Website;
//------------------------------------------------ performing only movies webpage in Book My Show ----------------------------------------//
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;

public class Movie 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//implict wait using java(Time unit)
		driver.manage().window().maximize();//maximizing the window
		String url="https://in.bookmyshow.com/";//url of the webpage to be automated
		By name=By.xpath("//*[@id=\"super-container\"]/div[2]/div[3]/div[2]/div//div/div[1]/div[2]/a/div/div[3]/div[1]/div");//xpath to collect the name of the movies
		By lang=By.xpath("//*[@id=\"super-container\"]/div[2]/div[3]/div[2]/div//div/div[1]/div[2]/a/div/div[3]/div[3]/div");//xpath to collect the language of the movies
		driver.get(url);
		driver.findElement(By.xpath("//img[@alt=\"CHEN\"]")).click();//clicking the location
		driver.findElement(By.xpath("//a[text()=\"Movies\"]")).click();//going to movies webpage
		List<WebElement> names=driver.findElements(name);//collecting all the movie names and stored in List
		List<WebElement> langs=driver.findElements(lang);//collecting all the movie language and stored in List
		for(int i=0;i<names.size();i++)
		{
			System.out.println(names.get(i).getText()+"\t"+langs.get(i).getText());//for printing all the movie names and the language
		}
		Thread.sleep(100);
		driver.quit();
	}

}
