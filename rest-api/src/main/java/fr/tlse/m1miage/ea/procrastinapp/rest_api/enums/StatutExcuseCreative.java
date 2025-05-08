package fr.tlse.m1miage.ea.procrastinapp.rest_api.enums;

public enum StatutExcuseCreative {
    EN_ATTENTE("EN_ATTENTE"),
    APPROUVEE("APPROUVEE"),
    REJETEE("REJETEE");

    private final String statutExcuseCreative;

    private StatutExcuseCreative(String statutExcuseCreative) {
        this.statutExcuseCreative = statutExcuseCreative;
    }

    public String getStatutExcuseCreative() {
        return statutExcuseCreative;
    }
}
