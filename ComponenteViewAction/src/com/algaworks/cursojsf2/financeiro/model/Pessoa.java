package com.algaworks.cursojsf2.financeiro.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_pessoa")
public class Pessoa implements Serializable {

	private Integer codigo;
	private String nome;
	private TipoPessoa tipo;
	private RamoAtividade ramoDeAtividade;
	private String email;
	private Date dataDeNascimento;

	public Pessoa() {
	}

	public Pessoa(Integer codigo, String nome, TipoPessoa tipo) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
	}
	
	@Id
	@SequenceGenerator(name="pessoa_codigo_sequence", sequenceName="tb_pessoa_codigo_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pessoa_codigo_sequence")
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="data_nascimento")
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	@ManyToOne
	@JoinColumn(name = "cod_ramo_atividade")
	public RamoAtividade getRamoDeAtividade() {
		return ramoDeAtividade;
	}

	public void setRamoDeAtividade(RamoAtividade ramoDeAtividade) {
		this.ramoDeAtividade = ramoDeAtividade;
	}

	@Enumerated(EnumType.STRING)
	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime
				* result
				+ ((dataDeNascimento == null) ? 0 : dataDeNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((ramoDeAtividade == null) ? 0 : ramoDeAtividade.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataDeNascimento == null) {
			if (other.dataDeNascimento != null)
				return false;
		} else if (!dataDeNascimento.equals(other.dataDeNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ramoDeAtividade == null) {
			if (other.ramoDeAtividade != null)
				return false;
		} else if (!ramoDeAtividade.equals(other.ramoDeAtividade))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	

}