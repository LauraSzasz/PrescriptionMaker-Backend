package com.fortech.Prescription.Maker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fortech.Prescription.Maker.dto.MedicineDto;
import com.fortech.Prescription.Maker.enums.AdministrationMethod;
import com.fortech.Prescription.Maker.service.MedicineService;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MedicineController.class)
class MedicineControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    @MockBean
    private MedicineService medicineService;
    @Autowired
    ObjectMapper objectMapper;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    private MedicineDto medicineDto1 = new MedicineDto(1, "Arcoxia 60mg", "Etoricoxibum", "1-0-1", 10, AdministrationMethod.ORAL);
    private MedicineDto medicineDto2 = new MedicineDto(2, "Arcoxia 90mg", "Etoricoxibum", "1-0-1", 10, AdministrationMethod.ORAL);
    private List<MedicineDto> medicineDtoList;


    @Test
    @SneakyThrows
    void addMedicine() {
        MedicineDto medicineDto3 = new MedicineDto(1, "Arcoxia 60mg", "Etoricoxibum", "1-0-1", 10, AdministrationMethod.ORAL);
        when(medicineService.addMedicine(any(MedicineDto.class))).thenReturn(medicineDto3);
        mockMvc.perform(post("/medicines")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(medicineDto1))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandName", is(medicineDto1.getBrandName())))
                .andExpect(jsonPath("$.chemicalName", is(medicineDto1.getChemicalName())))
                .andReturn();

    }

    @SneakyThrows
    @Test
    public void addMedicineWithInvalidData(){
       medicineDto1.setBrandName("");
        mockMvc.perform(post("/medicines")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(medicineDto1)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", containsString("Validation Failed")));
    }

    @Test
    @SneakyThrows
    void getAllMedicines() {
        medicineDtoList = Arrays.asList(medicineDto1, medicineDto2);
        when(medicineService.getAll()).thenReturn(medicineDtoList);
        mockMvc.perform(get("/medicines"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(medicineDto1.getId())))
                .andExpect(jsonPath("$[0].brandName", is(medicineDto1.getBrandName())))
                .andExpect(jsonPath("$[0].chemicalName", is(medicineDto1.getChemicalName())))
                .andExpect(jsonPath("$[1].id", is(medicineDto2.getId())))
                .andExpect(jsonPath("$[1].brandName", is(medicineDto2.getBrandName())))
                .andExpect(jsonPath("$[1].chemicalName", is(medicineDto2.getChemicalName())));

        verify(medicineService).getAll();
    }

    @Test
    @SneakyThrows
    void getMedicineById() {
        when(medicineService.getById(1)).thenReturn(medicineDto1);
        mockMvc.perform(MockMvcRequestBuilders.get("/medicines/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(medicineDto1.getId())))
                .andExpect(jsonPath("$.brandName", is(medicineDto1.getBrandName())))
                .andExpect(jsonPath("$.chemicalName", is(medicineDto1.getChemicalName())))
                .andReturn();

        verify(medicineService).getById(1);
    }

    @SneakyThrows
    @Test
    void updateMedicine() {
        when(medicineService.getById(1)).thenReturn(medicineDto1);
        mockMvc.perform(MockMvcRequestBuilders.put("/medicines/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(medicineDto2)))
                .andExpect(status().isOk());

        verify(medicineService).update(1, medicineDto2);

    }

    @SneakyThrows
    @Test
    void deleteMedicine() {
            this.mockMvc.perform(MockMvcRequestBuilders
                    .delete("/medicines/{id}", 1)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

            verify(medicineService).deleteById(1);
        }
}