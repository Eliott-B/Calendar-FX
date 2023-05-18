package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.File;

/**
 * Classe de l'application
 * @author Eliott B
 * @see Application
 * @see Scene
 * @see HBox
 * @see Stage
 * @see File
 */
public class CalendarApp extends Application {

    /**
     * Paramètre l'application
     * @param stage Stage
     */
    public void start(Stage stage) {
        HBox root = new HBoxRoot(10);
        Scene scene = new Scene(root, 1000, 300);

        File css = new File("css"+File.separator+"styles.css");
        scene.getStylesheets().add(css.toURI().toString());

        stage.setScene(scene);
        stage.setTitle("Calendar");
        stage.centerOnScreen();
        stage.setResizable(false);

        stage.show();
    }

    /**
     * Lance l'application
     * @param args String []
     */
    public static void main(String[] args) {
        Application.launch();
    }
}
