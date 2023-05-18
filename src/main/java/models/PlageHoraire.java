package models;

import java.io.Serializable;

/**
 * Classe PlageHoraire, elle permet de manipuler des plages horaires
 * @author Eliott B
 * @see Serializable
 * @see ExceptionPlageHorraire
 */
public class PlageHoraire implements Comparable <PlageHoraire>, Serializable {
    /**
     * Durée minimum de la plage horaire
     */
    private final static int DUREE_MIN=60;
    /**
     * Horaire de début
     */
    private final Horaire debutH;
    /**
     * Horaire de fin
     */
    private final Horaire finH;

    /**
     * Constructeur de la classe PlageHoraire
     * @param debutH Horaire
     * @param finH Horaire
     * @throws ExceptionPlageHorraire Incorrect
     */
    public PlageHoraire(Horaire debutH, Horaire finH) throws ExceptionPlageHorraire{
        if(finH.toMinutes()<=debutH.toMinutes()){
            throw new ExceptionPlageHorraire(0);
        } else if (finH.toMinutes()-debutH.toMinutes() < DUREE_MIN) {
            throw new ExceptionPlageHorraire(1);
        }
        this.debutH=debutH;
        this.finH=finH;
    }

    /**
     * Compare this avec une plage horaire donnée.
     * Retourne -1 si this avant la plage horaire donnée
     * Retoune 0 si this est à cheval avec la plage horaire donnée
     * Retourne 1 si this est après la plage horaire donnée
     * @param plageHoraire PlageHoraire
     * @return int
     */
    public int compareTo(PlageHoraire plageHoraire){
        if(this.debutH.toMinutes() >= plageHoraire.finH.toMinutes()){
            return 1;
        }else if(this.finH.toMinutes() <= plageHoraire.debutH.toMinutes()){
            return -1;
        }else{
            return 0;
        }
    }

    /**
     * Retourne l'affichage de la plage horaire
     * @return String
     */
    public String toString(){
        return(debutH+" - "+finH);
    }
}
