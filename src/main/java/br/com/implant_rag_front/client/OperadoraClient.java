package br.com.implant_rag_front.client;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.implant_rag_front.dto.OperadoraDTO;
import br.com.implant_rag_front.responseDTO.OperadoraResponse;
import br.com.implant_rag_front.util.JsfUtil;

@Service
public class OperadoraClient {

	public void cadastrar(OperadoraDTO operadora) {

		HttpEntity<OperadoraDTO> operadoraJson = new HttpEntity<>(operadora);
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.postForEntity("http://localhost:8000/implant_rag_back/operadora/salvar",
				operadoraJson, String.class);

		if (response.hasBody()) {
			JsfUtil.adicionarMensagemDeSucesso("Operadora cadastrada com sucesso");
		} else {
			JsfUtil.adicionarMensagemDeErro("Operadora j� cadastrada");
		}

	}

	public List<OperadoraDTO> listarOperadora() {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<OperadoraResponse> response = rest.getForEntity("http://localhost:8000/implant_rag_back/operadora/listar", OperadoraResponse.class);
		List<OperadoraDTO> operadoras = response.getBody().getOperadoras();

		return operadoras;
	}
	
	public void remover(Long id) {
	
		/*RestTemplate rest = new RestTemplate();
		ResponseEntity<?> response = rest.void delete(String url, Object... urlVariables) throws RestClientException {
	        execute("http://localhost:8000/implant_rag_back/operadora/deletar", HttpMethod.DELETE, null, null, urlVariables);
*/
	}
	
	

}
