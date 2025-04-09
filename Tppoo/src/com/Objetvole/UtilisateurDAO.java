package com.Objetvole;



import java.sql.*;

public class UtilisateurDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ObjetVole";
    private static final String JDBC_USER = "root"; // Remplacez par votre nom d'utilisateur
    private static final String JDBC_PASSWORD = ""; // Remplacez par votre mot de passe

    public void ajouterUtilisateur(Utilisateur utilisateur) throws SQLException {
        String sql = "INSERT INTO Utilisateurs (nom, prenom, email, telephone) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getEmail());
            preparedStatement.setString(4, utilisateur.getTelephone());
            preparedStatement.executeUpdate();
        }
    }
}