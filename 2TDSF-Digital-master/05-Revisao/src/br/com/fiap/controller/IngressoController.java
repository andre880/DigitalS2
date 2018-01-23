package br.com.fiap.controller;

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

import br.com.fiap.dao.IngressoDAO;
import br.com.fiap.dao.SetorDAO;
import br.com.fiap.entity.Ingresso;

@Controller
@RequestMapping("/ingresso")
public class IngressoController {

	@Autowired
	private IngressoDAO ingressoDao;
	
	@Autowired
	private SetorDAO setorDao;
	
	@GetMapping("listar")
	public ModelAndView listar(){
		return new ModelAndView("ingresso/lista")
				.addObject("lista", ingressoDao.listar());
	}
	
	@GetMapping("cadastrar")
	public ModelAndView cadastrar(){
		return new ModelAndView("ingresso/cadastro")
				.addObject("ingresso", new Ingresso())
				.addObject("setores", setorDao.listar());
	}
		
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(@Valid Ingresso ingresso,
			BindingResult result, RedirectAttributes redirect){
		if (result.hasErrors()){
			return new ModelAndView("ingresso/cadastro")
					.addObject("setores", setorDao.listar());
		}else{
			ingressoDao.cadastrar(ingresso);
			redirect.addFlashAttribute("msg", "Cadastrado!");
			return new ModelAndView("redirect:/ingresso/cadastrar");
		}
	}
	
	
}
