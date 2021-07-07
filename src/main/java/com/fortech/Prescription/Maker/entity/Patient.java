package com.fortech.Prescription.Maker.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fortech.Prescription.Maker.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="patients")
@Data
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @OneToMany(mappedBy = "patient")
    private List<Prescription> prescriptionList;

    @JsonBackReference
    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }
}
