package org.example.manager;

import org.example.dto.PetDTO;
import org.example.dto.Sex;
import org.example.dto.Type;
import org.example.dto.UserDto;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderCVS {


    @DataProvider
    public Iterator<Object[]> DataForPets() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/main/resources/Animals.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split("/");
                list.add(new Object[]{
                        PetDTO.builder()
                                .breed(split[2].trim())
                                .color(split[3].trim())
                                .contact(split[6].trim())
                                .Description(split[5].trim())
                                .Distinctive(split[4].trim())
                                .sex(Sex.valueOf(split[0]))
                                .types(Type.valueOf(split[1])).build()
                });
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> DataForUserLogin () {
        List<Object[]> list = new ArrayList<>();
        String path = "src/main/resources/User.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split("/");
                list.add(new Object[]{
                        UserDto.builder()
                                .name(split[0].trim())
                                .email(split[1].trim())
                                .psw(split[2].trim())
                                .phone(split[3].trim())
                                .facebook(split[4].trim())
                                .FlagForAssert(Boolean.parseBoolean(split[5])).build()
                });
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();

    }


}
