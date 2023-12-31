package org.example.helper;

import org.example.dto.UserDto;
import org.example.utils.Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;

public class UserHelper extends BaseHelper {
  private  String MyProfil = "//div[@data-test-id='profile-activities']";
    private String MyActivites = "//div[@data-test-id='activities']";
    private String MyEmailInput = "//div[@class='MuiFormControl-root MuiFormControl-fullWidth MuiTextField-root css-feqhe6']/div/input";
    private String PenNameAndAvatar = "//div[@data-test-id='avatar-and-name']";

    private String PhotoAvatar = "//*[@id='image']";
    private String MyPhone = "//div[@data-test-id='phone-input-area']/div/div/div/input";
    private String FaceBook = "//lable[@data-test-id='phone-input-area']/div/div/input";
    private String SaveBTN = "//div[@class='sc-gvZAcH FkRWo']/button[2]";
    private String CancelBTN = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-y5miln']";
    private String Name = "//div[@class='MuiFormControl-root MuiFormControl-fullWidth MuiTextField-root css-1xmp5dj']/div/input";
    private String ChangePSW = "//div[@class='sc-iapWAC eTHWqG']/p";
    private String OldPSW = "//div[@class='MuiFormControl-root MuiFormControl-fullWidth MuiTextField-root css-feqhe6']/div/input";
    private String newPSW = "//div[@class='sc-knuQbY hjzOIV']/div[2]/div/div/input";
    private String SecondPSW = "//div[@class='sc-knuQbY hjzOIV']/div[3]/div/div/input";
    private String PSWSaveBTN = "//div[@class='sc-gvZAcH FkRWo']/button[2]";
    private String PSWCancelBTN = "//div[@class='sc-gvZAcH FkRWo']/button[1]";

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void SaveChanges() {
        click(SaveBTN);
    }

    public void CancelChanges() {
        click(CancelBTN);
    }

    public void inputFaceBook(String link) {
        type(By.xpath(FaceBook), link);
        SaveChanges();
    }

    public void InputMyPhone(String number) {
        type(By.xpath(MyPhone), number);
        SaveChanges();
    }

    public void ChangeName(String name) {
        click(PenNameAndAvatar);
        type(By.xpath(Name), name);
        click(PenNameAndAvatar);
        SaveChanges();

    }

    public void InputEmail(String email) {
        type(By.xpath(MyEmailInput), email);
        SaveChanges();
    }

    public void CheckActivities() {
        click(MyActivites);
    }

    public void CheckMyProfil() {
        click(MyProfil);
    }

    public void ChangePSw( String NewPSW) {
        click(ChangePSW);
        type(By.xpath(OldPSW), Reader.getProperty("psw"));
        type(By.xpath(newPSW), NewPSW);
        type(By.xpath(SecondPSW), NewPSW);

    }

    public void SaveNewPSW() {
        click(By.xpath(PSWSaveBTN));
    }
    public void CancelNewPSW() {
        click(By.xpath(PSWCancelBTN));
    }
//TODO make one method of upload
    public void ChangePhotoAvatar() throws InterruptedException {
        WebElement uploadElement = wd.findElement(By.xpath(PhotoAvatar));
        uploadElement.sendKeys(Reader.getProperty("Avatar"));
        Thread.sleep(2000);
      //  waituntill(By.xpath("//div[@data-test-id='files-area']/div"));
        SaveChanges();

    }


}