package org.example;

import org.example.helper.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.example.utils.Reader.getProperty;

public class ApplicationManager {


    public WebDriver wd;
    public BaseHelper baseHelper;
    public Found_PetHelper foundPetHelper;
    public NavigatorMenuHelper navigatorMenuHelper;
    public LostPetHelper lostPetHelper;
    public UserHelper userHelper;
    public LoginPageHelper loginPageHelper;
    String url;

    public void init() {
        url = getProperty("URL");
        wd = new ChromeDriver();
        wd.get(url);
        wd.manage().window();
        wd.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        foundPetHelper = new Found_PetHelper(wd);
        baseHelper = new BaseHelper(wd);
        navigatorMenuHelper = new NavigatorMenuHelper(wd);
        userHelper=new UserHelper(wd);
        lostPetHelper = new LostPetHelper(wd);
        loginPageHelper=new LoginPageHelper(wd);
    }


    public void teardown() {
//        wd.quit();

    }
}
