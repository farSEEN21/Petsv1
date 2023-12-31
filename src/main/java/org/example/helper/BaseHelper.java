package org.example.helper;

import org.example.ApplicationManager;
import org.example.utils.Reader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseHelper extends ApplicationManager {


    private String ClickOnFirstPublishBTN = "//i[@class='sc-Nxspf cOvSWq fa fa-paw']";

    public BaseHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void click(String text) {
        wd.findElement(By.xpath(text)).click();
    }

    public void ClickOnThePublishButton() {
        click(By.xpath(ClickOnFirstPublishBTN));
    }

    public void ClickAddNewBTN() {
        click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-cmc5zk']"));

    }

    public void type(By locator, String msg) {
        WebElement element = wd.findElement(locator);

        element.clear();
        element.sendKeys(msg);
    }


    public void jump(String msg) {


        new Actions(wd).sendKeys(Keys.TAB).sendKeys(msg).perform();

    }

    public void enter() {
        new Actions(wd).sendKeys(Keys.ENTER).perform();
    }

    public WebElement waituntill(By locator) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return wd.findElement(locator);

    }

    public void clickByJavaScript() {
        WebElement element = wd.findElement(By.cssSelector("i.sc-iGgWBj.fBCXDH.fa.fa-paw"));
        JavascriptExecutor executor = (JavascriptExecutor) wd;
        executor.executeScript("arguments[0].click();", element);
    }


    public boolean isELementExt(By locator) {

        List<WebElement> elements = wd.findElements(locator);
        if (elements.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getTextBase1(By locator) {
        WebElement el = wd.findElement(locator);
        return el.getText().trim().toUpperCase();
    }

    public String getTextBase(By locator) {
        WebElement el = waituntill(locator);
        return el.getText().trim().toUpperCase();
    }

    public boolean isTextEqual(By locator, String expectedResult) {
        String actualResult = getTextBase(locator);
        expectedResult = expectedResult.toUpperCase();

        if (expectedResult.equals(actualResult)) {
            return true;
        } else {
            System.out.println("expected result: " + expectedResult + "actual result: " + actualResult);
            return false;
        }
    }

    public boolean isTextContains(By locator, String expectedResult) {
        String actualResult = getTextBase(locator).toUpperCase();
        expectedResult = expectedResult.toUpperCase();

        if (expectedResult.contains(actualResult)) {
            return true;
        } else {
            System.out.println("expected result: " + expectedResult + " actual result: " + actualResult);
            return false;
        }
    }

    public void UploadFile() {
        WebElement uploadElement = wd.findElement(By.xpath("//input[@data-test-id='input-file']"));
        uploadElement.sendKeys(Reader.getProperty("PhotoOfThePet"));
        waituntill(By.xpath("//div[@data-test-id='files-area']/div"));
    }

    public WebElement WaitSomeThing(By locator, int time) {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(wd,
                Duration.ofMillis(time)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return wd.findElement(locator);
    }
}
