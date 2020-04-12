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
@Table(name = "TCartonagem")
@PrimaryKeyJoinColumn(name = "idProduto")
public class Cartonagem extends Produto {
	
	private boolean tecido;
	private boolean tecidoImpermeabilizado;
	private boolean sintetico;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduto", nullable = false)
	@MapsId
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Produto produto;
	
	public Cartonagem() {
		super();
	}
	
	public Cartonagem (String codigo, String nome) {
		super(codigo, nome);
	}
	
	public boolean isTecido() {
		return tecido;
	}
	public void setTecido(boolean tecido) {
		this.tecido = tecido;
	}
	public boolean isTecidoImpermeabilizado() {
		return tecidoImpermeabilizado;
	}
	public void setTecidoImpermeabilizado(boolean tecidoImpermeabilizado) {
		this.tecidoImpermeabilizado = tecidoImpermeabilizado;
	}
	public boolean isSintetico() {
		return sintetico;
	}
	public void setSintetico(boolean sintetico) {
		this.sintetico = sintetico;
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
		return String.format("%s - %s - %s - %s", super.toString(), this.tecido ? "sim" : "não", this.tecidoImpermeabilizado ? "sim" : "não", this.sintetico ? "sim" : "não");
	}
	
	public void exibir() {
		System.out.println("Cartonagem:");
		System.out.println(this);
	}
	
}