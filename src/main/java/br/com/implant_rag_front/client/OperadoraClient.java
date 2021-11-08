package br.com.implant_rag_front.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.implant_rag_front.dto.OperadoraDTO;
import br.com.implant_rag_front.util.JsfUtil;

@Service
public class OperadoraClient {

	public void cadastrar(OperadoraDTO operadora) {
		try {
			HttpEntity<OperadoraDTO> operadoraJson = new HttpEntity<>(operadora);
			RestTemplate rest = new RestTemplate();
			ResponseEntity<String> response = rest.postForEntity(
					"http://localhost:8000/implant_rag_back/operadora/salvar", operadoraJson, String.class);
			JsfUtil.adicionarMensagemDeSucesso("Operadora cadastrada com sucesso");

		} catch (Exception ex) {
			ex.printStackTrace();
			JsfUtil.adicionarMensagemDeErro(ex.getMessage());
		}
	}	
}
