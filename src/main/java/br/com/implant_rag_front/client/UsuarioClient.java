package br.com.implant_rag_front.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.implant_rag_front.dto.UsuarioDTO;

@Service
public class UsuarioClient {

	public void logar(UsuarioDTO usuario) {
		HttpEntity<UsuarioDTO> operadoraJson = new HttpEntity<>(usuario);
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> response = rest.postForEntity("http://localhost:8000/implant_rag_back/usuario/logar", operadoraJson, String.class);
	}

	
}
