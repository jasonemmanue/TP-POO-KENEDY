package com.Objetvole;



import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ObjetVoleController {

    @FXML
    private TextField typeField;
    @FXML
    private TextField marqueField;
    @FXML
    private TextField modeleField;
    @FXML
    private TextField numeroSerieField;
    @FXML
    private DatePicker dateVolPicker;
    @FXML
    private TextField statutField;
    @FXML
    private TextField proprietaireIdField;
    @FXML
    private TextArea resultatsArea;

    private ObjetDAO objetDAO = new ObjetDAO();

    @FXML
    public void ajouterObjet() {
        Objet objet = new Objet();
        objet.setType(typeField.getText());
        objet.setMarque(marqueField.getText());
        objet.setModele(modeleField.getText());
        objet.setNumeroSerie(numeroSerieField.getText());
        objet.setDateVol(dateVolPicker.getValue());
        objet.setStatut(statutField.getText());
        try {
            objet.setProprietaireId(Integer.parseInt(proprietaireIdField.getText()));
        } catch (NumberFormatException e) {
            resultatsArea.setText("ID propriétaire invalide.");
            return;
        }

        try {
            objetDAO.ajouterObjet(objet);
            resultatsArea.setText("Objet ajouté avec succès.");
        } catch (SQLException e) {
            resultatsArea.setText("Erreur lors de l'ajout de l'objet : " + e.getMessage());
        }
    }

    @FXML
    public void rechercherObjet() {
        String recherche = numeroSerieField.getText();
        try {
            List<Objet> objets = objetDAO.rechercherObjets(recherche);
            StringBuilder resultats = new StringBuilder();
            for (Objet objet : objets) {
                resultats.append(objet.toString()).append("\n");
            }
            resultatsArea.setText(resultats.toString());
        } catch (SQLException e) {
            resultatsArea.setText("Erreur lors de la recherche : " + e.getMessage());
        }
    }
}