package br.com.fiap.dao.impl;

import org.springframework.stereotype.Repository;
import br.com.fiap.dao.SetorDAO;
import br.com.fiap.entity.Setor;

@Repository
public class SetorDAOImpl 
				extends GenericDAOImpl<Setor, Integer>
										implements SetorDAO{

}