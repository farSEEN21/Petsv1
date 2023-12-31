import org.example.dto.UserDto;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {


    @Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
    public void LoginPositive(UserDto user) {
//        UserDto user = UserDto.builder().email(Reader.getProperty("email")).psw(Reader.getProperty("psw")).build();
        app.loginPageHelper.ClickSignUp();
        app.baseHelper.type(By.xpath("//input[@type='email']"), user.getEmail());
        app.baseHelper.type(By.xpath("//input[@type='password']"), user.getPsw());
        app.loginPageHelper.ClickSubitBTN();
        String st = app.baseHelper.getTextBase(By.xpath("//*[@class='sc-cwHptR gGANnI']"));
        Assert.assertEquals(st, "Logout".toUpperCase());


    }

    @Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
    public void LoginNEGATIVTEST(UserDto user) {
//        UserDto user = UserDto.builder().email("derder@mail.ru").psw("Softsys21").build();
        app.loginPageHelper.ClickSignUp();
        app.baseHelper.type(By.xpath("//input[@type='email']"), user.getEmail());
        app.baseHelper.type(By.xpath("//input[@type='password']"), user.getPsw());
        app.loginPageHelper.ClickSubitBTN();
        if (user.isFlagForAssert() == true) {
            String st = app.baseHelper.getTextBase(By.xpath("//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-filled Mui-required css-5zc6pg']"));
            Assert.assertEquals(st, "Invalid email or password".toUpperCase());
        } else {
            String st = app.baseHelper.getTextBase(By.xpath("//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-filled Mui-required css-5zc6pg']"));
            Assert.assertEquals(st, "Email not valid".toUpperCase());

        }
    }
//    @Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
//    public void LoginWrongFormatEmail() {
//        UserDto user = UserDto.builder().email("adzccz@mail").psw("Softsys21").build();
//        app.baseHelper.click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']"));
//        app.baseHelper.type(By.xpath("//input[@type='email']"), user.getEmail());
//        app.baseHelper.type(By.xpath("//input[@type='password']"), user.getPsw());
//        app.baseHelper.click(By.xpath("//i[@class='sc-iGgWBj fBCXDH fa fa-paw']"));
//
//        String st = app.baseHelper.getTextBase(By.xpath("//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-filled Mui-required css-5zc6pg']"));
//        Assert.assertEquals(st, "Email not valid".toUpperCase());
//
//    }
//     @Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
//    public void LoginWrongFormatNoNameEmail() {
//        UserDto user = UserDto.builder().email(" @mail").psw("Softsys21").build();
//        app.baseHelper.click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']"));
//        app.baseHelper.type(By.xpath("//input[@type='email']"), user.getEmail());
//        app.baseHelper.type(By.xpath("//input[@type='password']"), user.getPsw());
//        app.baseHelper.click(By.xpath("//i[@class='sc-iGgWBj fBCXDH fa fa-paw']"));
//
//        String st = app.baseHelper.getTextBase(By.xpath("//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-filled Mui-required css-5zc6pg']"));
//        Assert.assertEquals(st, "Email not valid".toUpperCase());
//
//    }
//@Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
//    public void LoginWrongFormatNoEmail() {
//        UserDto user = UserDto.builder().email("adzccz@mail").psw("Softsys21").build();
//        app.baseHelper.click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']"));
//        app.baseHelper.type(By.xpath("//input[@type='email']"), user.getEmail());
//        app.baseHelper.type(By.xpath("//input[@type='password']"), user.getPsw());
//        app.baseHelper.click(By.xpath("//i[@class='sc-iGgWBj fBCXDH fa fa-paw']"));
//
//        String st = app.baseHelper.getTextBase(By.xpath("//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-filled Mui-required css-5zc6pg']"));
//        Assert.assertEquals(st, "Email not valid".toUpperCase());
//
//    }
//@Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
//    public void LoginWrongFormatDomenEmail() {
//        UserDto user = UserDto.builder().email("adzccz@").psw("Softsys21").build();
//        app.baseHelper.click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']"));
//        app.baseHelper.type(By.xpath("//input[@type='email']"), user.getEmail());
//        app.baseHelper.type(By.xpath("//input[@type='password']"), user.getPsw());
//        app.baseHelper.click(By.xpath("//i[@class='sc-iGgWBj fBCXDH fa fa-paw']"));
//
//        String st = app.baseHelper.getTextBase(By.xpath("//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-filled Mui-required css-5zc6pg']"));
//        Assert.assertEquals(st, "Email not valid".toUpperCase());
//
//    }
//    @Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
//    public void LoginWrongFormatNotExDomenEmail() {
//        UserDto user = UserDto.builder().email("adzccz@drdr.x").psw("Softsys21").build();
//        app.baseHelper.click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']"));
//        app.baseHelper.type(By.xpath("//input[@type='email']"), user.getEmail());
//        app.baseHelper.type(By.xpath("//input[@type='password']"), user.getPsw());
//        app.baseHelper.click(By.xpath("//i[@class='sc-iGgWBj fBCXDH fa fa-paw']"));
//
//        String st = app.baseHelper.getTextBase(By.xpath("//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-filled Mui-required css-5zc6pg']"));
//        Assert.assertEquals(st, "Email not valid".toUpperCase());
//
//    }
//  @Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
//    public void LoginWithoutEmailNegativ() {
//        UserDto user = UserDto.builder().email("").psw("Softsys21").build();
//        app.baseHelper.click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']"));
//        app.baseHelper.type(By.xpath("//input[@type='email']"), user.getEmail());
//        app.baseHelper.type(By.xpath("//input[@type='password']"), user.getPsw());
//       // app.baseHelper.click(By.xpath("//i[@class='sc-iGgWBj fBCXDH fa fa-paw']"));
//Boolean st=baseHelper.isELementExt(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium Mui-disabled MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1003fvm']"));
//
////NOT EAT
//
////System.out.println(st);
////Assert.assertTrue());
//    }
//
//    @Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
//    public void LoginWrongFormatNumberButEmail() {
//        UserDto user = UserDto.builder().email("1").psw("Softsys21").build();
//        app.baseHelper.click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']"));
//        app.baseHelper.type(By.xpath("//input[@type='email']"), user.getEmail());
//        app.baseHelper.type(By.xpath("//input[@type='password']"), user.getPsw());
//        app.baseHelper.click(By.xpath("//i[@class='sc-iGgWBj fBCXDH fa fa-paw']"));
//
//        String st = app.baseHelper.getTextBase(By.xpath("//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-filled Mui-required css-5zc6pg']"));
//        Assert.assertEquals(st, "Email not valid".toUpperCase());
//
//    }
//
//
//
//
//     @Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
//    public void LoginWrongpsw() {
//        UserDto user = UserDto.builder().email("adzccz@mail.ru").psw("Softsys21123").build();
//        app.baseHelper.click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']"));
//        app.baseHelper.type(By.xpath("//input[@type='email']"), user.getEmail());
//        app.baseHelper.type(By.xpath("//input[@type='password']"), user.getPsw());
//        app.baseHelper.click(By.xpath("//i[@class='sc-iGgWBj fBCXDH fa fa-paw']"));
//
//        String st = app.baseHelper.getTextBase(By.xpath("//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-filled Mui-required css-5zc6pg']"));
//        Assert.assertEquals(st, "Invalid email or password".toUpperCase());
//
//    }
//   @Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
//    public void LoginWithoutpsw() {
//        UserDto user = UserDto.builder().email("adzccz@mail.ru").psw(" ").build();
//        app.baseHelper.click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']"));
//        app.baseHelper.type(By.xpath("//input[@type='email']"), user.getEmail());
//        app.baseHelper.type(By.xpath("//input[@type='password']"), user.getPsw());
//        app.baseHelper.click(By.xpath("//i[@class='sc-iGgWBj fBCXDH fa fa-paw']"));
//
//        String st = app.baseHelper.getTextBase(By.xpath("//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-filled Mui-required css-5zc6pg']"));
//        Assert.assertEquals(st, "Invalid email or password".toUpperCase());
//
//    }
// @Test(dataProvider = "DataForUserLogin", dataProviderClass = DataProvider.class)
//    public void LoginTestBlankPsw() {
//        UserDto user = UserDto.builder().email("adzccz@mail.ru").psw("").build();
//        app.baseHelper.click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']"));
//        app.baseHelper.type(By.xpath("//input[@type='email']"), user.getEmail());
//        app.baseHelper.type(By.xpath("//input[@type='password']"), user.getPsw());
//    app.baseHelper.clickByJavaScript();
//       // app.baseHelper.click(By.xpath("//i[@class='sc-iGgWBj fBCXDH fa fa-paw']"));
//
//        String st = app.baseHelper.getTextBase(By.xpath("//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-filled Mui-required css-5zc6pg']"));
//        Assert.assertEquals(st, "Invalid email or password".toUpperCase());
//
//    }


}