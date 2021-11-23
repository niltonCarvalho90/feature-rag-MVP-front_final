package br.com.implant_rag_front.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_front.client.OperadoraClient;
import br.com.implant_rag_front.dto.OperadoraDTO;

@Service
public class OperadoraService {
	
	@Autowired
	private OperadoraClient operadoraClient;

	public void cadastrar(OperadoraDTO operadora) {
		this.operadoraClient.cadastrar(operadora);
	}
	
	public List<OperadoraDTO> listar() {
		
		return this.operadoraClient.listarOperadora();
		
		
	}
}
