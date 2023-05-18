package vue;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.*;

/**
 * Classe VBoxPlaning
 * @author Eliott B
 * @see Label
 * @see TableColumn
 * @see TableView
 * @see VBox
 * @see PropertyValueFactory
 * @see models
 */
public class VBoxPlanning extends VBox {
    /**
     * Date
     */
    DateCalendrier date;
    /**
     * Label de la semaine
     */
    Label semaine;
    /**
     * TableView de Reservation
     */
    TableView <Reservation> tableRes = new TableView<>();

    /**
     * Constructeur de la classe
     */
    public VBoxPlanning() {
        date = new DateCalendrier();
        semaine = new Label("Semaine "+date.getWeekOfYear());
        this.getChildren().add(semaine);

        TableColumn <Reservation, Date> dateColumn = new TableColumn<>("Date");
        TableColumn <Reservation, String> titreColumn = new TableColumn<>("Titre");
        TableColumn <Reservation, PlageHoraire> horaireColumn = new TableColumn<>("Horaire");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        titreColumn.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        horaireColumn.setCellValueFactory(new PropertyValueFactory<>("PlageHoraire"));
        tableRes.getColumns().addAll(dateColumn, titreColumn, horaireColumn);

        dateColumn.setReorderable(false);
        titreColumn.setReorderable(false);
        horaireColumn.setReorderable(false);
        dateColumn.setPrefWidth(150);
        titreColumn.setPrefWidth(120);
        horaireColumn.setPrefWidth(100);
        dateColumn.setResizable(false);
        titreColumn.setResizable(false);
        horaireColumn.setResizable(false);

        tableRes.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY );
        tableRes.setPrefSize( 300, 500 );

        dateColumn.setSortType(TableColumn.SortType.ASCENDING);
        horaireColumn.setSortType(TableColumn.SortType.ASCENDING);
        tableRes.getSortOrder().addAll(dateColumn,horaireColumn);

        if(HBoxRoot.getPlanning().getReservations(date.getWeekOfYear()) != null){
            for(Reservation res : HBoxRoot.getPlanning().getReservations(date.getWeekOfYear())){
                tableRes.getItems().add(res);
            }
            tableRes.sort();
        }


        this.getChildren().add(tableRes);
    }

    /**
     * Change la date
     * @param date DateCalendrier
     */
    public void setDate(DateCalendrier date){
        semaine.setText("Semaine "+date.getWeekOfYear());
        tableRes.getItems().clear();
        if(HBoxRoot.getPlanning().getReservations(date.getWeekOfYear()) != null){
            for(Reservation res : HBoxRoot.getPlanning().getReservations(date.getWeekOfYear())){
                tableRes.getItems().add(res);
            }
            tableRes.sort();
        }
    }

    /**
     * Ajoute une réservation
     * @param res Reservation
     */
    public void addReservation(Reservation res){
        tableRes.getItems().add(res);
        tableRes.sort();
    }
}
