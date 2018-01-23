package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@SequenceGenerator(name="seqIngresso",sequenceName="SQ_T_INGRESSO",allocationSize=1)
public class Ingresso {

	@Id
	@GeneratedValue(generator="seqIngresso",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@NotBlank
	private String cadeira;
	
	@Future
	private Calendar data;
	
	@ManyToOne
	private Setor setor;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCadeira() {
		return cadeira;
	}

	public void setCadeira(String cadeira) {
		this.cadeira = cadeira;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
}
