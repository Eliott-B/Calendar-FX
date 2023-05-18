package models;

import java.util.Calendar;

/**
 * Classe DateCalendrier, elle permet de manipuler des jours de la semaines
 * @author Eliott B
 * @see Date
 * @see java.util.Calendar
 */
public class DateCalendrier extends Date implements ConstantesCalendrier, Comparable <Date>{
    /**
     * Numéro du jour de la semaine (ex: 1 pour lundi)
     */
    private final int jourSemaine;

    /**
     * Contructeur de la classe qui met la date d'aujourd'hui.
     * @see java.util.Calendar
     */
    public DateCalendrier(){
        super();
        Calendar today = Calendar.getInstance();
        // 1 pour dimanche
        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek == 1){
            jourSemaine = 7;
        }else{
            jourSemaine = dayOfWeek-1;
        }
    }

    /**
     * Constructeur qui défini le jour de la semaine par rapport à la date mit en paramètre.
     * @param jour int
     * @param mois int
     * @param annee int
     */
    public DateCalendrier(int jour, int mois, int annee){
        super(jour,mois,annee);
        Calendar date = Calendar.getInstance();
        date.set(this.annee, this.mois -1, this.jour);
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek == 1){
            jourSemaine = 7;
        }else{
            jourSemaine = dayOfWeek-1;
        }
    }

    /**
     * Retourne la date du lendemain.
     * @return DateCalendrier
     */
    public DateCalendrier dateDuLendemain(){
        Date dateL = super.dateDuLendemain();
        return new DateCalendrier(dateL.jour, dateL.mois, dateL.annee);
    }

    /**
     * Retourne la date de la veille.
     * @return DateCalendrier
     */
    public DateCalendrier dateDeLaVeille(){
        Date dateV = super.dateDeLaVeille();
        return new DateCalendrier(dateV.jour, dateV.mois, dateV.annee);
    }

    /**
     * Retourne le jour de la semaine de l'objet
     * @return int
     */
    public int getJourSemaine(){
        return jourSemaine;
    }

    /**
     * Retourne le mois de l'objet
     * @return int
     */
    public int getMois(){
        return mois;

    }

    /**
     * Retourne l'année de l'objet
     * @return int
     */
    public int getAnnee(){
        return annee;

    }

    /**
     * Retourne le numéro de semaine de l'objet
     * @return int
     */
    public int getWeekOfYear() {
        Calendar date = Calendar.getInstance();
        date.set(annee, mois -1, jour);
        return date.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * Indique si c'est la date d'aujourd'hui
     * @return boolean
     */
    public boolean isToday() {
        return this.compareTo(new Date()) == 0;
    }

    /**
     * Retourne l'affichage de la classe.
     * @return String
     * @see ConstantesCalendrier
     */
    public String toString(){
        return JOURS_SEMAINE[jourSemaine-1]+" "+ jour +" "+MOIS[mois -1]+" "+ annee;
    }

}