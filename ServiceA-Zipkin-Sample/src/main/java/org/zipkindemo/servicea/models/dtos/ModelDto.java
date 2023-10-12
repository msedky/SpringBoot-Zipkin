package org.zipkindemo.servicea.models.dtos;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ModelDto implements Serializable {
    private String modelName;
    private BrandDto brand;
}
