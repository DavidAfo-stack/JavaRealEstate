package MyRealEstate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomePage extends Application {

    /**
     * @param stage
     * @throws Exception
     * This class extends Application which has a start method for
     * getting the home page window
     * the home button navigates the user back to the home page
     * this uses FXMLLoader to get the url of the home page and then set
     * the scene to the home page
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent par = FXMLLoader.load(getClass().getResource("Index.fxml"));
        Scene sc =  new Scene(par);
        stage.setTitle("Home");
        stage.setScene(sc);
        stage.show();
    }

    /**
     * @param args
     * this method is used to load java fx application
     */
    public static void main(String[] args) {
        launch(args);
     }
}

