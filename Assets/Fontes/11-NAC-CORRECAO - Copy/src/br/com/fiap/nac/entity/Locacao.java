package br.com.fiap.nac.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Locacao")
@Table(name="NAC_LOCACAO")
@SequenceGenerator(name="locacao", sequenceName="SEQ_NAC_LOCACAO", allocationSize=1)
public class Locacao {

	@Id
	@Column(name="CODIGO")
	@GeneratedValue(generator="locacao", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="DATA_INICIO", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataInicio;
	
	@Column(name="DATA_FIM", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataFim;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="CLIENTE_CODIGO")
	private Cliente cliente;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="APARTAMENTO_CODIGO")
	private Apartamento apartamento;

	public Locacao() {

	}

	public Locacao(Calendar dataInicio, Calendar dataFim, Cliente cliente, Apartamento apartamento) {
		super();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.cliente = cliente;
		this.apartamento = apartamento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}
	
	
}
