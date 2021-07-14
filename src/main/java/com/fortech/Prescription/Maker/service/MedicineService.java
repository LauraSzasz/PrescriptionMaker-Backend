package com.fortech.Prescription.Maker.service;

import com.fortech.Prescription.Maker.dto.MedicineDto;
import com.fortech.Prescription.Maker.entity.Medicine;
import com.fortech.Prescription.Maker.exception.NotFoundException;
import com.fortech.Prescription.Maker.repository.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final MedicineRepository medicineRepository;
    private final ModelMapper modelMapper;

    public MedicineDto addMedicine(MedicineDto medicineDto) {
        Medicine medicine = medicineRepository.save(modelMapper.map(medicineDto, Medicine.class));
        return modelMapper.map(medicine, MedicineDto.class);
    }

    public List<MedicineDto> getAll() {
        return medicineRepository.findAllByOrderByBrandNameAsc().stream()
                .map(medicine -> modelMapper.map(medicine, MedicineDto.class))
                .collect(Collectors.toList());
    }

    public MedicineDto getById(Integer id) {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new NotFoundException("Medicine was not found"));
        return modelMapper.map(medicine, MedicineDto.class);
    }

    public List<MedicineDto> getAllByBrandName(String brandName) {
        return medicineRepository.findAllByBrandName(brandName).stream()
                .map(medicine -> modelMapper.map(medicine, MedicineDto.class))
                .collect(Collectors.toList());
    }

    public List<MedicineDto> getAllByChemicalName(String chemicalName) {
        return medicineRepository.findAllByChemicalName(chemicalName).stream()
                .map(medicine -> modelMapper.map(medicine, MedicineDto.class))
                .collect(Collectors.toList());
    }

    public void update(Integer id, MedicineDto updatedMedicine) {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        if (medicine.isPresent()) {
            Medicine oldMedicine = medicine.get();
            System.out.println(oldMedicine.toString());
            oldMedicine.setBrandName(updatedMedicine.getBrandName());
            oldMedicine.setChemicalName(updatedMedicine.getChemicalName());
            oldMedicine.setAdministrationMethod(updatedMedicine.getAdministrationMethod());
            oldMedicine.setPosology(updatedMedicine.getPosology());
            oldMedicine.setQuantity(updatedMedicine.getQuantity());
            medicineRepository.save(oldMedicine);
        } else {
            throw new NotFoundException("Medicine not found");
        }
    }

    public void deleteById(Integer id) {
        medicineRepository.deleteById(id);
    }

}
