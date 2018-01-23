package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.BotecoDAO;
import br.com.fiap.model.Boteco;

@Controller
@RequestMapping("/boteco")
public class BotecoController {

	@Autowired //Injeção de dependencia
	private BotecoDAO dao;
	
	@GetMapping("alterar/{id}")
	public ModelAndView abreForm(@PathVariable("id") int id){
		ModelAndView retorno = 
				new ModelAndView("boteco/alteracao");
		retorno.addObject("boteco", dao.buscar(id));
		return retorno;
	}
	
	@Transactional
	@PostMapping("alterar")
	public ModelAndView processa(Boteco boteco, RedirectAttributes redirect){
		dao.atualizar(boteco);
		ModelAndView retorno = 
				new ModelAndView("redirect:/boteco/listar");
		redirect.addFlashAttribute("msg", "Atualizado");
		return retorno;
	}
	
	@GetMapping("cadastrar")
	public ModelAndView abrirForm(Boteco boteco){
		return new ModelAndView("boteco/cadastro")
					.addObject("boteco",boteco);
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processaForm(@Valid Boteco boteco,
								BindingResult result,
								RedirectAttributes redirect){
		ModelAndView retorno;
		if (result.hasErrors()){
			retorno = new ModelAndView("boteco/cadastro");
		}else{
			dao.cadastrar(boteco);
			retorno = new ModelAndView("redirect:/boteco/listar");
			redirect.addFlashAttribute("msg", "Boteco cadastrado!");
		}
		return retorno;
	}
	
	@GetMapping("listar")
	public ModelAndView listar(){
		ModelAndView retorno = new ModelAndView("boteco/lista");
		retorno.addObject("botecos",dao.listar());		
		return retorno;
	}
	
}




