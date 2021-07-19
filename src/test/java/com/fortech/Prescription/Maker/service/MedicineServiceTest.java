package com.fortech.Prescription.Maker.service;

import com.fortech.Prescription.Maker.dto.MedicineDto;
import com.fortech.Prescription.Maker.entity.Medicine;
import com.fortech.Prescription.Maker.enums.AdministrationMethod;
import com.fortech.Prescription.Maker.exception.NotFoundException;
import com.fortech.Prescription.Maker.repository.MedicineRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


    private void modelMapperMock() {
        lenient().when(modelMapper.map(medicineDto1, Medicine.class)).thenReturn(medicine1);
        lenient().when(modelMapper.map(medicine1, MedicineDto.class)).thenReturn(medicineDto1);
        lenient().when(modelMapper.map(medicineDto2, Medicine.class)).thenReturn(medicine2);
        lenient().when(modelMapper.map(medicine2, MedicineDto.class)).thenReturn(medicineDto2);
    }

    @Test
    void addMedicine() {
        when(medicineRepository.save(medicine1)).thenReturn(medicine1);
        modelMapperMock();
        MedicineDto savedMedicineDto = medicineService.addMedicine(medicineDto1);
        assertEquals(savedMedicineDto, medicineDto1);
        verify(medicineRepository, atLeastOnce()).save(medicine1);
    }

    @Test
    void getAll() {
        modelMapperMock();
        List<MedicineDto> medicineDtoList = new ArrayList<>();
        medicineDtoList.add(medicineDto1);
        List<Medicine> medicineList = medicineDtoList.stream()
                .map(medicineDto -> modelMapper.map(medicineDto, Medicine.class))
                .collect(Collectors.toList());

        lenient().when(medicineRepository.findAllByOrderByBrandNameAsc()).thenReturn(medicineList);
        List<MedicineDto> returnedMedicineDtoList = medicineService.getAll();
        assertEquals(medicineDtoList.size(), returnedMedicineDtoList.size());
        verify(medicineRepository).findAllByOrderByBrandNameAsc();

    }

    @Test
    void getById() {
        when(medicineRepository.findById(1)).thenReturn(Optional.of(medicine1));
        modelMapperMock();
        MedicineDto medicineDto = medicineService.getById(1);
        assertEquals(medicineDto, medicineDto1);
        verify(medicineRepository, atLeastOnce()).findById(1);
    }

    @Test
    void getByIdNotFound(){
        Assertions.assertThrows(NotFoundException.class, ()->{medicineService.getById(2);});
        verify(medicineRepository, atLeastOnce()).findById(2);
    }


    @Test
    void update() {
        modelMapperMock();
        when(medicineRepository.findById(1)).thenReturn(Optional.of(medicine1));
        medicineService.update(1, medicineDto2);
        assertEquals(medicine1.getAdministrationMethod(), medicineDto2.getAdministrationMethod());
        assertEquals(medicine1.getBrandName(), medicineDto2.getBrandName());
        assertEquals(medicine1.getChemicalName(), medicineDto2.getChemicalName());
        assertEquals(medicine1.getPosology(), medicineDto2.getPosology());
        assertEquals(medicine1.getQuantity(), medicineDto2.getQuantity());

        verify(medicineRepository).findById(1);
        verify(medicineRepository).save(medicine1);
    }

    @Test
    void updateWhenNotFound(){
        assertThrows(NotFoundException.class, ()->{
            medicineService.update(1, medicineDto2);
        });
    }

    @Test
    void deleteById() {
        medicineService.deleteById(1);
        verify(medicineRepository, atLeastOnce()).deleteById(1);

    }
}