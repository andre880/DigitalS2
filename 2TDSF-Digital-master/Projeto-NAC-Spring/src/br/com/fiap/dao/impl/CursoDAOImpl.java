package br.com.fiap.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.dao.CursoDAO;
import br.com.fiap.entity.Curso;

@Repository
public class CursoDAOImpl 
			extends GenericDAOImpl<Curso,Integer>
									implements CursoDAO{

	@Override
	public List<Curso> listar() {
		return em.createQuery("from Curso",
						Curso.class).getResultList();
	}

}