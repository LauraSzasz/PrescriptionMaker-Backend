package com.fortech.Prescription.Maker.repository;

import com.fortech.Prescription.Maker.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

    List<Medicine> findAllByOrderByBrandNameAsc();

}
