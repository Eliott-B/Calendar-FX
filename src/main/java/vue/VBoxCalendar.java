package vue;

import controler.Controler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import models.CalendrierDuMois;
import models.ConstantesCalendrier;
import models.DateCalendrier;
import java.util.List;

/**
 * Classe VBoxCalendar
 * @author Eliott B
 * @see Controler
 * @see HBox
 * @see ActionEvent
 * @see EventHandler
 * @see Insets
 * @see Pos
 * @see Node
 * @see CalendrierDuMois
 * @see ConstantesCalendrier
 * @see DateCalendrier
 * @see List
 */
public class VBoxCalendar extends VBox implements ConstantesCalendrier {

    /**
     * Constructeur de la classe
     * @param marge int
     */
    public VBoxCalendar(int marge){
        super(marge);
        DateCalendrier today = new DateCalendrier();
        final int mois = today.getMois();
        final int annee = today.getAnnee();

        Label lActuelle = new Label(MOIS[mois-1]+" "+annee);

        StackPane stackMois = new StackPane();

        ToggleGroup buttonGroup = new ToggleGroup();
        for (int nbMonths=1; nbMonths<=12; nbMonths++) {
            CalendrierDuMois monthCalendar = new CalendrierDuMois(nbMonths, today.getAnnee());

            TilePane tilePane = new TilePane();
            tilePane.setId("background");

            for (String shortDay : SHORT_DAY) {
                Label day = new Label(shortDay);
                tilePane.getChildren().add(day);
            }

            for (DateCalendrier date : monthCalendar.getDates()) {
                ToggleButton buttonDate = new ToggleButton(Integer.toString(date.getJour()));
                buttonDate.setToggleGroup(buttonGroup);
                tilePane.getChildren().add(buttonDate);
                buttonDate.setUserData(date);

                buttonDate.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        buttonDate.addEventHandler(ActionEvent.ACTION, HBoxRoot.getControler());
                    }
                });
                if (date.getMois() != monthCalendar.getMois()) {
                    buttonDate.setId("outMonth");
                }
                if (date.isToday()) {
                    buttonDate.setId("today");
                }
            }
            tilePane.setAccessibleText(MOIS[nbMonths-1]);
            stackMois.getChildren().add(tilePane);
        }

        List<Node> liste = stackMois.getChildren();
        while(!liste.get(liste.size()-1).getAccessibleText().equals(MOIS[mois-1])){
            liste.get(liste.size()-1).toBack();
        }

        Button precedent = new Button("<");
        precedent.setOnAction(actionEvent -> {
            if(!liste.get(liste.size()-1).getAccessibleText().equals(MOIS[0])){
                liste.get(liste.size()-1).toBack();
                lActuelle.setText(liste.get(liste.size()-1).getAccessibleText()+" "+annee);
            }
        });

        Button prochain = new Button(">");
        prochain.setOnAction(actionEvent -> {
            if(!liste.get(liste.size()-1).getAccessibleText().equals(MOIS[11])) {
                liste.get(0).toFront();
                lActuelle.setText(liste.get(liste.size() - 1).getAccessibleText() + " " + annee);
            }
        });

        Button premier = new Button("<<");
        premier.setOnAction(actionEvent -> {
            List<Node> liste1 = stackMois.getChildren();
            while(!liste1.get(liste1.size()-1).getAccessibleText().equals(MOIS[0])){
                liste1.get(liste1.size()-1).toBack();
                lActuelle.setText(liste1.get(liste1.size()-1).getAccessibleText()+" "+annee);
            }
        });

        Button dernier = new Button(">>");
        dernier.setOnAction(actionEvent -> {
            List<Node> liste12 = stackMois.getChildren();
            while(!liste12.get(liste12.size()-1).getAccessibleText().equals(MOIS[11])){
                liste12.get(0).toFront();
                lActuelle.setText(liste12.get(liste12.size()-1).getAccessibleText()+" "+annee);
            }
        });

        HBox buttonBox = new HBox();

        HBox.setMargin(lActuelle, new Insets(0,12,0,12));

        HBox.setMargin(precedent, new Insets(0,8,0,8));
        HBox.setMargin(prochain, new Insets(0,8,0,0));

        buttonBox.getChildren().addAll(premier,precedent,prochain,dernier);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(buttonBox, Priority.ALWAYS);

        this.getChildren().addAll(lActuelle,stackMois,buttonBox);
    }
}
