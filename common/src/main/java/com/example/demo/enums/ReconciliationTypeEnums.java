package com.example.demo.enums;

public enum ReconciliationTypeEnums {
    BXFY("insurancesStatementImpl"),
    BXLP("claimStatementImpl");

    private String configCode;

    ReconciliationTypeEnums(String configCode) {
        this.configCode = configCode;
    }

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }
}
