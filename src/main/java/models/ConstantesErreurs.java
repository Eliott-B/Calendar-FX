package models;

/**
 * Interface des constantes pour les erreurs.
 * @author Eliott B
 */
public interface ConstantesErreurs {
    /**
     * Tableau des erreurs des plages horraires
     */
    String [] ERREUR_PLAGE_HORAIRE = {
            "La plage horaire est invalide",
            "La plage horaire ne respecte pas la durée minimale"
    };
    /**
     * Tableau erreurs des réservations
     */
    String [] ERREURS_RESERVATION = {
            "L'intitulé ne peut pas être vide"
    };
}
