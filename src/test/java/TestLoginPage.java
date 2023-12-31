import org.example.dto.UserDto;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLoginPage extends TestBase {


    @Test
    public void CheckTerms() {
        app.loginPageHelper.ClickSignUp();
        app.loginPageHelper.ClickTernSignUp();
        String ExpectText = "We, the team at PlaPets, adhere to high standards of protecting the privacy of our users' data. This privacy policy describes our practices regarding the collection, use, and disclosure of information about users of the website.".toUpperCase().trim();
        String ActualText = app.baseHelper.getTextBase(By.xpath("//div[@data-test-id='policy-form-container']"));
       Assert.assertTrue(ActualText.contains(ExpectText));
    }

    @Test
    public void CheckCancelButtonPosit() {
        app.loginPageHelper.ClickSignUp();
        app.loginPageHelper.ClickCancelBTNSignUp();

        Assert.assertEquals(app.baseHelper.isELementExt(By.xpath("//div[@data-test-id='join-text']")), true);
    }

    @Test
    public void CheckXButtonPosit() {
        app.loginPageHelper.ClickSignUp();
        app.loginPageHelper.CloseLoginPopUpBTN();
        Assert.assertEquals(app.baseHelper.isELementExt(By.xpath("//div[@data-test-id='join-text']")), true);
    }

    @Test
    public void CheckFogotPSWButtonPosit() {
        app.loginPageHelper.ClickSignUp();
        app.loginPageHelper.ForgetPSWBTN();
        Assert.assertTrue(app.baseHelper.isTextEqual(By.xpath("//div[@class='sc-iLLODe fuOvcu']"), "Password Recovery.".toUpperCase().trim()));
    }

    @Test
    public void CHeckRestorPSW() {
        app.loginPageHelper.ClickSignUp();
        app.loginPageHelper.ForgetPSWBTN();
        app.loginPageHelper.TypeEmailForRecoverPSW("Aleks@kdfj.ru");
        app.loginPageHelper.ChangeBTNRecoveryPSW();


    }

    @Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
    public void CHeckRestorPSWNeg(UserDto userDto) {
        app.loginPageHelper.ClickSignUp();
        app.loginPageHelper.ForgetPSWBTN();
        app.loginPageHelper.TypeEmailForRecoverPSW(userDto.getEmail());
        app.loginPageHelper.ChangeBTNRecoveryPSW();
        Assert.assertTrue(app.baseHelper.getTextBase1(By.xpath("//div[@data-test-id='message']")).equals("Oops, something went wrong. Please try again and make sure you've entered the correct e-mail.".trim().toUpperCase()));
        app.loginPageHelper.CloseLoginPopUpBTN();
    }


}
