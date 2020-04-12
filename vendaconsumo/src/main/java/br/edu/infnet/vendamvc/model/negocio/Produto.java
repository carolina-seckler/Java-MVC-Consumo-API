package br.edu.infnet.vendamvc.model.negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "tipo")
@JsonSubTypes({ 
		  @Type(value = Tecido.class, name = "tecido"), 
		  @Type(value = Cartonagem.class, name = "cartonagem"),
		  @Type(value = Hibrido.class, name = "hibrido")
		})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public abstract class Produto{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String codigo;
	private String nome;
	private String descricao;
	private float preco;
	private float precoMaterial;
	@ManyToOne
	@JoinColumn(name = "idVenda")
	private Venda venda;
	
	protected static int qtdeProduto;
	
	public Produto() {}
	
	public Produto (String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
		qtdeProduto++;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public float getPrecoMaterial() {
		return precoMaterial;
	}
	public void setPrecoMaterial(float precoMaterial) {
		this.precoMaterial = precoMaterial;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public static int obterQtdeProduto() {
		return qtdeProduto;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %s - %.2f - %.2f", this.codigo, this.nome, this.descricao, this.preco, this.precoMaterial);
	}
	
	public abstract void exibir();

}

