package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class carnetController {
    //init
    @FXML
    private Button nouv;
    @FXML
    private Button modif;
    @FXML
    private Button sup;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label city;
    @FXML
    private Label cpostal;
    @FXML
    private Label anniv;
    @FXML
    private Label rue;
    //init

public void sup(ActionEvent event){

}
public void modif(ActionEvent event){

}
public void ajout(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    System.out.println("verification");
    Parent root = FXMLLoader.load(getClass().getResource("/sample/modif.fxml"));
    Stage primaryStage = new Stage();
    primaryStage.setTitle("carnet de contact");
    primaryStage.setScene(new Scene(root));
    primaryStage.setResizable(false);
    primaryStage.show();
}
    public class SelectApp {

        private Connection connect() {
            // SQLite connection string
            String url = "jdbc:sqlite:tuto.db";
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
        }


        public void consulter(){
            String sql = "SELECT ID,NOM,PRENOM,VILLE,CPOSTAL,ANNIV,RUE FROM CONTACT";

            try (Connection conn = this.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)){



                          prenom.setText(rs.getString("NOM"));
                            nom.setText(rs.getString("PRENOM"));
                            city.setText(rs.getString("VILLE"));
                            cpostal.setText(rs.getString("CPOSTAL"));
                            anniv.setText(rs.getString("ANNIV"));
                           rue.setText(rs.getString("RUE"));
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }}

        public void affiche(ActionEvent event){
    prenom.setText("");
    nom.setText("");
    city.setText("");
    cpostal.setText("");
    anniv.setText("");
    rue.setText("");

}
}}
