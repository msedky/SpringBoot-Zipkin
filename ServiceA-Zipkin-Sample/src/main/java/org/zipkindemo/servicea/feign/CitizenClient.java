package org.zipkindemo.servicea.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.zipkindemo.servicea.models.dtos.CitizenDto;
import org.zipkindemo.servicea.models.dtos.response.BaseResponseDto;

@FeignClient(name = "${citizen-service.name}"/*, url = "${citizen-service.url}"*/)
//@FeignClient(name = "citizen-service", url = "http://localhost:7061")
public interface CitizenClient {

    @GetMapping(value = "/citizens/byNid/{nid}")
    public BaseResponseDto<CitizenDto> getCizienByNid(@PathVariable("nid") String nid);
}
