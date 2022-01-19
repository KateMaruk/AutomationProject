package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait wait7, wait10;

    public WorkWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait7 = new WebDriverWait(webDriver, 7);
        wait10 = new WebDriverWait(webDriver, 10);
    }

    public void enterTextIntoElement(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was entered into Login field");
        }catch(Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }

    }

    public  void clickOnElement(WebElement element){
        try{
            wait7.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

        }catch(Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }

    }
    public boolean isElementDisplayed(WebElement element){
        try{
            return element.isDisplayed();

        }catch (Exception w){
            return false;

        }
    }

    public  boolean isElementDisplayed(By by){
        try{
            return isElementDisplayed(webDriver.findElement(by));
        }catch (Exception e){
            return false;
        }
    }

    public void clickOkInAlert() {
        try {
            wait10.until(ExpectedConditions.alertIsPresent());
            webDriver.switchTo().alert().accept();

        }catch (NoAlertPresentException e) {
            logger.info("Can not work with Alert window!");
        }
    }
}
