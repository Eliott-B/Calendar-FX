package models;

/**
 * Interface des constantes pour les jours de la semaine et les mois.
 * @author Eliott B
 */
public interface ConstantesCalendrier {
    /**
     * Tableau des jours de la semaine en String
     */
    String [] JOURS_SEMAINE = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
    /**
     * Tableau des mois en String
     */
    String [] MOIS = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
    /**
     * Tableau des jours en écriture racourcite
     */
    String [] SHORT_DAY = {"lu","ma","me","je","ve","sa","di"};
    /**
     * Tableau des heures de 7 à 17
     */
    String [] HOURS = {"7","8","9","10","11","12","13","14","15","16","17"};
    /**
     * Tableau des quarts d'heures
     */
    String [] MINUTES = {"00","15","30","45"};
}
