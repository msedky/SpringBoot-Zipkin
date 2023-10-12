package org.zipkindemo.servicea.services.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zipkindemo.servicea.feign.CitizenClient;
import org.zipkindemo.servicea.models.dtos.CitizenDto;
import org.zipkindemo.servicea.models.dtos.ModelDto;
import org.zipkindemo.servicea.models.dtos.VehicleLicenseDto;
import org.zipkindemo.servicea.models.dtos.request.CreateVehicleLicenseRequestDto;
import org.zipkindemo.servicea.models.dtos.response.BaseResponseDto;
import org.zipkindemo.servicea.models.entities.VehicleLicenseEntity;
import org.zipkindemo.servicea.repos.VehicleLicenseRepository;
import org.zipkindemo.servicea.services.VehicleLicenseService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component("drivingLicenseServiceImpl")
public class VehicleLicenseServiceImpl implements VehicleLicenseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private VehicleLicenseRepository drivingLicenseRepository;

    @Autowired
    private CitizenClient citizenClient;

    @Override
    public VehicleLicenseDto create(CreateVehicleLicenseRequestDto createDrivingLicenseRequestDto) {
        logger.info("DrivingLicenseServiceImpl.create(" + createDrivingLicenseRequestDto + ")");
        /*getting citizen info from citizen feign client*/
        BaseResponseDto<CitizenDto> citizenClientBaseResponseDto = citizenClient.getCizienByNid(createDrivingLicenseRequestDto.getOwnerNid());
        if (citizenClientBaseResponseDto.getStatus() != 200) {
            throw new RuntimeException("Error Connection with Citizen Service\n" + citizenClientBaseResponseDto.getMessage());
        }
        CitizenDto citizenDto = citizenClientBaseResponseDto.getResult();

        /*generating license id number*/
        String vehicleId = genVehicleId();

        VehicleLicenseEntity drivingLicenseEntity = VehicleLicenseEntity.builder()
                .vehicleId(vehicleId)
                .motorNumber(createDrivingLicenseRequestDto.getMotorNumber())
                .chassisNumber(createDrivingLicenseRequestDto.getChassisNumber())
                .vehicleModel(createDrivingLicenseRequestDto.getModel().getModelName())
                .vehicleModelYear(createDrivingLicenseRequestDto.getVehicleModelYear())
                .ownerNid(citizenDto.getNid())
                .ownerFirstName(citizenDto.getFirstName())
                .ownerMidName(citizenDto.getSecondName() + " " + citizenDto.getThirdName())
                .ownerLastName(citizenDto.getFourthName())
                .ownerGender(citizenDto.getGender())
                .ownerBirthDate(citizenDto.getBirthDate())
                .extractDateTime(LocalDateTime.now())
                .build();
        VehicleLicenseEntity newDrivingLicenseEntity = drivingLicenseRepository.save(drivingLicenseEntity);
        VehicleLicenseDto vehicleLicenseDto = new VehicleLicenseDto();
        BeanUtils.copyProperties(newDrivingLicenseEntity, vehicleLicenseDto);
        vehicleLicenseDto.setOwner(citizenDto);
        vehicleLicenseDto.setModel(new ModelDto(newDrivingLicenseEntity.getMotorNumber(), null));
        return vehicleLicenseDto;
    }

    @Override
    public List<VehicleLicenseDto> getByOwnerNid(String ownerNid) {
        /*getting citizen info from citizen feign client*/
        BaseResponseDto<CitizenDto> citizenClientBaseResponseDto = citizenClient.getCizienByNid(ownerNid);
        CitizenDto citizenDto = null;
        if (citizenClientBaseResponseDto.getStatus() == 200) {
            citizenDto = citizenClientBaseResponseDto.getResult();
        } else {
            citizenDto = new CitizenDto();
            citizenDto.setNid(ownerNid);
        }
        List<VehicleLicenseEntity> vehicleLicenseEntityList = drivingLicenseRepository.findByOwnerNid(ownerNid);
        if (vehicleLicenseEntityList != null && !vehicleLicenseEntityList.isEmpty()) {
            List<VehicleLicenseDto> vehicleLicenseDtoList = new ArrayList<>();
            for (VehicleLicenseEntity e : vehicleLicenseEntityList) {
                VehicleLicenseDto vehicleLicenseDto = new VehicleLicenseDto();
                BeanUtils.copyProperties(e, vehicleLicenseDto);
                vehicleLicenseDto.setOwner(citizenDto);
                vehicleLicenseDto.setModel(new ModelDto(e.getMotorNumber(), null));
                vehicleLicenseDtoList.add(vehicleLicenseDto);
            }
            return vehicleLicenseDtoList;
        }
        return null;
    }

    private String genVehicleId() {
        char c1 = (char) generateRandom('A', 'Z');
        char c2 = (char) generateRandom('A', 'Z');
        char c3 = (char) generateRandom('A', 'Z');
        char c4 = (char) generateRandom('A', 'Z');
        int n1 = generateRandom(0, 9);
        int n2 = generateRandom(0, 9);
        int n3 = generateRandom(0, 9);
        return c1 + c2 + c3 + c4 + "|" + n1 + n2 + n3;
    }

    private int generateRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
