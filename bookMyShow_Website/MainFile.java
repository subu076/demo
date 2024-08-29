package bookMyShow_Website;
//------------------------------------- performing all the automation in single main class --------------------------------------//
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;

public class MainFile {

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
		By signin=By.xpath("//div[text()=\"Sign in\"]");//xpath for clicking the signin button
		By google=By.xpath("//div[text()=\"Continue with Google\"]");//xpath for signin to the google account
		driver.findElement(signin).click();
		Thread.sleep(1000);
		driver.findElement(google).click();
		Set<String> demo=driver.getWindowHandles();//for capture of multiple window id
		String [] arr=demo.toArray(new String[0]);
		/*storing the above value in array because set values are not in order so in order to store window id in order we convert it from set to array*/
		String bookmyshowsignin=arr[0];//parent window
		String googlesignin=arr[1];//child window
		Thread.sleep(1000);
		driver.switchTo().window(googlesignin);//switching to child window
		driver.findElement(By.id("identifierId")).sendKeys("unknownsuba@gmail.com");//entering the email id 
		driver.findElement(By.xpath("//span[text()=\"Next\"]")).click();//clicking the next button
		Thread.sleep(1000);
		WebElement error_msg=driver.findElement(By.xpath("//div[@class=\"Ekjuhf Jj6Lae\"]"));//capturing the error msg if the email id is invalid
		System.out.println(error_msg.getText());//printing the error message
		driver.quit();

	}

}
