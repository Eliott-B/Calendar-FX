package models;

/**
 * Exception des réservations
 * @author Eliott B
 * @see Exception
 * @see ConstantesErreurs
 */
public class ExceptionReservation extends Exception implements ConstantesErreurs {

    /**
     * Constructeur de la classe
     * @param codeErr int
     */
    public ExceptionReservation(int codeErr){
        super(ERREURS_RESERVATION[codeErr]);
    }
}
