import org.example.dto.UserDto;
import org.example.utils.Reader;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.example.helper.MainMenuHelp.LogOUTBTN;
import static org.example.helper.MainMenuHelp.UserBTN;

public class TestUser extends TestBase {

    boolean isLoginFLag = false;

    @BeforeTest
    public void LoginPositive() {
        if (isLoginFLag == false) {
            UserDto user = UserDto.builder().email(Reader.getProperty("email")).psw(Reader.getProperty("psw")).build();
            app.baseHelper.click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']"));
            app.baseHelper.type(By.xpath("//input[@type='email']"), user.getEmail());
            app.baseHelper.type(By.xpath("//input[@type='password']"), user.getPsw());
            app.baseHelper.click(By.xpath("//i[@class='sc-iGgWBj fBCXDH fa fa-paw']"));
            isLoginFLag = true;
        } else {
            isLoginFLag = false;
            app.baseHelper.click(LogOUTBTN);
        }
    }


    @Test
    public void ChangeAvatarJpeg() throws InterruptedException {
        app.baseHelper.click(UserBTN);
        app.userHelper.ChangePhotoAvatar();
        app.userHelper.SaveChanges();


    }
    @Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
    public void TryChangePSW(UserDto userDto)  {
        app.baseHelper.click(UserBTN);
        app.userHelper.ChangePSw(userDto.getPsw());
        app.userHelper.CancelNewPSW();


    }


}
