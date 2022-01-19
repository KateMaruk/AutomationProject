package parentTest;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected AddressEditorPage addressEditorPage;
    protected EditGroupPage editGroupPage;
    protected GroupPage groupPage;
    protected HomePage homePage;
    protected LoginPage loginPage;



    @Before
    public void setUp(){
        File file = new File("./src/drivers/chromedriver_97.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        String log4jConfPath = "./src/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

        addressEditorPage = new AddressEditorPage(webDriver);
        editGroupPage = new EditGroupPage(webDriver);
        groupPage = new GroupPage(webDriver);
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @After
    public void setDown(){
//        webDriver.quit();
    }

    public void checkExpectedResult(String message, boolean expectedResult, boolean actualResult ){

        Assert.assertEquals(message, expectedResult, actualResult);
    }

    public void checkExpectedResult(String message, boolean actualResult){
        checkExpectedResult(message, true, actualResult);

    }
    @Rule
    public TestWatcher watchman = new TestWatcher() {
        String fileName;
        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }
        @Attachment(value = "Page screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot) {
            return screenShot;
        }
        public void screenshot() {
            if (webDriver == null) {
                logger.info("Driver for screenshot not found");
                return;
            }
            saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
        }
        @Override
        protected void finished(Description description) {
            logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
            try {
                webDriver.quit();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    };

}
