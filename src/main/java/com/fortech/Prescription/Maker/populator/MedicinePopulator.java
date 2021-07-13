package com.fortech.Prescription.Maker.populator;

import com.fortech.Prescription.Maker.dto.MedicineDto;
import com.fortech.Prescription.Maker.entity.Medicine;
import com.fortech.Prescription.Maker.enums.AdministrationMethod;
import com.fortech.Prescription.Maker.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MedicinePopulator implements CommandLineRunner {

    private final MedicineService medicineService;

    @Override
    public void run(String... args) throws Exception {

        MedicineDto medicine1 = new MedicineDto(1,"Arcoxia 60mg","Etoricoxibum","1-0-1", 10,AdministrationMethod.ORAL);
        MedicineDto medicine2 = new MedicineDto(2,"Nasonex 0.05%","Mometazonum","1-0-1", 1,AdministrationMethod.NASAL);
        MedicineDto medicine3 = new MedicineDto(3,"Opatanol 1mg/mL","Olopatadine", "1-0-1",1, AdministrationMethod.OPHTHALMIC);
        MedicineDto medicine4 = new MedicineDto(4,"Tamalis 10mg","Rupatadine", "1-0-0", 1,AdministrationMethod.ORAL);
        MedicineDto medicine5 = new MedicineDto(5,"Arcoxia 90mg","Etoricoxibum","1-0-1", 10,AdministrationMethod.ORAL);
        MedicineDto medicine6 = new MedicineDto(6,"Arcoxia 120mg","Etoricoxibum","1-0-1", 10,AdministrationMethod.ORAL);
        MedicineDto medicine7 = new MedicineDto(7,"Nebilet 5mg","Nebivololum","1-0-1", 10,AdministrationMethod.ORAL);
        MedicineDto medicine8 = new MedicineDto(8,"Toujeo SoloStar 300U/mL","Insulin glargine","3*5U/day", 6,AdministrationMethod.SUBCUTANEOUS);
        MedicineDto medicine9 = new MedicineDto(9,"Novocalmin 300mg","Metamizole","1-0-1", 10,AdministrationMethod.RECTAL);


        medicineService.addMedicine(medicine1);
        medicineService.addMedicine(medicine2);
        medicineService.addMedicine(medicine3);
        medicineService.addMedicine(medicine4);
        medicineService.addMedicine(medicine5);
        medicineService.addMedicine(medicine6);
        medicineService.addMedicine(medicine7);
        medicineService.addMedicine(medicine8);
        medicineService.addMedicine(medicine9);

    }
}
