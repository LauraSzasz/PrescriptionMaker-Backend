package com.fortech.Prescription.Maker.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "prescriptions")
@Data
@NoArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescription_id")
    private int id;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToMany
    @JoinTable(name = "medicine",
    joinColumns = @JoinColumn(name = "medicine_id"),
    inverseJoinColumns = @JoinColumn(name="prescription_id"))
    private Set<Medicine> medicineSet;

    @JsonManagedReference
    public Patient getPatient() {
        return patient;
    }

    @JsonBackReference
    public Set<Medicine> getMedicineSet() {
        return medicineSet;
    }
}
