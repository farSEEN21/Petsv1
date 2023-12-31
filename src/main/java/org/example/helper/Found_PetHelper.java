package org.example.helper;

import org.example.dto.PetDTO;
import org.example.dto.Sex;
import org.example.dto.Type;
import org.example.utils.Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class Found_PetHelper extends BaseHelper {

    private String InputTypeFound = "//div[@data-test-id='filter-container']/div[1]/div/input";
    private String InputBreedFound = "//div[@data-test-id='filter-container']/div[2]/div/input";
    private String InputFeaturesFound = "//div[@data-test-id='filter-container']/div[3]/div/input";
    private String InputLocationFound = "//div[@data-test-id='filter-container']/div[4]/div/input";
    private String ListOfFoundPets = "//div[@class='infinite-scroll-component ']/div";
    private String NameOfFoundPets = "//div[@class='infinite-scroll-component ']/div/div/div";
    public Found_PetHelper(WebDriver wd) {
        super(wd);

    }

    public List ListOfFoundPets() {
        List<String> listPets = new ArrayList<>();
        List<WebElement> element = wd.findElements(By.xpath(ListOfFoundPets));
        for (WebElement pet : element) {
            listPets.add(String.valueOf(pet.getText()));
        }
        return listPets;
    }


    public void InputTypeOfFoundThePet(Type type) {
        type(By.xpath(InputTypeFound), type.toString());
        enter();
    }

    public void InputBreedOfFoundThePet(String Breed) {
        type(By.xpath(InputBreedFound), Breed);
        enter();
    }

    public void InputFeaturesOfFoundThePet(String feature) {
        type(By.xpath(InputFeaturesFound), feature);
        enter();
    }

    public void InputLocationOfFoundThePet(String location) {
        type(By.xpath(InputLocationFound), location);
        enter();
    }


    public void ChooseFoundForm() {
        click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-cmc5zk']"));

    }

    public void FillFormFoundPed(PetDTO petDTO) {
        //   Assert.assertTrue(app.baseHelper.isTextEqual(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/span/b"), "Found a pet?".toUpperCase().trim()));
        type(By.xpath("//input[@placeholder='Golden Retriever']"), petDTO.getBreed());
        type(By.xpath("//input[@placeholder='Beige']"), petDTO.getColor());
        type(By.xpath("//textarea[@placeholder='Blue collar with stars, no left ear, damaged tail.']"), petDTO.getDistinctive());
        click(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-2a2u2s']"));
        type(By.xpath("//input[@name='Phone']"), petDTO.getContact());
        type(By.xpath("//div[@class='sc-hknOHE jhyHVf']/div/div/input"), petDTO.getDistinctive());
        click(By.xpath("//div[@class='sc-hknOHE jhyHVf']/button[@type='button']"));
        Choosesex(By.xpath("//div[@data-test-id='info-select-1']"), petDTO.getSex());
        ChooseType(By.xpath("//div[@class='MuiSelect-select MuiSelect-filled MuiInputBase-input MuiFilledInput-input MuiInputBase-inputSizeSmall css-1gf7mfj']"), petDTO.getTypes());
        UploadFile();
    }


    public void ChooseType(By locator, Type type1) {
        wd.findElement(locator).click();
        switch (type1) {
            case Dog: {
                click(By.xpath(Reader.getProperty(type1)));
                break;
            }
            case Cat: {
                click(By.xpath(Reader.getProperty(type1)));
                break;
            }
            case Bird: {
                click(By.xpath(Reader.getProperty(type1)));
                break;
            }
            case Rodent: {
                click(By.xpath(Reader.getProperty(type1)));
                break;
            }
            case Reptile: {
                click(By.xpath(Reader.getProperty(type1)));
                break;
            }
            case Rabbit: {
                click(By.xpath(Reader.getProperty(type1)));
                break;
            }
            case Ferret: {
                click(By.xpath(Reader.getProperty(type1)));
                break;
            }
            case Turtle: {
                click(By.xpath(Reader.getProperty(type1)));
                break;
            }
            case Exotic_animal: {
                click(By.xpath(Reader.getProperty(type1)));
                break;
            }

            default:
                throw new IllegalStateException("Unexpected value: " + type1);
        }

    }

    public void Choosesex(By locator, Sex type1) {
        wd.findElement(locator).click();
        switch (type1) {
            case Male:
                click(By.xpath(Reader.getProperty(type1)));
            case Female:
                click(By.xpath(Reader.getProperty(type1)));
            case Other:
                click(By.xpath(Reader.getProperty(type1)));


        }


    }


}
