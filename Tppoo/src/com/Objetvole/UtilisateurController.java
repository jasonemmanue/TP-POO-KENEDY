package com.Objetvole;



import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.Objetvole.UtilisateurDAO;
import com.Objetvole.Utilisateur;

import java.sql.SQLException;

public class UtilisateurController {

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField telephoneField;

    private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    @FXML
    public void ajouterUtilisateur() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nomField.getText());
        utilisateur.setPrenom(prenomField.getText());
        utilisateur.setEmail(emailField.getText());
        utilisateur.setTelephone(telephoneField.getText());

        try {
            utilisateurDAO.ajouterUtilisateur(utilisateur);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}