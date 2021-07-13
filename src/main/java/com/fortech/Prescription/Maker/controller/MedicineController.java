package com.fortech.Prescription.Maker.controller;

import com.fortech.Prescription.Maker.dto.MedicineDto;
import com.fortech.Prescription.Maker.entity.Medicine;
import com.fortech.Prescription.Maker.exception.NotFoundException;
import com.fortech.Prescription.Maker.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medicines")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {

    private final MedicineService medicineService;
    private final MedicineDto medicineDto;

    @PostMapping()
    public MedicineDto addMedicine(@RequestBody MedicineDto medicineDto) {
        return new MedicineDto(medicineService.addMedicine(medicineDto.toEntity()));
    }

    @GetMapping()
    public List<MedicineDto> getAllMedicines() {
        return medicineDto.medicineToDtoList(medicineService.getAll());
    }

    @GetMapping("/{id}")
    public MedicineDto getMedicineById(@PathVariable Integer id) {
        Medicine medicine = medicineService.getById(id).orElseThrow(() -> new NotFoundException("Medicine not found"));
        return new MedicineDto(medicine);
    }

    @GetMapping("/brandName/{brandName}")
    public List<MedicineDto> getMedicinesByBrandName(@PathVariable String brandName) {
        return medicineDto.medicineToDtoList(medicineService.getAllByBrandName(brandName));

    }

    @GetMapping("/chemicalName/{chemicalName}")
    public List<MedicineDto> getMedicinesByChemicalName(@PathVariable String chemicalName) {
        return medicineDto.medicineToDtoList(medicineService.getAllByChemicalName(chemicalName));
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
