package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class PetDTO {

  Sex sex ;
  Type types ;
    String breed;
    String color;
    String Distinctive;
    String Description;
    String contact;
}
