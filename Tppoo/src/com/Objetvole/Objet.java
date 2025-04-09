package com.Objetvole;



import java.time.LocalDate;

public class Objet {
    private int id;
    private String type;
    private String marque;
    private String modele;
    private String numeroSerie;
    private LocalDate dateVol;
    private String statut;
    private int proprietaireId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public LocalDate getDateVol() {
		return dateVol;
	}
	public void setDateVol(LocalDate dateVol) {
		this.dateVol = dateVol;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public int getProprietaireId() {
		return proprietaireId;
	}
	public void setProprietaireId(int proprietaireId) {
		this.proprietaireId = proprietaireId;
	}

   
}
