package br.com.fiap.nac.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.nac.dao.ApartamentoDAO;
import br.com.fiap.nac.dao.ClienteDAO;
import br.com.fiap.nac.dao.LocacaoDAO;
import br.com.fiap.nac.dao.impl.ApartamentoDAOImpl;
import br.com.fiap.nac.dao.impl.ClienteDAOImpl;
import br.com.fiap.nac.dao.impl.LocacaoDAOImpl;
import br.com.fiap.nac.entity.Apartamento;
import br.com.fiap.nac.entity.Cliente;
import br.com.fiap.nac.entity.Locacao;
import br.com.fiap.nac.entity.Sexo;
import br.com.fiap.nac.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		ApartamentoDAO apartamentoDao = new ApartamentoDAOImpl(em);
		LocacaoDAO locacaoDao = new LocacaoDAOImpl(em);
		
		Cliente cliente = new Cliente("Gabriel", new GregorianCalendar(28, Calendar.MARCH, 1999), Sexo.MASCULINO);
		Apartamento apartamento = new Apartamento("Av. Paulista, 1124", "Consolacao", null);
		Locacao locacao = new Locacao(new GregorianCalendar(12, Calendar.APRIL, 2013), new GregorianCalendar(12, Calendar.APRIL, 2013), cliente, apartamento);

		try {
			clienteDao.cadastrar(cliente);
			apartamentoDao.cadastrar(apartamento);
			locacaoDao.cadastrar(locacao);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}

}
