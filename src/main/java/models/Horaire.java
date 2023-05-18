package models;

import java.io.Serializable;

/**
 * Classe Horaire, elle permet de manipuler des horaires
 * @author Eliott B
 * @see Serializable
 */
public class Horaire implements Serializable {
    /**
     * Heure
     */
    private final int heure;
    /**
     * Quart d'heure
     */
    private final int quartHeure;

    /**
     * Constructeur de la classe Horraire.
     * @param heure int
     * @param quartHeure int
     */
    public Horaire(int heure, int quartHeure){
        this.heure=heure;
        this.quartHeure=quartHeure;
    }

    /**
     * Convertis l'horaire en minutes.
     * @return int
     */
    public int toMinutes(){
        return heure*60+quartHeure;
    }

    /**
     * Retourne l'affichage de l'horaire.
     * @return String
     */
    public String toString() {
        return heure+"h"+quartHeure;
    }
}
