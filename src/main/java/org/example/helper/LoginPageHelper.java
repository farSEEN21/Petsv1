package org.example.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageHelper extends BaseHelper {
    private String SignUpBTN = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']";
    private String CancelBTNSignUpPop = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-t8qu0f']";
    private String BTNTerms = "//span[@data-test-id='terms-link']";
    private String CloseLoginPopUpBTN = "//i[@class='sc-fUkmAC lcUGyE fa fa-times']";
    private String ForgetPSWBTN = "//div[@class='sc-bkEOxz cogxRN']";
    private String InputEmail = "//div[@class='MuiInputBase-root MuiInput-root MuiInput-underline MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-sizeSmall css-3sjgc0']/input";
    private String ChangeBTNRecoveryPSW = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-cmc5zk']";
    private String SubmitBTN = "//i[@class='sc-iGgWBj fBCXDH fa fa-paw']";

    public LoginPageHelper(WebDriver wd) {
        super(wd);
    }

    public void ClickSignUp() {
        click(By.xpath(SignUpBTN));
    }  public void ClickSubitBTN() {
        click(By.xpath(SubmitBTN));
    }

    public void ClickCancelBTNSignUp() {
        click(By.xpath(CancelBTNSignUpPop));
    }

    public void ClickTernSignUp() {
        click(By.xpath(BTNTerms));
    }

    public void CloseLoginPopUpBTN() {
        click(By.xpath(CloseLoginPopUpBTN));
    }

    public void ForgetPSWBTN() {
        click(By.xpath(ForgetPSWBTN));
    }

    public void ChangeBTNRecoveryPSW() {
        click(By.xpath(ChangeBTNRecoveryPSW));
    }

    public void TypeEmailForRecoverPSW(String email) {
        type(By.xpath(InputEmail), email);
    }


}


