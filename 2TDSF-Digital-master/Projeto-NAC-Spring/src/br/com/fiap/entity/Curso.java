package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="TB_CURSO_DIGITAL")
@SequenceGenerator(name="seqCurso",
sequenceName="SQ_TB_CURSO_DIGITAL",allocationSize=1)
public class Curso {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="seqCurso")
	private int codigo;
	
	@NotBlank
	private String nome;
	
	private int qualificacao;
	
	@Future
	private Calendar data;
	
	@Min(1)
	private int cargaHoraria;
	
	@DecimalMin("0")
	private double valor;
	
	public Curso() {
		super();
	}

	public Curso(String nome, int qualificacao, Calendar data, int cargaHoraria, double valor) {
		super();
		this.nome = nome;
		this.qualificacao = qualificacao;
		this.data = data;
		this.cargaHoraria = cargaHoraria;
		this.valor = valor;
	}

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

	public int getQualificacao() {
		return qualificacao;
	}

	public void setQualificacao(int qualificacao) {
		this.qualificacao = qualificacao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
