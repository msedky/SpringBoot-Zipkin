package org.zipkindemo.servicea.models.dtos;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class BrandDto implements Serializable {
    private String brandName;
    private String brandCountry;
}
