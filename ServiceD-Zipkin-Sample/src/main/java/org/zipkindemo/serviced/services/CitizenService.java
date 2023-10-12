package org.zipkindemo.serviced.services;

import org.springframework.stereotype.Service;
import org.zipkindemo.serviced.model.dtos.CitizenDto;

import java.util.List;

@Service
public interface CitizenService {
    public CitizenDto getById(String id);
}
