package fr.tlse.m1miage.ea.procrastinapp.rest_api.enums;

public enum NiveauPrestige {
    BRONZE("BRONZE"),
    ARGENT("ARGENT"),
    OR("OR");

    private final String niveauPrestige ;

    private NiveauPrestige(String niveauPrestige){this.niveauPrestige = niveauPrestige;}

    public String getNiveauPrestige(){return niveauPrestige;}
}
