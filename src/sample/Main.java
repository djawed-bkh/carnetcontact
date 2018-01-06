package sample;
import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static boolean creation=false;


    public static void create(){
        String url = "jdbc:sqlite:tuto.db" ;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:tuto.db";

        // SQL statement for creating a new table
        String sql ="CREATE  TABLE CONTACT "+
                "(ID            INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "NOM          TEXT    NOT NULL, "+
                "PRENOM    TEXT    NOT NULL, "+
                "VILLE           TEXT    NOT NULL, "+
                "CPOSTAL           TEXT    NOT NULL, "+
                "ANNIV           TEXT    NOT NULL, "+
                "RUE  TEXT     NOT NULL);";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        create();
        createNewTable();
        launch(args); }

}
