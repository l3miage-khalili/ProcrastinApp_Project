package fr.tlse.m1miage.ea.procrastinapp.rest_api.enums;

public enum TypePiegeProductivite {
    JEU("JEU"),
    DEFI("DEFI"),
    MEDITATION("MEDITATION");

    private final String typePiege;

    private TypePiegeProductivite(String typePiege) {
        this.typePiege = typePiege;
    }

    public String getTypePiege() {
        return typePiege;
    }
}
