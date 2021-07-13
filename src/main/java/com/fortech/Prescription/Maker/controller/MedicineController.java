package com.fortech.Prescription.Maker.controller;

import com.fortech.Prescription.Maker.dto.MedicineDto;
import com.fortech.Prescription.Maker.exception.NotFoundException;
import com.fortech.Prescription.Maker.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medicines")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {

    private final MedicineService medicineService;


    @PostMapping()
    public MedicineDto addMedicine(@Valid @RequestBody MedicineDto medicineDto) {
        return medicineService.addMedicine(medicineDto);
    }

    @GetMapping()
    public List<MedicineDto> getAllMedicines() {
        return medicineService.getAll();
    }

    @GetMapping("/{id}")
    public MedicineDto getMedicineById(@PathVariable Integer id) {
        return medicineService.getById(id);

    }

    @GetMapping("/brandName/{brandName}")
    public List<MedicineDto> getMedicinesByBrandName(@PathVariable String brandName) {
        return medicineService.getAllByBrandName(brandName);

    }

    @GetMapping("/chemicalName/{chemicalName}")
    public List<MedicineDto> getMedicinesByChemicalName(@PathVariable String chemicalName) {
        return medicineService.getAllByChemicalName(chemicalName);
    }

    @PutMapping("/{id}")
    public void updateMedicine(@PathVariable Integer id, @Valid @RequestBody MedicineDto medicineDto) {
        medicineService.update(id, medicineDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable Integer id) {
        medicineService.deleteById(id);
    }
}
