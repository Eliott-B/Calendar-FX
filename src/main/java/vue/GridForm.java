package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import models.*;

/**
 * Classe du formulaire
 * @author Eliott B
 * @see ActionEvent
 * @see EventHandler
 * @see Insets
 * @see GridPane
 * @see models
 */
public class GridForm extends GridPane implements ConstantesCalendrier {
    /**
     * Date
     */
    private Date date;
    /**
     * Heure de début
     */
    private final ComboBox <String>  startHour;
    /**
     * Heure de fin
     */
    private final ComboBox <String>  endHour;
    /**
     * Minutes de début
     */
    private final ComboBox <String>  startMinutes;
    /**
     * Minutes de fin
     */
    private final ComboBox <String>  endMinutes;
    /**
     * Intitulé
     */
    private final TextField intitule;
    /**
     * Label de la date
     */
    private final Label labelDate;

    /**
     * Constructeur de la classe
     */
    public GridForm (){
        super();
        this.setGridLinesVisible(false);

        DateCalendrier date = new DateCalendrier();
        this.date = date;
        labelDate = new Label(date.toString());
        this.add(labelDate,0,0,4,1);
        GridPane.setMargin(labelDate,new Insets(0,0,15,0));

        Label name = new Label("cours");
        intitule = new TextField();
        this.add(name,0,1);
        this.add(intitule,1,1,2,1);

        Label hours = new Label("");
        this.add(hours,0,4);
        Label start = new Label("début  ");
        Label end = new Label("fin  ");
        this.add(start,0,5);
        this.add(end,0,6);
        startHour = comboBox(HOURS);
        startMinutes = comboBox(MINUTES);
        Label h = new Label(" h ");
        this.add(startHour,1,5);
        this.add(h,2,5);
        this.add(startMinutes,3,5);
        endHour = comboBox(HOURS);
        endMinutes = comboBox(MINUTES);
        Label h1 = new Label(" h ");
        this.add(endHour,1,6);
        this.add(h1,2,6);
        this.add(endMinutes,3,6);

        Label blank = new Label();
        this.add(blank,0,7);

        Button cancel = new Button("_Annuler");
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                intitule.setText("");
                startHour.setValue(HOURS[0]);
                endHour.setValue(HOURS[0]);
                startMinutes.setValue(MINUTES[0]);
                endMinutes.setValue(MINUTES[0]);
            }
        });
        this.add(cancel,2,8);
        Button save = new Button("_Enregister");
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                save.addEventHandler(ActionEvent.ACTION, HBoxRoot.getControler());
            }
        });
        this.add(save,3,8);

    }

    /**
     * Créer des ComboBox
     * @param strings String []
     * @return ComboBox <String>
     */
    private ComboBox <String> comboBox(String [] strings){
        ComboBox <String> comboBox = new ComboBox<>();
        for (String string : strings){
            comboBox.getItems().add(string);
        }
        return comboBox;
    }

    /**
     * Change la date
     * @param date Date
     */
    public void setDate(Date date){
        this.date = date;
        labelDate.setText(date.toString());
    }

    /**
     * Retourne la date
     * @return Date
     */
    public Date getDate(){
        return date;
    }

    /**
     * Retourne la plage horaire
     * @return PlageHoraire
     */
    public PlageHoraire getPlageHoraire(){
        try {
            Horaire start = new Horaire(startHour.getSelectionModel().getSelectedIndex()+7, startMinutes.getSelectionModel().getSelectedIndex()*15);
            Horaire end = new Horaire(endHour.getSelectionModel().getSelectedIndex()+7, endMinutes.getSelectionModel().getSelectedIndex()*15);
            return new PlageHoraire(start,end);
        } catch (ExceptionPlageHorraire e) {
            throw new RuntimeException(e);
        }
    }

    public String getIntitule(){
        return intitule.getText();
    }
}
