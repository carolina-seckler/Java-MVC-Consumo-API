package br.edu.infnet.vendamvc.model.negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TUsuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String login;
	private String senha;
	
	public Usuario() {}
	
	public Usuario(String nome, String login, String senha) {
		this();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public Usuario(int id, String nome, String login, String senha) {
		this(nome, login, senha);
		this.id = id;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s - %s - %s", 
				this.getId(),
				this.getNome(),
				this.getLogin(),
				this.getSenha());
	}
	
}
