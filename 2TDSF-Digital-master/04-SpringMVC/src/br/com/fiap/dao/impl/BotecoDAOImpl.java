package br.com.fiap.dao.impl;

import org.springframework.stereotype.Repository;
import br.com.fiap.dao.BotecoDAO;
import br.com.fiap.model.Boteco;

@Repository
public class BotecoDAOImpl 
				extends GenericDAOImpl<Boteco, Integer>
										implements BotecoDAO{

}