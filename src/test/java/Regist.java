import org.example.dto.UserDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class Regist extends TestBase {
//app.baseHelper
//        .type(By.xpath("//input[@class='MuiInputBase-input MuiInput-input MuiInputBase-inputSizeSmall css-2duac4']"),"abaa");

    @Test
    public void RegPositiv() throws InterruptedException {
        UserDto userDto = UserDto.builder().name("Aleks").email("a87389788@gmail.com").psw("Qw3erty123").build();
        app.baseHelper.click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']"));
        app.baseHelper.click(By.xpath("//div[@data-test-id='sign-up-button']"));
        app.baseHelper.type(By.xpath("//input[@class='MuiInputBase-input MuiInput-input MuiInputBase-inputSizeSmall css-2duac4']"), userDto.getName());
        app.baseHelper.type(By.xpath("//input[@placeholder='peter@gmail.com']"), userDto.getEmail());
        app.baseHelper.type(By.xpath("//input[@type='password']"), userDto.getPsw());
        app.baseHelper.jump(userDto.getPsw());
        app.baseHelper.click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-14zlypc']"));
    }
}