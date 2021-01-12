package sn.springsenforageapi.springApi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Village implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom; 
	
	public Village() {
		//super();
	}
	public Village(int id, String nom, List<Abonne> abonnes, List<User> users) {
		//super();
		this.id = id;
		this.nom = nom;
	}
	public Village(int id, String nom) {
		//super();
		this.id = id;
		this.nom = nom;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Village [id=" + id + ", nom=" + nom + "]";
	}
	
	
	}
