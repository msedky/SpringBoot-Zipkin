package org.zipkindemo.servicea.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.zipkindemo.servicea.models.dtos.ColorEnum;
import org.zipkindemo.servicea.models.dtos.GenderEnum;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "driving-licenses")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class VehicleLicenseEntity implements Serializable {

    @Id
    @Column(name = "vehicle_id", updatable = false)
    private String vehicleId;

    @Column(name = "motor_number", unique = true, updatable = false)
    private String motorNumber;

    @Column(name = "motor_number", unique = true, updatable = false)
    private String chassisNumber;

    @Column(name = "model", updatable = false)
    private String vehicleModel;

    @Column(name = "vehicle_model_year")
    private Short vehicleModelYear;

    @Column(name = "vehicle_color")
    private ColorEnum vehicleColor;

    @Column(name = "extract_date_time", updatable = false)
    private LocalDateTime extractDateTime;

    @Column(name = "exp_date")
    private LocalDate expiryDate;

    @Column(name = "owner_nid")
    private String ownerNid;
    @Column(name = "owner_fname")
    private String ownerFirstName;
    @Column(name = "owner_mname")
    private String ownerMidName;
    @Column(name = "owner_lname")
    private String ownerLastName;
    @Column(name = "owner_bdate")
    private LocalDate ownerBirthDate;
    @Column(name = "owner_gender")
    private GenderEnum ownerGender;
}
