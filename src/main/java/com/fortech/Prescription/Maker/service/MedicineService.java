package com.fortech.Prescription.Maker.service;

import com.fortech.Prescription.Maker.entity.Medicine;
import com.fortech.Prescription.Maker.exception.NotFoundException;
import com.fortech.Prescription.Maker.repository.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public Medicine addMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public List<Medicine> getAll(){
        return medicineRepository.findAllByOrderByBrandNameAsc();
    }

    public Optional<Medicine> getById(Integer id) {
        return medicineRepository.findById(id);
    }

    public List<Medicine> getAllByBrandName(String brandName) {
        return medicineRepository.findAllByBrandName(brandName);
    }

    public List<Medicine> getAllByChemicalName(String chemicalName) {
        return medicineRepository.findAllByChemicalName(chemicalName);
    }

    public void update(Integer id, Medicine updatedMedicine) {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        if (medicine.isPresent()) {
            Medicine oldMedicine = medicine.get();
            System.out.println(oldMedicine.toString());
            oldMedicine.setBrandName(updatedMedicine.getBrandName());
            oldMedicine.setChemicalName(updatedMedicine.getChemicalName());
            oldMedicine.setAdministrationMethod(updatedMedicine.getAdministrationMethod());
            oldMedicine.setPosology(updatedMedicine.getPosology());
            oldMedicine.setQuantity(updatedMedicine.getQuantity());
            System.out.println(oldMedicine.toString());
        } else {
            throw new NotFoundException("Medicine not found");
        }
    }

    public void deleteById(Integer id) {
        medicineRepository.deleteById(id);
    }

}
