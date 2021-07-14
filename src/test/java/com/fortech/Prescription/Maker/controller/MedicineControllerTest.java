package com.fortech.Prescription.Maker.controller;

import com.fortech.Prescription.Maker.dto.MedicineDto;
import com.fortech.Prescription.Maker.service.MedicineService;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MedicineController.class)
class MedicineControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    @Mock
    private MedicineService medicineService;
    @Mock
    private MedicineDto medicineDto;

    @Before
    private void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    @SneakyThrows
    void addMedicine() {
        mockMvc.perform(post("/medicines", medicineDto)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void getAllMedicines() {
        mockMvc.perform(get("/medicines"))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void getMedicineById(Integer id) {
        mockMvc.perform(get("/medicines/{id}", id)).andExpect(status().isOk());
    }

    @Test
    void updateMedicine() {

    }

    @Test
    void deleteMedicine() {
    }
}