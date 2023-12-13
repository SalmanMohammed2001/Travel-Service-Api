package com.travelserviceapi.travelserviceapi.dto.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserImageDto {

    private String id;
    private String name;
    private String address;
    private byte[] imag;
    private byte[] image2;
    private byte[] image3;

    //  private ArrayList<byte[]> images;


}
