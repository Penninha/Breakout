package br.com.fiap.nac.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.nac.entity.Locacao;

public interface LocacaoDAO extends GenericDAO<Locacao, Integer>{

	List<Locacao> buscarDataInicio(Calendar dataUm, Calendar dataDois);
	
	int buscarPorCliente(int codigoCliente);
}
