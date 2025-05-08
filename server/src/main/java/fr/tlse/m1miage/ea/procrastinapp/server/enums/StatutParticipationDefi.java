package fr.tlse.m1miage.ea.procrastinapp.server.enums;

public enum StatutParticipationDefi {
    INSCRIT("INSCRIT"),
    EN_COURS("EN_COURS"),
    TERMINE("TERMINE");

    private final String statutParticipationDefi;

    private StatutParticipationDefi(String statutParticipationDefi) {
        this.statutParticipationDefi = statutParticipationDefi;
    }

    public String getName() {
        return statutParticipationDefi;
    }
}
