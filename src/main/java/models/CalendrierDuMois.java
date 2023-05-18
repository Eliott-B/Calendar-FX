package models;

import java.util.TreeSet;
import java.util.Collection;

/**
 * Classe CalendrierDuMois, elle permet de manipuler les mois de l'année
 * @author Eliott B
 * @see DateCalendrier
 */
public class CalendrierDuMois {
    /**
     * Mois de l'année
     */
    private final int mois;
    /**
     * Collection des dates du mois de l'année.
     */
    private final Collection <DateCalendrier> treeSetDate;

    /**
     * Constructeur de la classe
     * @param mois int
     * @param annee int
     */
    public CalendrierDuMois ( int mois, int annee) {
        this.mois = mois;
        treeSetDate = new TreeSet <DateCalendrier> ();
        DateCalendrier date = new DateCalendrier (1,mois,annee);
        int indiceJour = date.getJourSemaine() ;
        for (int x = indiceJour ; x!=0 ; x--) {
            treeSetDate.add(date);
            date = date.dateDeLaVeille();
        }
        date = new DateCalendrier (2,mois,annee);
        indiceJour = indiceJour % 7 ;
        while (date.getMois () == mois) {
            while(indiceJour<7) {
                treeSetDate.add(date);
                date = date.dateDuLendemain();
                indiceJour++ ;
            }
            indiceJour=0;
        }
    }

    /**
     * Retourne le mois de l'objet
     * @return int
     */
    public int getMois () {
        return mois;
    }

    /**
     * Retourne la collection des dates de l'objet
     * @return Collection <DateCalendrier>
     */
    public Collection <DateCalendrier> getDates() {
        return treeSetDate;
    }

    /**
     * Retourne l'affiche de l'objet
     * @return String
     */
    public String toString () {
        return treeSetDate.size() + " " +treeSetDate.toString();
    }

}
