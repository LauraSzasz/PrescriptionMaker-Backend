package com.fortech.Prescription.Maker.entity;

import com.fortech.Prescription.Maker.enums.AdministrationMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String brandName;

    @Column(name = "chemical_name")
    private String chemicalName;

    private String posology;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "administration_method")
    private AdministrationMethod administrationMethod;

}
