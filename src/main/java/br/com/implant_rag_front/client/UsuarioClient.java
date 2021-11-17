package br.com.implant_rag_front.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioClient {

	public Boolean logar( String email, String senha) {


		RestTemplate rest = new RestTemplate();
		ResponseEntity<Boolean> response = rest.getForEntity("http://localhost:8000/implant_rag_back/usuarios/login/" + email + "/" + senha,   Boolean.class);
		
		if(response.getBody() == true){
			return true;
			
		}else if(response.getBody() == false){
			return false;
		}
		return null;
	}
	
	
}
