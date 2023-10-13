package org.zipkindemo.servicea.models.dtos.request;

import lombok.*;
import org.zipkindemo.servicea.models.dtos.ColorEnum;
import org.zipkindemo.servicea.models.dtos.ModelDto;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateVehicleLicenseRequestDto implements Serializable {
    private String motorNumber;
    private String chassisNumber;
    private ModelDto model;
    private Short vehicleModelYear;
    private ColorEnum vehicleColor;
    private Short licensePeriodMonths;
    private String ownerNid;
}
