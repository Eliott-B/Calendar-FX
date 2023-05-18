package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Classe PlanningCollections
 * @author Eliott B
 * @see Serializable
 * @see ArrayList
 * @see Calendar
 * @see TreeMap
 * @see TreeSet
 */
public class PlanningCollections implements Serializable {
    /**
     * ArrayList des réservations
     */
    private final ArrayList <Reservation> reservations;
    /**
     * TreeSet des réservations
     */
    private final TreeSet <Reservation> ensemble;
    /**
     * TreeMap des réservations (int, ArrayList<Reservation>)
     */
    private final TreeMap <Integer,ArrayList<Reservation>> map;

    /**
     * Contructeur de la classe.
     */
    public PlanningCollections (){
        reservations = new ArrayList<>();
        ensemble = new TreeSet<>();
        map = new TreeMap<>();
    }

    /**
     * Ajoute une réservation au planning
     * @param r Resrvation
     */
    public void ajout(Reservation r){
        reservations.add(r);
        ensemble.add(r);
        Calendar date = Calendar.getInstance();
        date.set(r.getDate().annee,r.getDate().mois -1,r.getDate().jour);
        int weekOfYears = date.get(Calendar.WEEK_OF_YEAR);
        if(!map.containsKey(weekOfYears)){
            ArrayList <Reservation> l = new ArrayList<>();
            l.add(r);
            map.put(weekOfYears,l);
        }else{
            map.get(weekOfYears).add(r);
        }
    }

    /**
     * Retourne la liste des réservations pour une semaine donnée
     * @param semaine int
     * @return ArrayList <Reservation>
     */
    public ArrayList <Reservation> getReservations(Integer semaine){
        return map.get(semaine);
    }

    /**
     * Retourne l'affiche de la classe
     * @return String
     */
    public String toString(){
        return reservations.size() + " " + reservations.toString() + "\n"
                + ensemble.size() + " " + ensemble.toString() + "\n"
                + map.size() + " " + map.toString();
    }

}
