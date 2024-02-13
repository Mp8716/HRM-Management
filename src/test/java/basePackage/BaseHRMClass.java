package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.TimeUtils;

public class BaseHRMClass {

	public static Properties prop = new Properties();

	public static WebDriver driver;

	public BaseHRMClass() {
		FileInputStream file;
		try {
			file = new FileInputStream(
					"D:\\Maya\\Java\\HRManagenent\\src\\test\\java\\environmentvariables\\Config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void initiation() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");    
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "deckodriver.exe");    
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public static void screenshots(String filename) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("D:\\Maya\\Java\\HRManagenent\\src\\test\\java\\screenshots\\" +filename+".jpg" ));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
