package fr.tlse.m1miage.ea.procrastinapp.server.enums;

public enum TypeRecompense {
    BADGE("BADGE"),
    TITRE_HONORIFIQUE("TITRE_HONORIFIQUE"),
    POUVOIR_SPECIAL("POUVOIR_SPECIAL");

    private final String typeRecompense;

    private TypeRecompense(String typeRecompense) {
        this.typeRecompense = typeRecompense;
    }

    public String getTypeRecompense() {
        return typeRecompense;
    }


}
