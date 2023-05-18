package models;

import java.io.Serializable;

/**
 * Classe Reservation, elle permet de manipuler des réservations
 * @author Eliott B
 * @see Serializable
 * @see ExceptionReservation
 */
public class Reservation implements Comparable <Reservation>, Serializable {
    /**
     * Date
     */
    private final Date date;
    /**
     * Plage horaire
     */
    private final PlageHoraire plageHoraire;
    /**
     * Titre de la réservation
     */
    private final String titre;

    /**
     * Constructeur de la classe Reservation
     * @param date Date
     * @param plageHoraire PlageHoraire
     * @param titre String
     * @throws ExceptionReservation Erreur
     */
    public Reservation(Date date, PlageHoraire plageHoraire, String titre) throws ExceptionReservation{
        if(titre.equals("")){
            throw new ExceptionReservation(0);
        }
        this.date = date;
        this.plageHoraire = plageHoraire;
        this.titre = titre;
    }

    /**
     * Retourne la date de la réservation
     * @return Date
     */
    public Date getDate(){
        return date;
    }

    /**
     * Retourne la plage horaire de la réservation
     * @return PlageHoraire
     */
    public PlageHoraire getPlageHoraire(){
        return plageHoraire;
    }

    /**
     * Retourne le titre de la réservation
     * @return String
     */
    public String getTitre(){
        return titre;
    }

    /**
     * Compare this avec reservation.
     * Retourne 0 si les réservations se chevauchent
     * Retourne 1 si this est après la reservation
     * Retourne -1 si this est avant la reservation
     * @param reservation Reservation
     * @return int
     */
    public int compareTo(Reservation reservation){
        if(this.date.compareTo(reservation.date) != 0){
            return this.date.compareTo(reservation.date);
        }else{
            return this.plageHoraire.compareTo(reservation.plageHoraire);
        }
    }

    /**
     * Retourne l'affichage de la réservation
     * @return String
     */
    public String toString(){
        return titre+", "+date+", "+plageHoraire;
    }
}
