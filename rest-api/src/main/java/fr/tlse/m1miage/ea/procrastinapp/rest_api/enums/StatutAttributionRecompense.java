package fr.tlse.m1miage.ea.procrastinapp.rest_api.enums;

public enum StatutAttributionRecompense {
    ACTIF("ACTIF"),
    EXPIRE("EXPIRE");

    private final String statutAttributionRecompense;

    private StatutAttributionRecompense(String statutAttributionRecompense) {
        this.statutAttributionRecompense = statutAttributionRecompense;
    }

    public String getStatutAttributionRecompense() {
        return statutAttributionRecompense;
    }
}
