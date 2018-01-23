package br.com.fiap.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@SequenceGenerator(name="seqCerveja",sequenceName="SQ_T_CERVEJA",allocationSize=1)
public class Cerveja {

	@Id
	@GeneratedValue(generator="seqCerveja",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@ManyToOne
	private TipoCerveja tipo;
	
	private Recipiente recipiente;
	
	@NotEmpty
	@Size(max=50)
	private String nome;
	
	@NotEmpty
	private String marca;
	
	@DecimalMin("0")
	private float preco;
	
	@DecimalMin("2")
	private float teorAlcoolico;

	@Future
	@Temporal(TemporalType.DATE)
	private Calendar dataValidade;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(float teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public TipoCerveja getTipo() {
		return tipo;
	}

	public void setTipo(TipoCerveja tipo) {
		this.tipo = tipo;
	}

	public Recipiente getRecipiente() {
		return recipiente;
	}

	public void setRecipiente(Recipiente recipiente) {
		this.recipiente = recipiente;
	}
	
}
