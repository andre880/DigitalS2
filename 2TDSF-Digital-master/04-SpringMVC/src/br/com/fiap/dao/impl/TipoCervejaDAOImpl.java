package br.com.fiap.dao.impl;

import org.springframework.stereotype.Repository;
import br.com.fiap.dao.TipoCervejaDAO;
import br.com.fiap.model.TipoCerveja;

@Repository
public class TipoCervejaDAOImpl 
				extends GenericDAOImpl<TipoCerveja, Integer>
								implements TipoCervejaDAO{

}
