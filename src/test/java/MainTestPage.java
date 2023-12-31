import org.example.dto.PetDTO;
import org.example.dto.UserDto;
import org.example.helper.MainMenuHelp;
import org.example.manager.DataProviderCVS;
import org.example.utils.Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.example.dto.Sex.Male;
import static org.example.dto.Sex.Other;
import static org.example.dto.Type.Dog;

public class MainTestPage extends TestBase implements MainMenuHelp {

    boolean isLoginFLag = false;
    PetDTO Animal = PetDTO.builder().sex(Male).types(Dog).breed("Pater").color("green").Distinctive("Longtail, greencolor").Description("young").contact("61231234").build();

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
    (dataProvider = "DataForPets", dataProviderClass = DataProviderCVS.class)
    public void CreatFindFormPositive(PetDTO an) {
        //  PetDTO findAnimal = PetDTO.builder().sex(Other).types(Rodent).breed("addd34ed").color("yellow").Distinctive("dsfsdsd").contact("2342343423").build();
        app.baseHelper.ClickAddNewBTN();
        app.foundPetHelper.ChooseFoundForm();
        app.foundPetHelper.FillFormFoundPed(an);
        app.baseHelper.ClickOnThePublishButton();
        Assert.assertTrue(app.baseHelper.isTextContains(By.xpath("//div[@class='sc-kbhJrz iTXeRN']"), Animal.getTypes().toString() + ", " + Animal.getBreed()));
        app.baseHelper.click(By.xpath(Reader.getProperty("LastPublishBTN")));  // For Publish you post

    }


    @Test
    public void CreatLostFormPositive() {
        //  PetDTO lostAnimal = PetDTO.builder().sex(Male).types(Dog).breed("pater").color("green").Distinctive("Long tail, green color").Description("young").contact("61231234").build();
        app.baseHelper.ClickAddNewBTN();
        app.lostPetHelper.ChooseLostForm();
        app.lostPetHelper.FillLostForm(Animal);
        app.baseHelper.ClickOnThePublishButton();
        Assert.assertTrue(app.baseHelper.isTextContains(By.xpath("//div[@class='sc-kbhJrz iTXeRN']"), Animal.getTypes().toString() + ", " + Animal.getBreed()));
//        app.baseHelper.click(By.xpath(Reader.getProperty("LastPublishBTN")));   For Publish you post

    }  @Test
    public void CreatLostFormNegativeLongContact() {
         PetDTO lostAnimal = PetDTO.builder().sex(Other).types(Dog).breed("pater").color("green").Distinctive("Long tail, green color").Description("young").contact("61231234").build();
        app.baseHelper.ClickAddNewBTN();
        app.lostPetHelper.ChooseLostForm();
        app.lostPetHelper.FillLostForm(Animal);
       // app.baseHelper.ClickOnThePublishButton();
        String msg=app.baseHelper.getTextBase1(By.xpath("//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall MuiFormHelperText-filled Mui-required css-5zc6pg']") );
        Assert.assertEquals(msg, "Phone must be 10 digits".trim().toUpperCase());
//        app.baseHelper.click(By.xpath(Reader.getProperty("LastPublishBTN")));   For Publish you post

    }

    @Test
    public void clickLostButtonTestPosit() {

        app.baseHelper.click(LostBTN);
        WebElement element = app.wd.findElement(By.xpath(LostBTN));
        Assert.assertEquals(element.getText(), "Lost");

    }

    @Test
    public void clickHomeButtonTestPosit() {

        app.baseHelper.click(HomeBTN);
        WebElement element = app.wd.findElement(By.xpath(HomeBTN));
        Assert.assertEquals(element.getText(), "Home");

    }

    @Test
    public void clickFoundButtonTestPosit() {

        app.baseHelper.click(HomeBTN);
        WebElement element = app.wd.findElement(By.xpath(HomeBTN));
        Assert.assertEquals(element.getText(), "Found");

    }

    @Test
    public void clickServiceButtonTestPosit() {

        app.baseHelper.click(ServiceBTN);
        WebElement element = app.wd.findElement(By.xpath(ServiceBTN));
        Assert.assertEquals(element.getText(), "Services");

    }

    @Test
    public void clickHomeFavoritTestPosit() {

        app.baseHelper.click(FavoriteBTN);
        WebElement element = app.wd.findElement(By.xpath(FavoriteBTN));
        Assert.assertEquals(element.getText(), "Favorites");

    }

    @Test
    public void clickUserButtonTestPosit() {

        app.baseHelper.click(UserBTN);

        WebElement element = app.wd.findElement(By.xpath(UserBTN));
        Assert.assertEquals(element.getText(), "aleks");

    }

    @Test
    public void clickLogoutButtonTestPosit() {

        app.baseHelper.click(LogOUTBTN);
        WebElement element = app.wd.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1fnffw']"));
        Assert.assertEquals(element.getText(), "Sign in");

    }

    @Test
    public void clickHotelButtonTestPosit() {
        app.baseHelper.click(ServiceBTN);

        app.baseHelper.click(WalkingBTN);
        WebElement element = app.wd.findElement(By.xpath(WalkingBTN));
        Assert.assertEquals(element.getText(), "Hotels");

    }

    @Test
    public void clickFosteringButtonTestPosit() {
        app.baseHelper.click(ServiceBTN);

        app.baseHelper.click(Fostering);
        WebElement element = app.wd.findElement(By.xpath(Fostering));
        Assert.assertEquals(element.getText(), "Fostering");

    }

    @Test
    public void clickVetButtonTestPosit() {
        app.baseHelper.click(ServiceBTN);
        app.baseHelper.click(VetHelp);
        WebElement element = app.wd.findElement(By.xpath(VetHelp));
        Assert.assertEquals(element.getText(), "VetHelp");

    }

    @Test
    public void InputTypeOfLostPetPositiveTest() {
        app.baseHelper.click(LostBTN);
        app.lostPetHelper.InputTypeOfThePet(Dog);
        List pets = app.lostPetHelper.ListOfLostPets();
        Assert.assertTrue(pets.toString().contains(Dog.name().toString()));

    }

    @Test
    public void InputTypeOfFoundPetPositiveTest() {
        app.baseHelper.click(FoundBTN);
        app.foundPetHelper.InputTypeOfFoundThePet(Dog);
        List pets = app.foundPetHelper.ListOfFoundPets();
        Assert.assertTrue(pets.toString().contains(Dog.name().toString()));

    }

    @Test //
    public void InputAllFieldsInFoundPetsPositiveTest() {
        app.baseHelper.click(FoundBTN);
        String result = Dog.name() + ", "
                + Animal.getBreed()
                + "\nColor: " + Animal.getColor()
                + "\nSex: " + Animal.getSex().name()
                + "\nHeight: Up to 20cm\nDistinctive features: "
                + Animal.getDistinctive();
        app.foundPetHelper.InputTypeOfFoundThePet(Dog);
        app.foundPetHelper.InputBreedOfFoundThePet(Animal.getBreed());
        app.foundPetHelper.InputFeaturesOfFoundThePet(Animal.getDistinctive());
        app.foundPetHelper.InputLocationOfFoundThePet("Tel Avia");
        List pets = app.foundPetHelper.ListOfFoundPets();


        Assert.assertTrue(pets.toString().contains(result.toString()));

    }

    @Test //
    public void InputAllfieldsInLostPetsPositiveTest() {
        app.baseHelper.click(LostBTN);
        String result = Dog.name() + ", "
                + Animal.getBreed()
                + "\nColor: " + Animal.getColor()
                + "\nSex: " + Animal.getSex().name()
                + "\nHeight: Up to 20cm\nDistinctive features: "
                + Animal.getDistinctive();
        app.lostPetHelper.InputTypeOfThePet(Dog);
        app.lostPetHelper.InputBreedOfThePet(Animal.getBreed());
        app.lostPetHelper.InputFeaturesOfThePet(Animal.getDistinctive());
        app.lostPetHelper.InputLocationOfThePet("Tel Avia");
        List pets = app.lostPetHelper.ListOfLostPets();
        System.out.println(result + "\n+_+" + pets.toString());

        Assert.assertTrue(pets.toString().contains(result.toString()));

    }


    @AfterTest
    public void PublishPost() {

    }

}
