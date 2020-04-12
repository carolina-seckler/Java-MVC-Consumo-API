package br.edu.infnet.vendamvc.model.negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TCliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private String whatsapp;
	private String facebook;
	private String instagram;
	
	public Cliente () {}
	
	public Cliente(String nome, String cpf, String email, String whatsapp, String facebook, String instagram) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.whatsapp = whatsapp;
		this.facebook = facebook;
		this.instagram = instagram;
	}
	public Cliente(int id, String nome, String cpf, String email, String whatsapp, String facebook, String instagram) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.whatsapp = whatsapp;
		this.facebook = facebook;
		this.instagram = instagram;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s - %s - %s", this.nome, this.cpf, this.email, this.whatsapp, this.facebook, this.instagram);
	}

	public void exibir() {
		System.out.println("Cliente:");
		System.out.println(this);
	}
}
