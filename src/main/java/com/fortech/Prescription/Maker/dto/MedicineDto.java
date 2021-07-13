package com.fortech.Prescription.Maker.dto;
import com.fortech.Prescription.Maker.enums.AdministrationMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDto {

    private Integer id;

    @NotNull
    private String brandName;

    @NotNull
    private String chemicalName;

    private String posology;

    @NotNull
    @Min(1)
    private Integer quantity;

    private AdministrationMethod administrationMethod;

}
