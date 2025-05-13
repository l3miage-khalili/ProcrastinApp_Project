let creationProcrastinateur = {
    "id": 2,
    "pseudo": "procras",
    "adresseEmail": "procras@gmail.com",
    "role": "PROCRASTINATEUR_EN_HERBE"
}

let creationAntiProcrastinateur = {
    "id": 3,
    "pseudo": "apr",
    "adresseEmail": "apr@gmail.com",
    "role": "ANTI_PROCRASTINATEUR_REPENTI"
}

let creationPiegeProductivite = {
    "titre":"Plannifier ses journées",
    "description":"Force le Procrastinateur en herbe à plannifier ses journée la veille pour etre plus productif",
    "typePiegeProductivite":"DEFI",
    "createur":1,
    "niveauDifficulte":"DIFFICILE",
    "recompenseResistance": 1000,
    "consequenceEchec":500,
    "statut":"ACTIF"
}

let creationDefiProcrastination = {
    "id": 1,
    "idCreateur": 1,
    "titre": "defi études",
    "description": "Repousser un devoir important jusqu'à la dernière minute",
    "duree": 20,
    "difficulte": "DIFFICILE",
    "pointsAGagner": 50,
    "dateDebut": "2025-05-12",
    "dateFin": "2025-05-30"
}

let creationTachesAEviter = {
    "idUtilisateur": 3,
    "taches": [
        {
            "id": 1,
            "description": "Implémenter les endpoints de l'entité TacheAEviter",
            "degreUrgence": 2,
            "dateLimite": "2025-05-12",
            "consequencesPotentielles": "Rater la moyenne"
        },
        {
            "id": 2,
            "description": "Implémenter les endpoints de l'entité DefiProcrastination",
            "degreUrgence": 2,
            "dateLimite": "2025-05-12",
            "consequencesPotentielles": "Rater la moyenne"
        }
    ]
}

let creationParticipationAUnDefi = {
    "id": 1,
    "idDefi": 1,
    "idUtilisateur": 2
}