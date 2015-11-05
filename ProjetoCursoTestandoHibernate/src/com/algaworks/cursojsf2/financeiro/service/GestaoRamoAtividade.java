package com.algaworks.cursojsf2.financeiro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algaworks.cursojsf2.financeiro.model.RamoAtividade;

public class GestaoRamoAtividade {
private static Map<Integer, RamoAtividade> ramosDeAtividade = new HashMap<Integer, RamoAtividade>();
	
	static {
		ramosDeAtividade.put(1, new RamoAtividade(1, "TI"));
		ramosDeAtividade.put(2, new RamoAtividade(2, "Costureira"));
		ramosDeAtividade.put(3, new RamoAtividade(3, "Advogado"));
		ramosDeAtividade.put(4, new RamoAtividade(4, "Técnico"));
		ramosDeAtividade.put(5, new RamoAtividade(5, "Eletricista"));
	}
	
	public List<RamoAtividade> listarTodas() {
		List<RamoAtividade> ramos = new ArrayList<RamoAtividade>();
		ramos.addAll(GestaoRamoAtividade.ramosDeAtividade.values());
		return ramos;
	}
	
	public RamoAtividade buscarPorCodigo(Integer codigo) {
		return ramosDeAtividade.get(codigo);
	}
	
}
