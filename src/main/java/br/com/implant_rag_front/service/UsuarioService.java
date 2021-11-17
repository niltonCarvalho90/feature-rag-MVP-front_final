package br.com.implant_rag_front.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_front.client.UsuarioClient;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioClient usuarioClient;

	public Boolean validar(String email, String senha) {
		return this.usuarioClient.logar( email, senha);
	}
}
