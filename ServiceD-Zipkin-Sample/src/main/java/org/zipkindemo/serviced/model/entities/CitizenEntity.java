package org.zipkindemo.serviced.model.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.zipkindemo.serviced.model.dtos.GenderEnum;

import java.io.Serializable;
import java.time.LocalDate;

@Document(collection = "citizens")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CitizenEntity implements Serializable {
    @Id
    private String nid;

    @Field(name = "fname")
    private String firstName;

    private String secondName;
    private String thirdName;
    private String fourthName;
    private GenderEnum gender;
    private LocalDate birthDate;
    private String address;
}
