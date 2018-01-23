package br.com.fiap.controller;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.SetorDAO;
import br.com.fiap.entity.Setor;

@Controller
@RequestMapping("/setor")
public class SetorController {

	@Autowired
	private SetorDAO dao;
	
	@GetMapping("cadastrar")
	public ModelAndView cadastrar(){
		return new ModelAndView("setor/cadastro")
				.addObject("setor", new Setor());
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(@Valid Setor setor,
			BindingResult result, RedirectAttributes redirect){
		if (result.hasErrors()){
			return new ModelAndView("setor/cadastro");
		}else{
			dao.cadastrar(setor);
			redirect.addFlashAttribute("msg", "Cadastrado");
			return new ModelAndView("redirect:/setor/cadastrar");
		}
	}
	
}
