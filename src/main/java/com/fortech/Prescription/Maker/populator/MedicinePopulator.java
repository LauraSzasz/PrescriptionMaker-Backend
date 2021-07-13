package com.fortech.Prescription.Maker.populator;

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

        Medicine medicine1 = new Medicine(1,"Arcoxia","Etoricoxibum", 20,"1-0-1", AdministrationMethod.ORAL);
        Medicine medicine2 = new Medicine(2,"Nasonex","Mometazonum", 1,"1-0-1", AdministrationMethod.NASAL);
        Medicine medicine3 = new Medicine(3,"Opatanol","Olopatadine", 20,"1-0-1", AdministrationMethod.OPHTHALMIC);
        Medicine medicine4 = new Medicine(4,"Tamalis","Rupatadine", 20,"1-0-0", AdministrationMethod.ORAL);

        medicineService.addMedicine(medicine1);
        medicineService.addMedicine(medicine2);
        medicineService.addMedicine(medicine3);
        medicineService.addMedicine(medicine4);

    }
}
