package org.zipkindemo.servicea.services;

import org.springframework.stereotype.Service;
import org.zipkindemo.servicea.models.dtos.DrivingLicenseDto;
import org.zipkindemo.servicea.models.dtos.request.CreateDrivingLicenseRequestDto;
import org.zipkindemo.servicea.models.dtos.response.CreateDrivingLicenseResponseDto;

import java.util.List;

@Service
public interface DrivingLicenseService {
    public CreateDrivingLicenseResponseDto create(CreateDrivingLicenseRequestDto createDrivingLicenseRequestDto);

    public List<DrivingLicenseDto> getByOwnerNid(String ownerNid);
}
