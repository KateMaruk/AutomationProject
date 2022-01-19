package pages;

import io.qameta.allure.Step;
import libs.WorkWithElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WorkWithElements workWithElements;
    String baseUrl = "http://localhost/addressbook";
    String expectedUrl;

    public ParentPage(WebDriver webDriver, String relativeUrl) {
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
        workWithElements = new WorkWithElements(webDriver);
        this.expectedUrl = baseUrl + relativeUrl;
    }

    public String getCurrencyUrl(){

        return webDriver.getCurrentUrl();
    }

    @Step
    public void checkUrl(){
        try{
            Assert.assertEquals("Url is not expected", expectedUrl, getCurrencyUrl());
            logger.info("URLs are equal");

        }catch(Exception e){
            logger.warn("Can not check URLs");
            Assert.fail("Can not check URLs");
        }
    }
}

