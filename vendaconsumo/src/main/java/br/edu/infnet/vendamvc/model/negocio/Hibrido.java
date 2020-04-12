package br.edu.infnet.vendamvc.model.negocio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "THibrido")
@PrimaryKeyJoinColumn(name = "idProduto")
public class Hibrido extends Produto {
	
	private boolean cartonagemETecido;
	private boolean cartonagemEMatelasse;
	private boolean tecnicasSeparadas;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduto", nullable = false)
	@MapsId
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Produto produto;
	
	public Hibrido() {
		super();
	}
	
	public Hibrido (String codigo, String nome) {
		super(codigo, nome);
	} 

	public boolean isCartonagemETecido() {
		return cartonagemETecido;
	}
	public void setCartonagemETecido(boolean cartonagemETecido) {
		this.cartonagemETecido = cartonagemETecido;
	}
	public boolean isCartonagemEMatelasse() {
		return cartonagemEMatelasse;
	}
	public void setCartonagemEMatelasse(boolean cartonagemEMatelasse) {
		this.cartonagemEMatelasse = cartonagemEMatelasse;
	}
	public boolean isTecnicasSeparadas() {
		return tecnicasSeparadas;
	}
	public void setTecnicasSeparadas(boolean tecnicasSeparadas) {
		this.tecnicasSeparadas = tecnicasSeparadas;
	}
	public int getIdProduto() {
		return produto.getId();
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s", super.toString(), this.cartonagemETecido ? "sim" : "não", this.cartonagemEMatelasse ? "sim" : "não", this.tecnicasSeparadas ? "sim" : "não");
	}
	
	public void exibir() {
		System.out.println("Híbrido:");
		System.out.println(this);
	}

}
