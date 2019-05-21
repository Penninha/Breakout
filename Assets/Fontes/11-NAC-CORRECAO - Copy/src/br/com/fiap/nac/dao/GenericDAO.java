package br.com.fiap.nac.dao;

import java.util.List;

import br.com.fiap.nac.exception.DBException;
import br.com.fiap.nac.exception.IdNotFoundException;

public interface GenericDAO<T,K> {

	void cadastrar(T entity);
	void remover(K codigo) throws IdNotFoundException;
	T pesquisar(K codigo);
	void alterar(T entity);
	
	List<T> listar();
	void salvar() throws DBException;
	
}
