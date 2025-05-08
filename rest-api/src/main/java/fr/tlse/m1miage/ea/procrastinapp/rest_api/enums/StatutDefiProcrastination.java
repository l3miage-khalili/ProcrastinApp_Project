package fr.tlse.m1miage.ea.procrastinapp.rest_api.enums;

public enum StatutDefiProcrastination {
    ACTIF("ACTIF"),
    TERMINE("TERMINE");

    private final String statutDefiProcrastination;

    private StatutDefiProcrastination(String statutDefiProcrastination) {
        this.statutDefiProcrastination = statutDefiProcrastination;
    }

    public String getStatutDefiProcrastination() {
        return statutDefiProcrastination;
    }
}
