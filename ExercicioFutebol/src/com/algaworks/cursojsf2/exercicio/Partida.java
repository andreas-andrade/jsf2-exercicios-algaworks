package com.algaworks.cursojsf2.exercicio;

import java.math.BigDecimal;
import java.util.Date;

public class Partida {
	private Date dataDaPartida;
	private String nomeTimeDaCasa;
	private Integer golsMarcadosPeloTimeDaCasa;
	private String nomeDoVisitante;
	private Integer golsMarcadosPeloVisitante;
	private BigDecimal valorArrecadado;
	
	// ---------------------------------------------
	
	public Date getDataDaPartida() {
		return dataDaPartida;
	}
	public void setDataDaPartida(Date dataDaPartida) {
		this.dataDaPartida = dataDaPartida;
	}
	public String getNomeTimeDaCasa() {
		return nomeTimeDaCasa;
	}
	public void setNomeTimeDaCasa(String nomeTimeDaCasa) {
		this.nomeTimeDaCasa = nomeTimeDaCasa;
	}
	public Integer getGolsMarcadosPeloTimeDaCasa() {
		return golsMarcadosPeloTimeDaCasa;
	}
	public void setGolsMarcadosPeloTimeDaCasa(Integer golsMarcadosPeloTimeDaCasa) {
		this.golsMarcadosPeloTimeDaCasa = golsMarcadosPeloTimeDaCasa;
	}
	public String getNomeDoVisitante() {
		return nomeDoVisitante;
	}
	public void setNomeDoVisitante(String nomeDoVisitante) {
		this.nomeDoVisitante = nomeDoVisitante;
	}
	public Integer getGolsMarcadosPeloVisitante() {
		return golsMarcadosPeloVisitante;
	}
	public void setGolsMarcadosPeloVisitante(Integer golsMarcadosPeloVisitante) {
		this.golsMarcadosPeloVisitante = golsMarcadosPeloVisitante;
	}
	public BigDecimal getValorArrecadado() {
		return valorArrecadado;
	}
	public void setValorArrecadado(BigDecimal valorArrecadado) {
		this.valorArrecadado = valorArrecadado;
	}
	
	// --------------------------------------------
}
