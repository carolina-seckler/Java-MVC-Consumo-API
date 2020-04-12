package br.edu.infnet.vendamvc.model.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.edu.infnet.vendamvc.auxiliar.Constante;

@Entity
@Table(name = "TVenda")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int dia;
	private int mes;
	private int ano;
	@OneToOne(
			fetch = FetchType.EAGER,
			cascade = CascadeType.DETACH
			)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@OneToMany(
			mappedBy = "venda",
			fetch = FetchType.EAGER,
			cascade = CascadeType.PERSIST
			)
	private List<Produto> produtos;
	
	private int[] qtdeProdutos;
	
	public Venda () {
		produtos = new ArrayList<Produto>();
	}
	
	public Venda(int dia, int mes, int ano) {
		this();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		retorno.append(String.format("Data: %d/%d/%d", this.dia, this.mes, this.ano));
		retorno.append(String.format("<br>&nbsp&nbspCliente: %s", this.getCliente()));
		retorno.append("<br>&nbsp&nbspProdutos: ");
		for (Produto produto : this.getProdutos()){
			retorno.append(String.format("<br>&nbsp&nbsp%s", produto));
		}
		return retorno.toString();
	}
	
	public void exibir() {
		if(this.validar()) {
			this.qtdeProdutos = new int[Constante.PRODUTOS.length];
			System.out.println("Venda:");
			System.out.println(this);
			this.cliente.exibir();
			for(Produto item : produtos) {
				this.contabiliza(item);
				item.exibir();
			}
			this.showContabiliza();
		} else {
			System.err.println("Inválido");
		}
	}
	
	private boolean validar () {
		return this.getProdutos().size() == Produto.obterQtdeProduto();
	}
	
	private void contabiliza(Produto produto) {
		if(produto instanceof Tecido) {
			this.qtdeProdutos[0]++;
		}else if (produto instanceof Cartonagem) {		
			this.qtdeProdutos[1]++;
		}else if (produto instanceof Hibrido) {
			this.qtdeProdutos[2]++;
		}
	}
	
	private void showContabiliza() {
		System.out.println("Contabiliza:");		
		for (int i = 0; i < qtdeProdutos.length; i++) {
			System.err.println("- " + 
					Constante.PRODUTOS[i] + ": " + 
					this.qtdeProdutos[i]
				);
		}
	}
	
	public void associa(Cliente cliente) {
		this.cliente = cliente;
	}

	public void adiciona(Produto produto) {
		this.getProdutos().add(produto);
	}

}
