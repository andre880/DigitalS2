package br.com.fiap.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@SequenceGenerator(name="seqBoteco",
sequenceName="SQ_T_BOTECO",allocationSize=1)
public class Boteco {

	@Id
	@GeneratedValue(generator="seqBoteco",
	strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@NotNull
	@Size(min=2)
	private String nome;
	
	@NotEmpty
	private String endereco;
	
	private boolean taxaServico;
	
	@DecimalMin("0")
	private float entrada;
	
	@Past
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataInauguracao; 

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean isTaxaServico() {
		return taxaServico;
	}

	public void setTaxaServico(boolean taxaServico) {
		this.taxaServico = taxaServico;
	}

	public float getEntrada() {
		return entrada;
	}

	public void setEntrada(float entrada) {
		this.entrada = entrada;
	}

	public Calendar getDataInauguracao() {
		return dataInauguracao;
	}

	public void setDataInauguracao(Calendar dataInauguracao) {
		this.dataInauguracao = dataInauguracao;
	}

}
