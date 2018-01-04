package sample;
import java.io.IOException;
import java.sql.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.util.Scanner;

public class modifController {
    //init
    private String name;
    private String fname;
    private String city;
    private String postal;
    private String birth;
    private String road;
    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
    @FXML
    private TextField ville;
    @FXML
    private TextField cpostal;
    @FXML
    private TextField anniv;
    @FXML
    private TextField rue;
    @FXML
    private Button valider;
    //init

    //SQL
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
    public void saisie(){
        fname=prenom.getText();
        name=nom.getText();
        city=ville.getText();
        postal=cpostal.getText();
        birth=anniv.getText();
        road=rue.getText();
    }
    public void insert() {

        String sql = "INSERT INTO CONTACT(NOM,PRENOM,VILLE,CPOSTAL,ANNIV,RUE) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, fname);
            pstmt.setString(3, city);
            pstmt.setString(4, postal);
            pstmt.setString(5, birth);
            pstmt.setString(6,road);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }}
        //SQL

    public void valider(javafx.event.ActionEvent event)throws IOException {
        saisie();
        insert();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("verification");
        Parent root = FXMLLoader.load(getClass().getResource("/sample/carnetController.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("carnet de contact");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    }
