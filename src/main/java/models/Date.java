package models;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe Date, elle permet de manipuler des dates
 * @author Eliott B
 * @see java.util.Scanner
 * @see java.util.Calendar
 */
public class Date implements Comparable <Date>, Serializable {
    /**
     * Jour du mois
     */
    protected int jour;
    /**
     * Numéro du mois
     */
    protected int mois;
    /**
     * Année
     */
    protected int annee;

    /**
     * Constructeur qui défini la date d'aujourd'hui
     * @see java.util.Calendar
     */
    public Date() {
        Calendar today = Calendar.getInstance();
        annee = today.get(Calendar.YEAR);
        // 0 pour janvier
        mois = today.get(Calendar.MONTH)+1;
        jour = today.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Constructeur avec le jour, le mois et l'année
     * @param jour  int
     * @param mois  int
     * @param annee int
     */
    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    /**
     * Constructeur qui indique directement le 1er Janvier de l'année donnée
     * @param annee int
     */
    public Date(int annee) {
        jour = 1;
        mois = 1;
        this.annee = annee;
    }

    /**
     * Retourne le jour de l'objet
     * @return int
     */
    public int getJour() {
        return jour;
    }

    /**
     * Indique si l'année est bixectile
     * True si l'année est bixectile, False sinon
     * @param annee int
     * @return boolean
     */
    private static boolean estBixectile(int annee) {
        return (annee % 4 == 0 && annee % 100 != 0) || annee % 400 == 0;
    }

    /**
     * Retourne le dernier jour du mois
     * @param mois  int
     * @param annee int
     * @return int
     * @see Date#estBixectile(int)
     */
    private static int dernierJourDuMois(int mois, int annee) {
        switch (mois) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (Date.estBixectile(annee)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 30;
        }
    }

    /**
     * Compare deux dates, this et la date en paramètre
     * Retourne :
     * -1 si this précède la date donnée
     * 0 si se sont les mêmes dates
     * 1 si la date donnée précède this
     * @param date Date
     * @return int
     */
    public int compareTo(Date date) {
        if (date.annee < annee) {
            return 1;
        } else if (date.annee > annee) {
            return -1;
        }
        if (date.mois < mois) {
            return 1;
        } else if (date.mois > mois) {
            return -1;
        }
        if (date.jour < jour) {
            return 1;
        } else if (date.jour > jour) {
            return -1;
        }
        return 0;
    }

    /**
     * Retourne la date du lendemain
     * @return Date
     * @see Date#dernierJourDuMois(int, int)
     */
    public Date dateDuLendemain() {
        if (jour == Date.dernierJourDuMois(mois, annee) && mois < 12) {
            return new Date(1, mois + 1, annee);
        } else if (jour == Date.dernierJourDuMois(mois, annee) && mois == 12) {
            return new Date(annee + 1);
        }
        return new Date(jour + 1, mois, annee);
    }

    /**
     * Retourne la date de la veille
     * @return Date
     * @see Date#dernierJourDuMois(int, int)
     */
    public Date dateDeLaVeille() {
        if (jour == 1 && mois > 1) {
            return new Date(Date.dernierJourDuMois(mois - 1, annee), mois - 1, annee);
        } else if (jour == 1 && mois == 1) {
            return new Date(31, 12, annee - 1);
        }
        return new Date(jour - 1, mois, annee);
    }

    /**
     * Retourne l'affichage de la date
     * JJ/MM/AAAA
     * @return String
     */
    public String toString() {
        return jour + "/" + mois + "/" + annee;
    }
}
