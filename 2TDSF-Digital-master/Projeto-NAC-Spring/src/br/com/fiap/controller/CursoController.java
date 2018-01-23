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

import br.com.fiap.dao.CursoDAO;
import br.com.fiap.entity.Curso;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoDAO dao;
	
	@Transactional
	@PostMapping("editar")
	public ModelAndView editar(@Valid Curso curso,
			BindingResult result, RedirectAttributes redirect){
		if (result.hasErrors()){
			return new ModelAndView("curso/edicao");
		}else{
			dao.alterar(curso);
			redirect.addFlashAttribute("msg", "Atualizado");
			return new ModelAndView("redirect:/curso/listar");
		}
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id") int codigo){
		return new ModelAndView("curso/edicao")
				.addObject("curso", dao.pesquisar(codigo));
	}
	
	@GetMapping("listar")
	public ModelAndView listar(){
		return new ModelAndView("curso/lista")
				.addObject("cursos",dao.listar());
	}
	

	
	
}







