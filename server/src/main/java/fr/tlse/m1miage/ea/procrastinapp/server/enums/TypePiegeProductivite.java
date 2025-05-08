package fr.tlse.m1miage.ea.procrastinapp.server.enums;

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
