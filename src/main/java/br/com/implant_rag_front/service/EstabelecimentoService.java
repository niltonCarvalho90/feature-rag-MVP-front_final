package br.com.implant_rag_front.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_front.client.EstabelecimentoClient;
import br.com.implant_rag_front.dto.EstabelecimentoDTO;
import br.com.implant_rag_front.dto.FilialDTO;

@Service
public class EstabelecimentoService {
	@Autowired
	private EstabelecimentoClient estabelecimentoClient;
	
	public void cadastrar(EstabelecimentoDTO estabelecimento) {
		this.estabelecimentoClient.cadastrar(estabelecimento);
		
	}
	public void listar(EstabelecimentoDTO estabelecimento) {
		this.estabelecimentoClient.listar(estabelecimento);
	}
	public FilialDTO buscaFilial() {
		return this.estabelecimentoClient.buscaFilial();
		
	}
}
