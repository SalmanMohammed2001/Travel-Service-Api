package com.travelserviceapi.travelserviceapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;
    private String driverName;
    private String driverContact;
    private String driverNic;
    @Lob
    private byte[] licenseImageFront;
    @Lob
    private byte[] licenseImageRear;
    private boolean driverStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id",unique = true)
    private Vehicle vehicle;
}
