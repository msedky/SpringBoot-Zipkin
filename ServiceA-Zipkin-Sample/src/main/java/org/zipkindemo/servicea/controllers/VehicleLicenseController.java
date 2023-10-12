package org.zipkindemo.servicea.controllers;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zipkindemo.servicea.models.dtos.VehicleLicenseDto;
import org.zipkindemo.servicea.models.dtos.request.CreateVehicleLicenseRequestDto;
import org.zipkindemo.servicea.models.dtos.response.BaseResponseDto;
import org.zipkindemo.servicea.services.VehicleLicenseService;

import java.util.List;

@RestController
@RequestMapping("/vehiclelicenses")
@Api(description = " ", tags = "VehicleLicense", value = " ")
public class VehicleLicenseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    @Qualifier("drivingLicenseServiceImpl")
    private VehicleLicenseService drivingLicenseService;

    @PostMapping
    public ResponseEntity<BaseResponseDto> create(@RequestBody CreateVehicleLicenseRequestDto createDrivingLicenseRequestDto) {
        logger.info("creating vehicle license");
        VehicleLicenseDto createdDrivingLicenseDto = drivingLicenseService.create(createDrivingLicenseRequestDto);
        logger.info("vehicle license created successfully");
        logger.info(createdDrivingLicenseDto.toString());
        return ResponseEntity.ok(BaseResponseDto.success(createdDrivingLicenseDto));
    }

    @GetMapping("/{ownerNid}")
    public ResponseEntity<BaseResponseDto> getByOwnerNid(@PathVariable String ownerNid) {
        logger.info("searching vehicle licenses by owner national id [" + ownerNid + "]");
        List<VehicleLicenseDto> drivingLicenseDtoList = drivingLicenseService.getByOwnerNid(ownerNid);
        logger.info("found vehicle licenses by owner national id [" + ownerNid + "]");
        logger.info(drivingLicenseDtoList.toString());
        return ResponseEntity.ok(BaseResponseDto.success(drivingLicenseDtoList));
    }
}