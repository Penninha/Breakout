package br.com.fiap.nac.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Apartamento")
@Table(name="NAC_APARTAMENTO")
@SequenceGenerator(name="apartamento", sequenceName="SEQ_NAC_APARTAMENTO", allocationSize=1)
public class Apartamento {

	@Id
	@Column(name="CODIGO")
	@GeneratedValue(generator="apartamento", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ENDERECO", length=150, nullable=false)
	private String endereco;
	
	@Column(name="DETALHES", length=300)
	private String detalhes;
	
	@Lob
	@Column(name="FOTO")
	private byte[] foto;

	@OneToMany(mappedBy="apartamento", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Locacao> locacoes;
	
	public Apartamento() {

	}

	public Apartamento(String endereco, String detalhes, byte[] foto) {
		this.endereco = endereco;
		this.detalhes = detalhes;
		this.foto = foto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}
	
	
}
