package fr.tlse.m1miage.ea.procrastinapp.server.enums;

public enum StatutPiegeProductivite {
    ACTIF("ACTIF"),
    INACTIF("INACTIF");

    private final String statutPiegeProductivite;

    private StatutPiegeProductivite(String statutPiegeProductivite) {
        this.statutPiegeProductivite = statutPiegeProductivite;
    }

    public String getStatutPiegeProductivite() {
        return statutPiegeProductivite;
    }

}
