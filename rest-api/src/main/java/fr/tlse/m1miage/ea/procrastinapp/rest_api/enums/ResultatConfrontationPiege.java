package fr.tlse.m1miage.ea.procrastinapp.rest_api.enums;

public enum ResultatConfrontationPiege {
    SUCCES("SUCCES"),
    ECHEC("ECHEC");

    private final String resultatConfrontationPiege;

    private ResultatConfrontationPiege(String resultatConfrontationPiege) {
        this.resultatConfrontationPiege = resultatConfrontationPiege;
    }

    public String getResultatConfrontationPiege() {
        return resultatConfrontationPiege;
    }
}
