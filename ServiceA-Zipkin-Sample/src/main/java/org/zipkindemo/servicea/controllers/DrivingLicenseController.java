package org.zipkindemo.servicea.controllers;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zipkindemo.servicea.models.dtos.DrivingLicenseDto;
import org.zipkindemo.servicea.models.dtos.request.CreateDrivingLicenseRequestDto;
import org.zipkindemo.servicea.models.dtos.response.CreateDrivingLicenseResponseDto;
import org.zipkindemo.servicea.services.DrivingLicenseService;

import java.util.List;

@RestController
@RequestMapping("/drivinglicenses")
@Api(description = " ", tags = "DrivingLicense", value = " ")
public class DrivingLicenseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    @Qualifier("drivingLicenseServiceImpl")
    private DrivingLicenseService drivingLicenseService;

    @PostMapping
    public ResponseEntity<CreateDrivingLicenseResponseDto> create(@RequestBody CreateDrivingLicenseRequestDto createDrivingLicenseRequestDto) {
        logger.info("creating driving license");
        CreateDrivingLicenseResponseDto createDrivingLicenseResponseDto = drivingLicenseService.create(createDrivingLicenseRequestDto);
        logger.info("driving license created successfully");
        logger.info(createDrivingLicenseResponseDto.toString());
        return ResponseEntity.ok(createDrivingLicenseResponseDto);
    }

    @GetMapping("/{ownerNid}")
    public ResponseEntity<List<DrivingLicenseDto>> getByOwnerNid(@PathVariable String ownerNid) {
        logger.info("searching driving licenses by owner national id [" + ownerNid + "]");
        List<DrivingLicenseDto> drivingLicenseDtoList = drivingLicenseService.getByOwnerNid(ownerNid);
        logger.info("found driving licenses by owner national id [" + ownerNid + "]");
        logger.info(drivingLicenseDtoList.toString());
        return ResponseEntity.ok(drivingLicenseDtoList);
    }
}