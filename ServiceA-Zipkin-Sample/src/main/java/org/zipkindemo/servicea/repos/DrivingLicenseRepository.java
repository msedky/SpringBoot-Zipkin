package org.zipkindemo.servicea.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zipkindemo.servicea.models.entities.DrivingLicenseEntity;

import java.util.List;

@Repository
public interface DrivingLicenseRepository extends JpaRepository<String, DrivingLicenseEntity> {
    public List<DrivingLicenseEntity> findByOwnerNid(String ownerNid);
}
