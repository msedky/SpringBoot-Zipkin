package org.zipkindemo.serviced.controllers;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zipkindemo.serviced.model.dtos.CitizenDto;
import org.zipkindemo.serviced.model.dtos.response.BaseResponseDto;
import org.zipkindemo.serviced.services.CitizenService;

@RestController
@RequestMapping("/citizens")
@Api(description = " ", tags = "Citizen", value = " ")
public class CitizenController {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    @Qualifier("citizenServiceImpl")
    private CitizenService citizenService;

    @GetMapping("/byNid/{nid}")
    public ResponseEntity<BaseResponseDto> getByNid(@PathVariable String nid) {
        try {
            logger.info("searching citizen by Nation Id [" + nid + "] .....");
            CitizenDto citizenDto = citizenService.getById(nid);
            logger.info("found citizen by Nation Id [" + nid + "] .....");
            logger.info(citizenDto.toString());
            return ResponseEntity.ok(BaseResponseDto.success(citizenDto));
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(BaseResponseDto.failure(e.getMessage()));
        }
    }
}
