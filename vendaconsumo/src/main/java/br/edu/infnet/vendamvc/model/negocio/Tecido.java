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
@Table(name = "TTecido")
@PrimaryKeyJoinColumn(name = "idProduto")
public class Tecido extends Produto {
	
	private boolean quiltingLivre;
	private boolean quiltingReto;
	private boolean utilitarios;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduto", nullable = false)
	@MapsId
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Produto produto;
	
	public Tecido() {
		super();
	}
	
	public Tecido (String codigo, String nome) {
		super(codigo, nome);
	} 

	public boolean isQuiltingLivre() {
		return quiltingLivre;
	}
	public void setQuiltingLivre(boolean quiltingLivre) {
		this.quiltingLivre = quiltingLivre;
	}
	public boolean isQuiltingReto() {
		return quiltingReto;
	}
	public void setQuiltingReto(boolean quiltingReto) {
		this.quiltingReto = quiltingReto;
	}
	public boolean isUtilitarios() {
		return utilitarios;
	}
	public void setUtilitarios(boolean utilitarios) {
		this.utilitarios = utilitarios;
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
		return String.format("%s - %s - %s - %s", super.toString(), this.quiltingLivre ? "sim" : "não", this.quiltingReto ? "sim" : "não", this.utilitarios ? "sim" : "não");
	}
	
	public void exibir() {
		System.out.println("Tecido:");
		System.out.println(this);
	}

}