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

import br.com.fiap.dao.CervejaDAO;
import br.com.fiap.dao.TipoCervejaDAO;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.model.Cerveja;
import br.com.fiap.model.Recipiente;

@Controller
@RequestMapping("/cerveja")
public class CervejaController {

	@Autowired
	private CervejaDAO dao;
	
	@Autowired
	private TipoCervejaDAO tipoDao;
	
	@Transactional
	@GetMapping("excluir/{id}")
	public ModelAndView processaExclusao(
							@PathVariable("id") int id,
							RedirectAttributes redirect){
		try {
			dao.excluir(id);
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
		}
		redirect.addFlashAttribute("msg", "Removido!");
		return new ModelAndView("redirect:/cerveja/listar");
	}
	
	@Transactional
	@PostMapping("alterar")
	public ModelAndView processaAlterar(Cerveja cerveja,
			RedirectAttributes redirect){
		dao.atualizar(cerveja);
		redirect.addFlashAttribute("msg", "Atualizado");
		return new ModelAndView("redirect:/cerveja/listar");
	}
	
	@GetMapping("alterar/{id}")
	public ModelAndView abrirForm(@PathVariable("id") int id){
		ModelAndView retorno = 
					new ModelAndView("cerveja/alteracao");
		retorno.addObject("cerveja", dao.buscar(id));
		return retorno;
	}
	
	@GetMapping("cadastrar")
	public ModelAndView abrirForm(){
		return new ModelAndView("cerveja/cadastro")
					.addObject("tipos",tipoDao.listar())
					.addObject("recipientes",Recipiente.values())	
					.addObject("cerveja", new Cerveja());
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processaForm(@Valid Cerveja cerveja,
								BindingResult result,
								RedirectAttributes redirect){
		ModelAndView retorno;
		if (result.hasErrors()){
			retorno = new ModelAndView("cerveja/cadastro")
					.addObject("recipientes",Recipiente.values())	
					.addObject("tipos", tipoDao.listar());
		}else{
			dao.cadastrar(cerveja);
			redirect.addFlashAttribute("msg","Cadastrado!");
			retorno = new ModelAndView("redirect:/cerveja/listar");
		}
		return retorno;
	}
	
	@GetMapping("listar")
	public ModelAndView listar(){
		ModelAndView retorno = new ModelAndView("cerveja/lista");
		retorno.addObject("cervejas", dao.listar());
		return retorno;
	}
}






