package com.algaworks.cursojsf2.exercicio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class RegistroPartidaBean {
	// o objeto abaixo servirá para armazenar os dados que serão digitados nos campos do formulário
	private Partida partida = new Partida();
	
	// o objeto abaixo guardará uma lista de objetos do tipo Partida
	private List<Partida> listaDePartidas = new ArrayList<Partida>();
	
	public void incluirPartida() {
		this.listaDePartidas.add(this.partida);
		partida = new Partida();
	}

	public List<Partida> getListaDePartidas() {
		return listaDePartidas;
	}

	public Partida getPartida() {
		return partida;
	}
	public void limpar() {
		this.listaDePartidas.clear();
	}
}
