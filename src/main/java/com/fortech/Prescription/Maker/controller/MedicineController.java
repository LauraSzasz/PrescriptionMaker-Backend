package com.fortech.Prescription.Maker.controller;

import com.fortech.Prescription.Maker.dto.MedicineDto;
import com.fortech.Prescription.Maker.entity.Medicine;
import com.fortech.Prescription.Maker.exception.NotFoundException;
import com.fortech.Prescription.Maker.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    @PostMapping("/")
    public MedicineDto addMedicine(@RequestBody MedicineDto medicineDto) {
        return new MedicineDto(medicineService.addMedicine(medicineDto.toEntity()));
    }

    @GetMapping("/")
    public List<MedicineDto> getAllMedicines() {
        List<Medicine> medicineList = medicineService.getAll();
        return medicineList.stream()
                .map(m -> new MedicineDto(m))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MedicineDto getMedicineById(@PathVariable Integer id) {
        Medicine medicine = medicineService.getById(id).orElseThrow(() -> new NotFoundException("Medicine not found"));
        return new MedicineDto(medicine);
    }

    @GetMapping("/brandName/{brandName}")
    public List<MedicineDto> getMedicinesByBrandName(@PathVariable String brandName) {
        List<Medicine> medicineList = medicineService.getAllByBrandName(brandName);
        return medicineList.stream()
                .map(m ->new MedicineDto(m))
                .collect(Collectors.toList());
    }

    @GetMapping("/chemicalName/{chemicalName}")
    public List<MedicineDto> getMedicinesByChemicalName(@PathVariable String chemicalName) {
        List<Medicine> medicineList = medicineService.getAllByChemicalName(chemicalName);
        return medicineList.stream()
                .map(m->new MedicineDto(m))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void updateMedicine(@PathVariable Integer id, @RequestBody MedicineDto medicineDto) {
        medicineService.update(id, medicineDto.toEntity());
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable Integer id) {
        medicineService.deleteById(id);
    }

}
