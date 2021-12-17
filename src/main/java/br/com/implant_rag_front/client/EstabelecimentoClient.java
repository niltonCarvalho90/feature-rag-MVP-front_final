package br.com.implant_rag_front.client;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.implant_rag_front.dto.EstabelecimentoDTO;
import br.com.implant_rag_front.dto.FilialDTO;
import br.com.implant_rag_front.responseDTO.FilialResponse;

@Service
public class EstabelecimentoClient {
	
	public void cadastrar(EstabelecimentoDTO estabelecimento) {
		HttpEntity<EstabelecimentoDTO> estabelecimentoJson = new HttpEntity<>(estabelecimento);
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.postForEntity("http://localhost:8000/implant_rag_back/estabelecimento/cadastrar", estabelecimentoJson, String.class);
	}
	
	public void listar(EstabelecimentoDTO estabelecimento) {
		
	}
	
	public FilialDTO buscaFilial() {
		FilialDTO filial = new FilialDTO();
		RestTemplate rest = new RestTemplate();
		ResponseEntity<FilialResponse> response = rest.getForEntity("http://localhost:8000/implant_rag_back/filial/listar", FilialResponse.class);		
		List<FilialDTO> filiais = response.getBody().getFiliais();
		System.out.println(filiais);
		//System.out.println("CHEGUEI AQUI");
		filial = filiais.get((filiais.size()-1));
		return filial;
	}

}
