package br.com.fiap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@SequenceGenerator(name="seqSetor",sequenceName="SQ_T_SETOR",allocationSize=1)
public class Setor {

	@Id
	@GeneratedValue(generator="seqSetor",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@NotBlank
	private String nome;
	
	@DecimalMin("0")
	private float valor;

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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
}