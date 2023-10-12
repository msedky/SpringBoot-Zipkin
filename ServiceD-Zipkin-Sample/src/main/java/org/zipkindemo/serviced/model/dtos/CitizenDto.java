package org.zipkindemo.serviced.model.dtos;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CitizenDto implements Serializable {
    private String nid;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String fourthName;
    private GenderEnum gender;
    private LocalDate birthDate;
    private String address;
}