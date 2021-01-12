package sn.springsenforageapi.springApi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Abonne implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nomClient;
	@Column
	private String adresse;
	@Column
	private String telephone;
	@ManyToOne
	@JoinColumn(name="village_ID")
	private Village village ;
	
	@ManyToOne
	@JoinColumn(name="user_ID")
	private User user ;
	public Abonne() {
		//super();
	}
	public Abonne(int id, String nomClient, String adresse, String telephone, Village village, User user) {
		//super();
		this.id = id;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.telephone = telephone;
		this.village = village;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Village getVillage() {
		return village;
	}
	public void setVillage(Village village) {
		this.village = village;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Abonne [id=" + id + ", nomClient=" + nomClient + ", adresse=" + adresse + ", telephone=" + telephone
				+ ", village=" + village + ", user=" + user + "]";
	}
	
	
	
	
	
	
}
