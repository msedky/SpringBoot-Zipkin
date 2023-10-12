package org.zipkindemo.servicea.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zipkindemo.servicea.models.entities.VehicleLicenseEntity;

import java.util.List;

@Repository
public interface VehicleLicenseRepository extends JpaRepository<VehicleLicenseEntity, String> {
    public List<VehicleLicenseEntity> findByOwnerNid(String ownerNid);
}
