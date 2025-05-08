package fr.tlse.m1miage.ea.procrastinapp.rest_api.enums;

public enum Role {
    PROCRASTINATEUR_EN_HERBE("PROCRASTINATEUR_EN_HERBE"),
    ANTI_PROCRASTINATEUR_REPENTI("ANTI_PROCRASTINATEUR_REPENTI"),
    GESTIONNAIRE_TEMPS_PERDU("GESTIONNAIRE_TEMPS_PERDU");

    private final String role;

    private Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
