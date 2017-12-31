package testscript;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class Keywords {
	static FirefoxDriver driver;
	static FileInputStream file;
	static Properties prop;
public void openbrowser() throws Exception{
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	file = new FileInputStream("C:\\Users\\Kabir Ahmed\\workspace\\CRMframework\\src\\Objectrepository\\Objectrepository.properties");
    prop = new Properties();
    prop.load(file);
}
public void navigate(String data) {
	driver.get(data);
}
public void input(String data, String objectName) {
	driver.findElement(By.xpath(prop.getProperty(objectName))).sendKeys(data);
}
public void click(String objectName) {
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	driver.findElement(By.xpath(prop.getProperty(objectName))).click();
}
public String verifyTitle() {
	String actualValue = driver.getTitle();
	return actualValue;
}
public String verifyPageText(String objectName) {
	String actualValue = driver.findElement(By.xpath(prop.getProperty(objectName))).getText();
    return actualValue;
}
}
