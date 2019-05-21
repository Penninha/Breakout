package br.com.fiap.nac.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.nac.dao.ApartamentoDAO;
import br.com.fiap.nac.entity.Apartamento;

public class ApartamentoDAOImpl extends GenericDAOImpl<Apartamento, Integer> implements ApartamentoDAO{

	public ApartamentoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Apartamento> buscarPorDesc(String detalhes) {
		Query q = em.createQuery("from Apartamento a where a.DETALHES like :detalhes");
		q.setParameter("detalhes", "%"+detalhes+"%");
		return null;
	}

}
