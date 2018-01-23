package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.model.Atleta;

@Controller
@RequestMapping("/atleta")
public class AtletaController {

	//Abre a tela de formul�rio
	@GetMapping("form")
	public String abreForm(){
		return "atleta/cadastro";
	}
	
	//Processar as informa��es do formul�rio
	@PostMapping("cadastrar")
	public ModelAndView processaForm(Atleta atleta){
		System.out.println(atleta.getNome());
		System.out.println(atleta.getPeso());
		System.out.println(atleta.getAltura());
		//Retorno para o usu�rio 				tela
		ModelAndView retorno = new ModelAndView("atleta/lista");
		retorno.addObject("a",atleta);
		return retorno;
	}
	
}





