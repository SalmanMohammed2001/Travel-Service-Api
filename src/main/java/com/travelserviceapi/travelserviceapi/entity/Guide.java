package com.travelserviceapi.travelserviceapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Guide {
    @Id
    private String guideId;
    private String guideName;
    private String guideAddress;
    private String guideContact;
    private String guideBirthDate;
    private double guideManDayValue;
    private String guideExperience;
    @Lob
    private byte[] guideIdFrontImage;
    @Lob
    private byte[] guideIdRearImage;
    @Lob
    private byte[] guideNicFrontImag;
    @Lob
    private byte[] guideNicRearImage;
    @Lob
    private byte[] guideProfilePicImage;

    private boolean guideStatus;

    @OneToOne(mappedBy = "guide")
    private Booking booking;
}
