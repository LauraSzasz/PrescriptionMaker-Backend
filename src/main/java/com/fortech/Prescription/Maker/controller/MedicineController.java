package com.fortech.Prescription.Maker.controller;

import com.fortech.Prescription.Maker.dto.MedicineDto;
import com.fortech.Prescription.Maker.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<MedicineDto> addMedicine(@Valid @RequestBody MedicineDto medicineDto) {
        return ResponseEntity.ok(medicineService.addMedicine(medicineDto));
    }

    @GetMapping()
    public ResponseEntity<List<MedicineDto>> getAllMedicines() {
        return ResponseEntity.ok(medicineService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicineDto> getMedicineById(@PathVariable Integer id) {
        return ResponseEntity.ok(medicineService.getById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicineDto> updateMedicine(@PathVariable Integer id, @Valid @RequestBody MedicineDto medicineDto) {
        medicineService.update(id, medicineDto);
        return ResponseEntity.ok(medicineDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable Integer id) {
        medicineService.deleteById(id);
    }
}
