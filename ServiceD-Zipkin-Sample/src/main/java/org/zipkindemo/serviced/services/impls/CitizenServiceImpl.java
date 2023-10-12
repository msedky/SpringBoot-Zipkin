package org.zipkindemo.serviced.services.impls;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zipkindemo.serviced.model.dtos.CitizenDto;
import org.zipkindemo.serviced.model.entities.CitizenEntity;
import org.zipkindemo.serviced.repos.CitizenRepository;
import org.zipkindemo.serviced.services.CitizenService;

import java.util.List;
import java.util.Optional;

@Component("citizenServiceImpl")
public class CitizenServiceImpl implements CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public CitizenDto getById(String id) {
        Optional<CitizenEntity> optionalCitizenEntity = citizenRepository.findById(id);
        if (optionalCitizenEntity.isEmpty()) {
            throw new RuntimeException("No Citizen Found with Nation Id {" + id + "}");
        }
        CitizenEntity citizenEntity = optionalCitizenEntity.get();
        CitizenDto citizenDto = new CitizenDto();
        BeanUtils.copyProperties(citizenEntity, citizenDto);
        return citizenDto;
    }
}
