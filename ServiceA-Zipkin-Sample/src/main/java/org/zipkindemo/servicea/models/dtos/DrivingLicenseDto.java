package org.zipkindemo.servicea.models.dtos;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class DrivingLicenseDto implements Serializable {

    private String vehicleId;
    private String motorNumber;
    private String chassisNumber;
    private ModelDto model;
    private Short vehicleModelYear;
    private LocalDateTime extractDateTime;
    private LocalDate expiryDate;
    private CitizenDto owner;
}