package br.com.implant_rag_front.client;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.implant_rag_front.dto.UsuarioDTO;
import br.com.implant_rag_front.responseDTO.UsuarioResponse;

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
	
	public int  cadastrar(UsuarioDTO usuario, int codigo, String email) {
		
		
		HttpEntity<UsuarioDTO> usuarioDTO = new HttpEntity<>(usuario);
		RestTemplate rest = new RestTemplate();
		ResponseEntity<Integer> response = rest.postForEntity("http://localhost:8000/implant_rag_back/usuarios/salvar/" + codigo + "/" + email  , usuarioDTO, Integer.class);
			
		System.out.println(response.getBody());
	
	
		if(response.getBody() == 0) {
			
				return 0;

		}else if(response.getBody() == 1 ){
			
				return 1;
				
		}else if(response.getBody() == 2 ) {
			
				return 2;
		}
	
		return 4;
	
	
}
	
	
	public List<UsuarioDTO> listarUsuariosPorEmail(String email){
		 RestTemplate rest = new RestTemplate();
		 ResponseEntity<UsuarioResponse> response = rest.getForEntity("http://localhost:8000/implant_rag_back/usuarios/login/" + email , UsuarioResponse.class);
		 
		 	return response.getBody().getUsuarios();
		}


	
	
}
