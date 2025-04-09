CREATE DATABASE IF NOT EXISTS Objetvole;
USE Objetvole;


CREATE TABLE Utilisateurs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    email VARCHAR(255),
    telephone VARCHAR(255)
);

CREATE TABLE Objets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(255),
    marque VARCHAR(255),
    modele VARCHAR(255),
    numero_serie VARCHAR(255),
    date_vol DATE,
    statut VARCHAR(255),
    proprietaire_id INT,
    FOREIGN KEY (proprietaire_id) REFERENCES Utilisateurs(id)
);