package org.zipkindemo.servicea.models.dtos.response;

import lombok.*;
import org.zipkindemo.servicea.models.dtos.DrivingLicenseDto;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class GetDrivingLicenseResponseListDto extends BaseResponseDto<List<DrivingLicenseDto>> {
}
