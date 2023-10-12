package org.zipkindemo.servicea.services;

import org.springframework.stereotype.Service;
import org.zipkindemo.servicea.models.dtos.VehicleLicenseDto;
import org.zipkindemo.servicea.models.dtos.request.CreateVehicleLicenseRequestDto;

import java.util.List;

@Service
public interface VehicleLicenseService {
    public VehicleLicenseDto create(CreateVehicleLicenseRequestDto createDrivingLicenseRequestDto);

    public List<VehicleLicenseDto> getByOwnerNid(String ownerNid);
}
