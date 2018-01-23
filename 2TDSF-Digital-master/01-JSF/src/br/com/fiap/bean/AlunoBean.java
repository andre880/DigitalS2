package br.com.fiap.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.fiap.bo.AlunoBO;
import br.com.fiap.entity.Aluno;
import br.com.fiap.exception.CommitErrorException;

@ManagedBean
public class AlunoBean {

	private Aluno aluno;

	private AlunoBO bo;
	
	@PostConstruct
	private void init(){
		aluno = new Aluno();
		aluno.setDataNascimento(Calendar.getInstance());
		
		bo = new AlunoBO();
	}
	
	//M�todo para validar o campo de e-mail
	public void validarEmail(FacesContext context, 
					UIComponent component, Object value)
								throws ValidatorException{
		String email = value.toString();
		if (bo.validarEmailExistente(email)){
			throw new ValidatorException(
					new FacesMessage("Email j� cadastrado"));
		}
	}
	
	public String cadastrar(){
		FacesMessage msg;
		try {
			bo.cadastrar(aluno);
			msg = new FacesMessage("Cadastrado!");
		} catch (CommitErrorException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
								.getFlash().setKeepMessages(true);
		return "aluno?faces-redirect=true";
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
}
