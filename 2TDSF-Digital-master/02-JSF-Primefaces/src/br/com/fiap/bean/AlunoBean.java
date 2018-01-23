package br.com.fiap.bean;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.fiap.bo.AlunoBO;
import br.com.fiap.entity.Aluno;
import br.com.fiap.exception.CommitErrorException;
import jdk.nashorn.internal.runtime.Context;

@ManagedBean
@SessionScoped
public class AlunoBean {

	private Aluno aluno;
	private AlunoBO bo;

	@PostConstruct
	private void init(){
		aluno = new Aluno();
		aluno.setDataNascimento(Calendar.getInstance());
		bo = new AlunoBO();
	}
	
	public void fileUpload(FileUploadEvent event){
		//Carrega a foto no banco de dados
		aluno.setFoto(event.getFile().getContents());
		//Carrega a foto no disco do servidor
		/*//Recupera o nome do arquivo
		String nome = event.getFile().getFileName();
		try{
			File file = new File("C:\\fotos\\",nome);
			FileOutputStream output = new FileOutputStream(file);
			output.write(event.getFile().getContents());
			output.close();
			aluno.setFoto(nome);
		}catch(Exception e){
			e.printStackTrace();
		}*/
	}

	public String alterar(){
		FacesMessage msg;
		try {
			bo.atualizar(aluno);
			msg = new FacesMessage("Atualizado!");
		} catch (CommitErrorException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");			
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "lista-aluno?faces-redirect=true";
	}
	
	public String cadastrar(){
		FacesMessage msg;
		try {
			bo.cadastrar(aluno);
			msg = new FacesMessage("Cadastrado!");
			init();
		} catch (CommitErrorException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");						
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "aluno?faces-redirect=true";
	}
	
	//retorna a imagem para exibir na página
	public StreamedContent getImagem(){
		DefaultStreamedContent content = 
							new DefaultStreamedContent();
		content.setContentType("image/jpg");

		try{
			if (FacesContext.getCurrentInstance().getRenderResponse()
					|| aluno.getFoto() == null){
				//Foto padrão
				content.setStream(
					new FileInputStream("C:\\fotos\\padrao.jpg"));
			}else{
				/*content.setStream(
					new FileInputStream("C:\\fotos\\" 
							+ aluno.getFoto()));*/
				content.setStream(
					new ByteArrayInputStream(aluno.getFoto()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return content;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
}
