package org.zipkindemo.servicea.models.dtos.response;

import lombok.*;
import org.zipkindemo.servicea.models.dtos.DrivingLicenseDto;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
public class CreateDrivingLicenseResponseDto extends BaseResponseDto<DrivingLicenseDto> {
}
