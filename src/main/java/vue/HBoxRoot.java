package vue;

import controler.Controler;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import models.PlanningCollections;
import tools.ReadWrite;
import java.io.File;

/**
 * Classe de l'HBox root, principale
 * @author Eliott B
 * @see Controler
 * @see Pos
 * @see PlanningCollections
 * @see ReadWrite
 * @see File
 */
public class HBoxRoot extends HBox {
    /**
     * Objet PlanningCollection
     */
    private static PlanningCollections planning;
    /**
     * Formulaire
     */
    private static final GridForm form = new GridForm();
    /**
     * Calendrier
     */
    private static final VBoxCalendar calendar = new VBoxCalendar(5);
    /**
     * Contrôleur
     */
    private static final Controler controler = new Controler();
    /**
     * Planning
     */
    private static VBoxPlanning VPlanning;
    /**
     * Fichier
     */
    private static File file;

    /**
     * Constructeur de la classe.
     * @param marge int
     */
    public HBoxRoot(int marge) {
        super(marge);

        file = new File("data"+File.separator+"planning_2003.ser");
        if (file.exists()){
            planning = (PlanningCollections) ReadWrite.read(file);
        } else {
            planning = new PlanningCollections();
        }

        VPlanning = new VBoxPlanning();

        form.setAlignment(Pos.TOP_CENTER);
        HBox.setHgrow(form, Priority.ALWAYS);
        HBox.setHgrow(calendar, Priority.ALWAYS);
        HBox.setHgrow(VPlanning, Priority.ALWAYS);

        this.getChildren().addAll(calendar,form,VPlanning);
    }

    /**
     * Retourne le fichier
     * @return File
     */
    public static File getFile(){
        return file;
    }

    /**
     * Retourne le Planning Collection
     * @return PlanningCollections
     */
    public static PlanningCollections getPlanning(){
        return planning;
    }

    /**
     * Retourne le planning
     * @return VBoxPlanning
     */
    public static VBoxPlanning getVPlanning(){
        return VPlanning;
    }

    /**
     * Retourne le formulaire
     * @return GridForm
     */
    public static GridForm getForm(){
        return form;
    }

    /**
     * Retourne le contrôleur
     * @return Controler
     */
    public static Controler getControler(){
        return controler;
    }
}

