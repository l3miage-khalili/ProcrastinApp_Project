package fr.tlse.m1miage.ea.procrastinapp.rest_api.enums;

public enum NiveauDifficulte {
    FACILE("FACILE"),
    MOYEN("MOYEN"),
    DIFFICILE("DIFFICILE");

    private final String niveauDifficulte;

    private NiveauDifficulte(String niveauDifficulte) {
        this.niveauDifficulte = niveauDifficulte;
    }

    public String getNiveauDifficulte() {
        return niveauDifficulte;
    }
}
