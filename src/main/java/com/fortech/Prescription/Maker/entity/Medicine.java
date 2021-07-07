package com.fortech.Prescription.Maker.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fortech.Prescription.Maker.enums.AdministrationMethod;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "medicines")
@Data
@NoArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private int id;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "chemical_name")
    private String chemicalName;

    private int quantity;

    private String posology;

    @Enumerated(EnumType.STRING)
    @Column(name = "administration_method")
    private AdministrationMethod administrationMethod;


}
