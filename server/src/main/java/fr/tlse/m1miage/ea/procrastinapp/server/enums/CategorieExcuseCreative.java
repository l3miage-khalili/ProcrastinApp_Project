package fr.tlse.m1miage.ea.procrastinapp.server.enums;

public enum CategorieExcuseCreative {
    TRAVAIL("TRAVAIL"),
    ETUDES("ETUDES"),
    VIE_SOCIALE("VIE_SOCIALE");

    private final String categorieExcuseCreative;

    private CategorieExcuseCreative(String categorieExcuseCreative) {
        this.categorieExcuseCreative = categorieExcuseCreative;
    }
    public String getCategorieExcuseCreative() {
        return categorieExcuseCreative;
    }
}
