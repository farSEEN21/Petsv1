package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString@Setter@Getter@Builder
public class UserDto {
    String name;
    String email;
    String psw;
    String phone;
    String facebook;
boolean FlagForAssert;

}
