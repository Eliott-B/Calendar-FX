package controler;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import models.*;
import tools.ReadWrite;
import vue.GridForm;
import vue.HBoxRoot;
import vue.VBoxPlanning;

/**
 * Contrôleur de l'interface.
 * @author Eliott B
 * @see Event
 * @see EventHandler
 * @see Button
 * @see ToggleButton
 * @see models
 * @see ReadWrite
 * @see GridForm
 * @see HBoxRoot
 * @see VBoxPlanning
 */
public class Controler implements EventHandler {

    /**
     * Handle
     * @param event Event
     */
    @Override
    public void handle (Event event){
        PlanningCollections planning = HBoxRoot.getPlanning();
        GridForm reservation = HBoxRoot.getForm();
        VBoxPlanning vPlanning = HBoxRoot.getVPlanning();

        if(event.getSource() instanceof ToggleButton){
            DateCalendrier date = (DateCalendrier)((ToggleButton)event.getSource()).getUserData();
            reservation.setDate(date);
            vPlanning.setDate(date);
        }

        if(event.getSource() instanceof Button){
            try {
                Reservation res = new Reservation(reservation.getDate(),reservation.getPlageHoraire(), reservation.getIntitule());
                planning.ajout(res);
                vPlanning.addReservation(res);
                ReadWrite.write(HBoxRoot.getFile(), planning);
            } catch (ExceptionReservation e) {
                throw new RuntimeException(e);
            }
        }
    }

}
