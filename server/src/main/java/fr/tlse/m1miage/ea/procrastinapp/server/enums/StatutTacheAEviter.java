package fr.tlse.m1miage.ea.procrastinapp.server.enums;

public enum StatutTacheAEviter {
    EN_ATTENTE("EN_ATTENTE"),
    EVITEE_AVEC_SUCCES("EVITEE_AVEC_SUCCES"),
    REALISEE_IN_EXTREMIS("REALISEE_IN_EXTREMIS"),
    CATASTROPHE("CATASTROPHE");

    private final String statutTacheAEviter;

    private StatutTacheAEviter(String statutTacheAEviter) {
        this.statutTacheAEviter = statutTacheAEviter;
    }

    public String getStatutTacheAEviter() {
        return statutTacheAEviter;
    }
}
