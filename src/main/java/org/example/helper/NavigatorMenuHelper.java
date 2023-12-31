package org.example.helper;

import org.openqa.selenium.WebDriver;

public class NavigatorMenuHelper extends BaseHelper implements MainMenuHelp {
    public NavigatorMenuHelper(WebDriver wd) {
        super(wd);
    }


    public void clickLostButton() {
        click(LostBTN);


    }

    public void clickHomeButton() {
        click(HomeBTN);


    }

    public void clickFoundButton() {
        click(FoundBTN);

    }

    public void clickServiceButton() {
        click(ServiceBTN);


    }

    public void clickHomeFavorit() {
        click(FavoriteBTN);


    }


    public void clickUserButton() {
        click(UserBTN);


    }

    public void clickLogout() {
        click(LogOUTBTN);

    }

    public void clickHotelButton() {
        click(ServiceBTN);
        click(WalkingBTN);


    }

    public void clickFosteringButton() {
        click(ServiceBTN);
        click(Fostering);


    }

    public void clickVetButton() {
        click(ServiceBTN);
        click(VetHelp);


    }


}
