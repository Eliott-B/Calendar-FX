package models;

/**
 * Exception des plages horraires
 * @author Eliott B
 * @see Exception
 * @see ConstantesErreurs
 */
public class ExceptionPlageHorraire extends Exception implements ConstantesErreurs {

    /**
     * Constructeur de la classe
     * @param codeErr int
     */
    public ExceptionPlageHorraire(int codeErr){
        super(ERREUR_PLAGE_HORAIRE[codeErr]);
    }
}
