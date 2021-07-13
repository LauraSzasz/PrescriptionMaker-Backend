package com.fortech.Prescription.Maker.dto;

import com.fortech.Prescription.Maker.entity.Medicine;
import com.fortech.Prescription.Maker.enums.AdministrationMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MedicineDto {

    private Integer id;
    private String brandName;
    private String chemicalName;
    private int quantity;
    private String posology;
    private AdministrationMethod administrationMethod;

    public MedicineDto(Medicine entity) {
        this.id = entity.getId();
        this.brandName = entity.getBrandName();
        this.chemicalName = entity.getChemicalName();
        this.quantity = entity.getQuantity();
        this.posology = entity.getPosology();
        this.administrationMethod = entity.getAdministrationMethod();
    }

    public Medicine toEntity() {
        Medicine medicineEntity = new Medicine();
        medicineEntity.setId(this.getId());
        medicineEntity.setBrandName(this.getBrandName());
        medicineEntity.setChemicalName(this.getChemicalName());
        medicineEntity.setQuantity(this.getQuantity());
        medicineEntity.setPosology(this.getPosology());
        medicineEntity.setAdministrationMethod(this.getAdministrationMethod());

        return medicineEntity;
    }

    public List<MedicineDto> medicineToDtoList(List<Medicine> medicineList) {
        return medicineList.stream()
                .map(medicine -> new MedicineDto(medicine))
                .collect(Collectors.toList());
    }

    public List<Medicine> medicineDtoToMedicineList(List<MedicineDto> medicineDtoList){
        return medicineDtoList.stream()
                .map(medicineDto -> medicineDto.toEntity())
                .collect(Collectors.toList());
    }

}
