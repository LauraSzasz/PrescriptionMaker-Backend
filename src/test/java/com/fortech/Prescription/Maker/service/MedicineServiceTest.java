package com.fortech.Prescription.Maker.service;

import com.fortech.Prescription.Maker.dto.MedicineDto;
import com.fortech.Prescription.Maker.entity.Medicine;
import com.fortech.Prescription.Maker.enums.AdministrationMethod;
import com.fortech.Prescription.Maker.repository.MedicineRepository;
import com.sun.xml.bind.v2.schemagen.episode.SchemaBindings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MedicineServiceTest {

    @Mock
    ModelMapper modelMapper;
    @Mock
    private MedicineRepository medicineRepository;
    @InjectMocks
    private MedicineService medicineService;


    MedicineDto medicineDto1 = new MedicineDto(1,"Arcoxia 60mg","Etoricoxibum","1-0-1", 10, AdministrationMethod.ORAL);
    MedicineDto medicineDto2 = new MedicineDto(2,"Arcoxia 90mg","Etoricoxibum","1-0-1", 10,AdministrationMethod.ORAL);
    Medicine medicine1 = new Medicine(1,"Arcoxia 60mg","Etoricoxibum","1-0-1", 10, AdministrationMethod.ORAL);
    Medicine medicine2 = new Medicine(2,"Arcoxia 90mg","Etoricoxibum","1-0-1", 10,AdministrationMethod.ORAL);



//    @Test
//    void addMedicine() {
//        when(medicineRepository.save(medicine1)).thenReturn(medicine1);
//        MedicineDto savedMedicineDto = medicineService.addMedicine(medicineDto1);
//        assertEquals(savedMedicineDto, medicineDto1);
//        verify(medicineRepository, atLeastOnce()).save(medicine1);
//    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void getAllByBrandName() {
    }

    @Test
    void getAllByChemicalName() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}