package com.fortech.Prescription.Maker.enums;

public enum AdministrationMethod {
    AURICULAR ("AURICULAR"),
    CUTANEOUS("CUTANEOUS"),
    INTRAMUSCULAR ("INTRAMUSCULAR"),
    INTRAVENOUS("INTRAVENOUS"),
    NASAL("NASAL"),
    OPHTHALMIC("OPHTHALMIC"),
    ORAL("ORAL"),
    RECTAL("RECTAL"),
    PARENTERAL("PARENTERAL"),
    TOPICAL("TOPICAL"),
    VAGINAL("VAGINAL");

    private String value;

    AdministrationMethod(String value) {
        this.value = value;
    }
}
