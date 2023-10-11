package org.zipkindemo.servicea.services.impls;

import org.springframework.stereotype.Component;
import org.zipkindemo.servicea.models.dtos.DrivingLicenseDto;
import org.zipkindemo.servicea.models.dtos.request.CreateDrivingLicenseRequestDto;
import org.zipkindemo.servicea.models.dtos.response.CreateDrivingLicenseResponseDto;
import org.zipkindemo.servicea.services.DrivingLicenseService;

import java.util.List;

@Component("drivingLicenseServiceImpl")
public class DrivingLicenseServiceImpl implements DrivingLicenseService {
    @Override
    public CreateDrivingLicenseResponseDto create(CreateDrivingLicenseRequestDto createDrivingLicenseRequestDto) {
        return null;
    }

    @Override
    public List<DrivingLicenseDto> getByOwnerNid(String ownerNid) {
        return null;
    }
}
