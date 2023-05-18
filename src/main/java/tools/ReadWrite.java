package tools;

import java.io.*;

/**
 * Classe de lecture et écriture dans un fichier
 * @author Eliott B
 * @see File
 */
public class ReadWrite {

    /**
     * Lit un fichier
     * @param file File
     * @return Object
     */
    public static Object read (File file){
        ObjectInputStream stream;
        Object readObject = null;
        try{
            stream = new ObjectInputStream(new FileInputStream(file));
            readObject = (Object)stream.readObject();
            stream.close();
        }catch (ClassNotFoundException exception){
            System.err.println(exception.toString());
            System.exit(1);
        }catch (IOException exception){
            System.err.println("Erreur lecture du fichier "+exception.toString());
            System.exit(1);
        }
        return readObject;
    }

    /**
     * Ecrit dans un fichier
     * @param file File
     * @param object Object
     */
    public static void write (File file, Object object){
        ObjectOutputStream stream = null;
        try{
            stream = new ObjectOutputStream(new FileOutputStream(file));
            stream.writeObject(object);
            stream.flush();
            stream.close();
        }catch (IOException exception){
            System.err.println("Probleme a l'ecriture\n"+exception.toString());
            System.exit(1);
        }
    }
}
