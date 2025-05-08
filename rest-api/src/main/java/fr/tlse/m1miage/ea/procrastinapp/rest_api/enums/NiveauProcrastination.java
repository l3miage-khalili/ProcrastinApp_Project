package fr.tlse.m1miage.ea.procrastinapp.rest_api.enums;

public enum NiveauProcrastination {
    DEBUTANT("DEBUTANT"),
    INTERMEDIAIRE("INTERMEDIAIRE"),
    EXPERT("EXPERT");

    private final String niveauProcrastinationme;

    private NiveauProcrastination(String niveauProcrastinationme) {
        this.niveauProcrastinationme = niveauProcrastinationme;
    }
    public String getNiveauProcrastinationme() {
        return niveauProcrastinationme;
    }
}
