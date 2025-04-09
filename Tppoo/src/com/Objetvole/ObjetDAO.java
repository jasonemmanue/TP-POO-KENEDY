package com.Objetvole;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ObjetDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ObjetVole";
    private static final String JDBC_USER = "root"; //
    private static final String JDBC_PASSWORD = "Argentemma1234"; 

    public void ajouterObjet(Objet objet) throws SQLException {
        String sql = "INSERT INTO Objets (type, marque, modele, numero_serie, date_vol, statut, proprietaire_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, objet.getType());
            preparedStatement.setString(2, objet.getMarque());
            preparedStatement.setString(3, objet.getModele());
            preparedStatement.setString(4, objet.getNumeroSerie());
            preparedStatement.setDate(5, Date.valueOf(objet.getDateVol()));
            preparedStatement.setString(6, objet.getStatut());
            preparedStatement.setInt(7, objet.getProprietaireId());
            preparedStatement.executeUpdate();
        }
    }

    public List<Objet> rechercherObjets(String recherche) throws SQLException {
        List<Objet> objets = new ArrayList<>();
        String sql = "SELECT * FROM Objets WHERE numero_serie = ? OR marque = ? OR modele = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, recherche);
            preparedStatement.setString(2, recherche);
            preparedStatement.setString(3, recherche);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Objet objet = new Objet();
                objet.setId(resultSet.getInt("id"));
                objet.setType(resultSet.getString("type"));
                objet.setMarque(resultSet.getString("marque"));
                objet.setModele(resultSet.getString("modele"));
                objet.setNumeroSerie(resultSet.getString("numero_serie"));
                objet.setDateVol(resultSet.getDate("date_vol").toLocalDate());
                objet.setStatut(resultSet.getString("statut"));
                objet.setProprietaireId(resultSet.getInt("proprietaire_id"));
                objets.add(objet);
            }
        }
        return objets;
    }
}