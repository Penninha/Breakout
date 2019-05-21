package br.com.fiap.nac.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.nac.dao.LocacaoDAO;
import br.com.fiap.nac.entity.Locacao;

public class LocacaoDAOImpl extends GenericDAOImpl<Locacao, Integer> implements LocacaoDAO{

	public LocacaoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Locacao> buscarDataInicio(Calendar dataUm, Calendar dataDois) {
		Query q = em.createQuery("from Locacao l where l.DATA_INICIO between :dataUm and :dataDois");
		q.setParameter("dataUm", dataUm);
		q.setParameter("dataDois", dataDois);
		return q.getResultList();
	}

	@Override
	public int buscarPorCliente(int codigoCliente) {
		Query q = em.createQuery("select count(*) from Locacao l where l.CLIENTE_CODIGO = :idCliente");
		q.setParameter("idCliente", codigoCliente);
		int total = (Integer)q.getSingleResult();
		return total;
	}
}
