package br.com.implant_rag_front.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.implant_rag_front.dto.ClienteDTO;
import br.com.implant_rag_front.dto.EstabelecimentoDTO;
import br.com.implant_rag_front.dto.FilialDTO;
import br.com.implant_rag_front.responseDTO.ClienteResponse;
import br.com.implant_rag_front.responseDTO.EstabelecimentoResponse;
import br.com.implant_rag_front.responseDTO.FilialResponse;

@Service
public class FilialClient {

	public void cadastrar(FilialDTO filial) {
		HttpEntity<FilialDTO> filialJson = new HttpEntity<>(filial);
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.postForEntity("http://localhost:8000/implant_rag_back/filial/cadastrar", filialJson, String.class);
	}
	public List<FilialDTO> listar() {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<FilialResponse> response = rest.getForEntity("http://localhost:8000/implant_rag_back/filial/listar", FilialResponse.class);		
		List<FilialDTO> filiais = response.getBody().getFiliais();
		List<FilialDTO> filiaisComEstabelecimentos = new ArrayList<FilialDTO>();
		
		for (FilialDTO filial : filiais) {
			filial.setEstabelecimentos(listarEstabelecimentos(filial).getEstabelecimentos());
			filiaisComEstabelecimentos.add(filial);
		}
						
		return filiaisComEstabelecimentos;
		
	}
	public void editar(FilialDTO filial) {
		HttpEntity<FilialDTO> filialJson = new HttpEntity<>(filial);
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.postForEntity("http://localhost:8000/implant_rag_back/filial/editar", filialJson, String.class);
		
		
	}
	public FilialDTO listarEstabelecimentos(FilialDTO filial){
		RestTemplate rest = new RestTemplate();
		ResponseEntity<EstabelecimentoResponse> response = rest.getForEntity("http://localhost:8000/implant_rag_back/estabelecimento/listar", EstabelecimentoResponse.class);		
		List<EstabelecimentoDTO> estabelecimentos = new ArrayList<EstabelecimentoDTO>(response.getBody().getEcs());
		//System.out.println(estabelecimentos);
		ArrayList<EstabelecimentoDTO> estabelecimentosNaFilial = new ArrayList<EstabelecimentoDTO>();
		
		for (EstabelecimentoDTO estabelecimento : estabelecimentos) {
			if(estabelecimento.getFilial().getId() == filial.getId()) {
				estabelecimentosNaFilial.add(estabelecimento);
				filial.setEstabelecimentos(estabelecimentosNaFilial);
			}
		}
		
						
		return filial;
	}
	public ClienteDTO buscarCliente(Integer codigo) {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<ClienteResponse> response = rest.getForEntity("http://localhost:8000/implant_rag_back/clientes/listarPorCod/" + codigo, ClienteResponse.class);
		return response.getBody().getClientes().get(0);
	}
	
	public List<FilialDTO> listarPorCliente(Integer codigo){
		RestTemplate rest = new RestTemplate();
		ResponseEntity<FilialResponse> response = rest.getForEntity("http://localhost:8000/implant_rag_back/filial/listarFiliais/" + codigo, FilialResponse.class);		
		List<FilialDTO> filiais = response.getBody().getFiliais();
		List<FilialDTO> filiaisComEstabelecimentos = new ArrayList<FilialDTO>();
		for (FilialDTO filial : filiais) {
			filial.setEstabelecimentos(listarEstabelecimentos(filial).getEstabelecimentos());
			filiaisComEstabelecimentos.add(filial);
		}
						
		return filiaisComEstabelecimentos;
	}
}
