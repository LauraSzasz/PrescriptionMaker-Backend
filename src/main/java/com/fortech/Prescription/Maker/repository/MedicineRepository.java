package com.fortech.Prescription.Maker.repository;

import com.fortech.Prescription.Maker.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

    List<Medicine> findAllByBrandName(String brandName);

    List<Medicine> findAllByChemicalName(String brandName);

    List<Medicine> findAllByOrderByBrandNameAsc();

}
