package org.zipkindemo.servicea.models.dtos.request;

import lombok.*;
import org.zipkindemo.servicea.models.dtos.CitizenDto;
import org.zipkindemo.servicea.models.dtos.ModelDto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateDrivingLicenseRequestDto implements Serializable {
    private String motorNumber;
    private String chassisNumber;
    private ModelDto model;
    private Short vehicleModelYear;
    private Short licensePeriodMonths;
    private String ownerNid;
}
