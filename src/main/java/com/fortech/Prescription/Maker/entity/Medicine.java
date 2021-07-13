package com.fortech.Prescription.Maker.entity;

import com.fortech.Prescription.Maker.enums.AdministrationMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "medicines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private Integer id;

    @Column(name = "brand_name")
    @NotEmpty(message = "Brand name cannot be empty")
    private String brandName;

    @Column(name = "chemical_name")
    @NotEmpty(message = "Chemical name cannot be empty")
    private String chemicalName;

    private String posology;

    @NotNull
    @Min(1)
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "administration_method")
    private AdministrationMethod administrationMethod;

}
